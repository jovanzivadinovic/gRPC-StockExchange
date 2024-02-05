package com.berza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.berza.grpc.AskData;
import com.berza.grpc.AskList;
import com.berza.grpc.OfferList;
import com.berza.grpc.AskReq;
import com.berza.grpc.BerzaServiceGrpc.BerzaServiceImplBase;
import com.berza.grpc.BidList;
import com.berza.grpc.ClientInfo;
import com.berza.grpc.Company;
import com.berza.grpc.CompanyList;
import com.berza.grpc.None;
import com.berza.grpc.OfferRequest;
import com.berza.grpc.OrderRequest;
import com.berza.grpc.OrderResponse;
import com.berza.grpc.RegisterResponse;
import com.berza.grpc.StockInfo;
import com.berza.grpc.SubscriptionRequest;
import com.berza.grpc.UpdateStockAmountsRequest;
import com.berza.grpc.UpdateStockAmountsResponse;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import javax.validation.constraints.Null;

public class BerzaServer {
	
	
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	    BerzaServer.BerzaServiceImpl berzaServiceImpl = new BerzaServer.BerzaServiceImpl();

		
		Server server = ServerBuilder
		          .forPort(8090)
		          .addService(berzaServiceImpl).build();

        server.start();

        new Thread(berzaServiceImpl::startSocketServer).start();

        
        
    	berzaServiceImpl.scheduleDoneTradesUpdate();
		berzaServiceImpl.sendTcpStockUpdates();


		server.awaitTermination();

        
    }
	
	
	
	

	static class BerzaServiceImpl extends BerzaServiceImplBase{
		private final ConcurrentHashMap<String, Company> companyMap = new ConcurrentHashMap<String, Company>();
		private final ConcurrentHashMap<Company, String> subscriptions = new ConcurrentHashMap<Company, String>();
	    private final Map<String, ClientInfo> registeredClients = new ConcurrentHashMap<>();
	    private final Map<String, Socket> connections = new ConcurrentHashMap<>();
	    private final Map<String, OrderRequest> orders = new ConcurrentHashMap<>();
	    private final Map<String, OrderRequest> doneTrades = new ConcurrentHashMap<>();
	    int count = 0;


	    private void startSocketServer() {
	        try (ServerSocket serverSocket = new ServerSocket(8888)) {
	            System.out.println("Socket server started on port 8888");
	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("New client connected: " + clientSocket.getInetAddress());
	                new Thread(() -> handleSocketClient(clientSocket)).start();
	                //sendTcpStockUpdates();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	    private void handleSocketClient(Socket clientSocket) {
	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
	            
	        	String userId = reader.readLine();
	            connections.put(userId, clientSocket);
	            
	            
	            
	            

	            while (true) {
	                if (clientSocket.isClosed()) {
	                    System.out.println("Client disconnected: " + clientSocket.getInetAddress() + " User: " + userId);
	                    connections.remove(userId);
	                    registeredClients.remove(userId);
	                    break;
	                }
	                
	                Thread.sleep(1000);
	            }

	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private void sendTcpStockUpdates() {
	    	
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                	
                    for (Entry<Company, String> entry : subscriptions.entrySet()) {
						String clientId = entry.getValue();
						Company sub = entry.getKey();
						for (Entry<String, Company> c : companyMap.entrySet()) {
							if(c.getValue().getSymbol().equals(sub.getSymbol())){
								Company company = c.getValue();
								String updateMessage = company.getSymbol() +" " +company.getPrice()+" ";
								updateMessage += company.getChange() >= 0 ? "\u001B[32m" + String.format("%.2f", (company.getChange()*100)/(company.getPrice()-company.getChange()))+"%" + "\u001B[0m" : "\u001B[31m" + String.format("%.2f", (company.getChange()*100)/(company.getPrice()-company.getChange()))+"%"  + "\u001B[0m" + " ";
								if (count>=168) {
									updateMessage += company.getPrice()-company.getHistory(count-168) >= 0 ? "\u001B[32m" + String.format("%.2f", ((company.getPrice()-company.getHistory(count-168))*100)/(company.getPrice()-(company.getPrice()-company.getHistory(count-168))))+"%" + "\u001B[0m" : "\u001B[31m" + String.format("%.2f", ((company.getPrice()-company.getHistory(count-168))*100)/(company.getPrice()-(company.getPrice()-company.getHistory(count-168))))+"%"  + "\u001B[0m" + " ";
									updateMessage += company.getPrice()-company.getHistory(count-24) >= 0 ? "\u001B[32m" + String.format("%.2f", ((company.getPrice()-company.getHistory(count-24))*100)/(company.getPrice()-(company.getPrice()-company.getHistory(count-24))))+"%" + "\u001B[0m" : "\u001B[31m" + String.format("%.2f", ((company.getPrice()-company.getHistory(count-24))*100)/(company.getPrice()-(company.getPrice()-company.getHistory(count-24))))+"%"  + "\u001B[0m";

								}
								else if(count>=24) {
									updateMessage += company.getPrice()-company.getHistory(count-24) >= 0 ? "\u001B[32m" + String.format("%.2f", ((company.getPrice()-company.getHistory(count-24))*100)/(company.getPrice()-(company.getPrice()-company.getHistory(count-24))))+"%" + "\u001B[0m" : "\u001B[31m" + String.format("%.2f", ((company.getPrice()-company.getHistory(count-24))*100)/(company.getPrice()-(company.getPrice()-company.getHistory(count-24))))+"%"  + "\u001B[0m";

								}
								
								Socket clientSocket = connections.get(clientId);
								
								if (clientSocket != null && !clientSocket.isClosed()) {
									try {
										PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
										writer.println(updateMessage);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								updateReportAfterOrder(company.getSymbol(), company.getPrice());


								
							}

						}






                        
                    }
                    count++;}
                
            }, 0, 10000);
            count++;
            if(count==24) {
            	count = 0;
            }
        }
	    
	    
	    
	    
            
        
		
		
		
		protected BerzaServiceImpl() {
			initUnos();
			
		}
		
		
		
		private static final long UPDATE_INTERVAL = 6 * 60 * 1000; // 6 minutes in milliseconds

	    // Schedule the task to run every 6 minutes
	    private void scheduleDoneTradesUpdate() {
	    	ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

	        // Schedule the task to run every 6 minutes
	        scheduler.scheduleAtFixedRate(() -> {
	        	writeDoneTradesToFile();
	        }, 0, 1, TimeUnit.MINUTES);
	    }
	    
	    private void writeDoneTradesToFile() {
	    	List<OrderRequest> trades = new ArrayList<>(doneTrades.values());
    	    File file = new File("C:/Users/Lepi/Desktop/done_trades.txt");
    	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
    	        if (file.exists()) {
    	            file.delete(); // Delete the file if it exists
    	        }
    	        writer.write("Done trades\n");
    	        for (OrderRequest orderRequest : trades) {
    	            // Customize the format based on your requirements
    	            String line = orderRequest.getOrderId() + "," + orderRequest.getBuyerClientId() + "," +
    	                    orderRequest.getSellerClientId() + "," + orderRequest.getSymbol() + "," +
    	                    orderRequest.getQuantity() + "," + orderRequest.getPrice();
					line += " "+orderRequest.getStatus();
    	            writer.write(line);
    	            writer.newLine();
    	        }
    	        System.out.println("Done trades written to file successfully.");
    	    } catch (IOException e) {
            System.err.println("Error writing done trades to file: " + e.getMessage());
	        }
	    }
		
		
		
		@Override
	    public void registerClient(ClientInfo request, StreamObserver<RegisterResponse> responseObserver) {
	        // Process the client registration and return a response
	        boolean registrationSuccess = true;
	        registeredClients.put(request.getClientId(), request);
	        // Build and send the response
	        RegisterResponse response = RegisterResponse.newBuilder()
	                .setSuccess(registrationSuccess)
	                .build();
	        responseObserver.onNext(response);
	        responseObserver.onCompleted();
	    }
		
		
		

		
		
		protected void initUnos() {
			for (Company c: InitialData.initCompany()) { 
				companyMap.put(c.getSymbol(), c);
			}
		}
		
		@Override
		public void report(SubscriptionRequest request, StreamObserver<CompanyList> responseObserver) {
			List<String> symbols = request.getSymbolsList();
			String clientId = request.getClientId();
			
        	List<Company> companies = new ArrayList<>(companyMap.values());
            CompanyList companyList = CompanyList.newBuilder().addAllCompanies(companies).build();

            for (Company company : companies) {
                if (symbols.contains(company.getSymbol())) {
                	subscriptions.put(company, clientId);                }
            }

            // Add the list of subscribed companies to the subscriptions map
            

            // Send the stock data to the client
            responseObserver.onNext(companyList);

            // Sleep for a short duration before sending the next update
	            
	        
            responseObserver.onCompleted();
		    
		}
		

	    // Method to find orders by buyer ID
	    @Override
	    public void checkOffers(OfferRequest request, StreamObserver<OfferList> responseObserver) {
	        String buyerId = request.getBuyerId();
	        
	        List<OrderRequest> matchingOrders = new ArrayList<>();
	        
	        for (OrderRequest order : orders.values()) {
	            if (order.getBuyerClientId().equals(buyerId)) {
	            	matchingOrders.add(order);
	            }
	        }
	        
	        OfferList offers = OfferList.newBuilder().addAllOffers(matchingOrders).build();
	        
	        
            responseObserver.onNext(offers);
	        
	        
	        responseObserver.onCompleted();
	    }
		
		@Override
	    public void ask(AskReq request, StreamObserver<AskList> responseObserver) {
	        AskList.Builder askListBuilder = AskList.newBuilder();

	        // Iterate through clients and their stocks
	        for (Map.Entry<String, ClientInfo> entry : registeredClients.entrySet()) {
	            String clientId = entry.getKey();
	            ClientInfo clientInfo = entry.getValue();

	            for (StockInfo stock : clientInfo.getStocksList()) {
	                // Check if the stock is for sale and matches the requested symbol
	                if (stock.getSymbol().equals(request.getSymbol()) && request.getAmount() <= stock.getForSale()) {
	                    AskData askData = AskData.newBuilder()
	                            .setSymbol(stock.getSymbol())
	                            .setAmount(stock.getForSale())
	                            .build();

	                    // Add the stock to the response
	                    askListBuilder.addAsks(askData.toBuilder().setClientId(clientId).build());
	                }
	            }
	        }



	        responseObserver.onNext(askListBuilder.build());
	        responseObserver.onCompleted();
	    }
		
		@Override
	    public void updateStockAmounts(UpdateStockAmountsRequest request, StreamObserver<UpdateStockAmountsResponse> responseObserver) {
	        String clientId = request.getClientId();
	        String symbol = request.getSymbol();
	        int newForSaleValue = request.getNewForSaleValue();
	        int newNotForSaleValue = request.getNewNotForSaleValue();

	        // Get the client information
	        ClientInfo clientInfo = registeredClients.get(clientId);



	        if (clientInfo != null) {
	            // Update stock amounts for the specified symbol
	            clientInfo = updateClientStockAmounts(clientInfo, symbol, newForSaleValue, newNotForSaleValue);

	            // Update the client information in the map
	            registeredClients.put(clientId, clientInfo);

	            // Build the response
	            UpdateStockAmountsResponse response = UpdateStockAmountsResponse.newBuilder()
	                    .setSuccess(true)
	                    .build();

	            // Send the response to the client
	            responseObserver.onNext(response);
	            responseObserver.onCompleted();
	        } else {
	            // Handle case where client information is not found
	            // You might want to return an error response or handle it based on your use case
	            UpdateStockAmountsResponse response = UpdateStockAmountsResponse.newBuilder()
	                    .setSuccess(false)
	                    .build();

	            responseObserver.onNext(response);
	            responseObserver.onCompleted();
	        }
	    }
		
		private ClientInfo updateClientStockAmounts(ClientInfo clientInfo, String symbol, int newForSaleValue, int newNotForSaleValue) {
	        // Iterate through the client's stocks and update the amounts for the specified symbol
	        for (int i = 0; i < clientInfo.getStocksCount(); i++) {
	            StockInfo.Builder stockBuilder = clientInfo.getStocks(i).toBuilder();
	            if (stockBuilder.getSymbol().equals(symbol) && (newForSaleValue+newNotForSaleValue == stockBuilder.getForSale()+ stockBuilder.getNotForSale())) {
	                stockBuilder.setForSale(newForSaleValue);
	                stockBuilder.setNotForSale(newNotForSaleValue);
	                clientInfo = clientInfo.toBuilder().setStocks(i, stockBuilder.build()).build();
					return clientInfo;
	            }
	        }
	        return null;
	    }
		
		@Override
		public void placeOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
		    String buyerClientId = request.getBuyerClientId();
		    String sellerClientId = request.getSellerClientId();
		    String symbol = request.getSymbol();
		    double price = request.getPrice();
		    int quantity = request.getQuantity();
		    String orderId = request.getOrderId();

		    // Check if the seller has enough stocks for sale
		    if (hasEnoughStocksForSale(sellerClientId, symbol, quantity)) {
		        // Assume successful order placement for now
		        // You may want to implement additional logic, such as updating client stocks and handling transactions
		    	
		        orders.put(orderId, request);
		        OrderResponse response = OrderResponse.newBuilder().setSuccess(true).build();

		        // Send the response to the client
		        responseObserver.onNext(response);
		        responseObserver.onCompleted();

		        // Notify the seller about the order
		        notifyClient(sellerClientId, "You have a new order, check your bids!");
		    } else {
		        // If the seller doesn't have enough stocks, return failure response
		        OrderResponse response = OrderResponse.newBuilder().setSuccess(false).build();
		        responseObserver.onNext(response);
		        responseObserver.onCompleted();
		    }
		}

		private boolean hasEnoughStocksForSale(String sellerClientId, String symbol, int requestedQuantity) {
		    // Check if the seller has enough stocks for sale
		    ClientInfo sellerInfo = registeredClients.get(sellerClientId);
		    if (sellerInfo != null) {
		        for (StockInfo stock : sellerInfo.getStocksList()) {
		            if (stock.getSymbol().equals(symbol) && stock.getForSale() >= requestedQuantity) {
		                return true;
		            }
		        }
		    }
		    return false;
		}
		
		
		
		private void notifyClient(String id, String message) {
            String clientId = id;
            String notification = message;

            Socket clientSocket = connections.get(clientId);

            if (clientSocket != null && !clientSocket.isClosed()) {
                try {
                    System.out.println(notification);
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println(notification);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
	        
	    }
		
		@Override
		public void acceptOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {

			String orderId = request.getOrderId();
			OrderRequest order = orders.get(orderId);
		    String buyerClientId = order.getBuyerClientId();
		    String sellerClientId = order.getSellerClientId();
		    String symbol = order.getSymbol();
		    int quantity = order.getQuantity();
		    double price = order.getPrice();
		    // Check if the order ID exists in the orders map
		    if (orders.containsKey(orderId)) {
		        // Assume that the order is accepted
		        // In a real-world scenario, you might want to implement additional validation
		        // or communicate with the seller to confirm the acceptance


				ClientInfo buyerInfo = registeredClients.get(buyerClientId);

				ClientInfo sellerInfo = registeredClients.get(sellerClientId);

				// Update stock quantities for the buyer
				buyerInfo = updateAfterOrder(buyerInfo, symbol, quantity, true);

				// Update stock quantities for the seller
				sellerInfo = updateAfterOrder(sellerInfo, symbol, quantity, false);

				registeredClients.put(buyerClientId, buyerInfo);
				registeredClients.put(sellerClientId, sellerInfo);
				
				
				Company updatedCompany = updateReportAfterOrder(symbol, price);
				companyMap.put(symbol, updatedCompany);
				
				changeOrderStatus(orderId, true);
				processOrderRequests(orderId);
				notifyClient(buyerClientId, "Your order "+orderId+" has been accepted");

		        OrderResponse response = OrderResponse.newBuilder()
		                .setSuccess(true)
		                .build();

		        responseObserver.onNext(response);
		        responseObserver.onCompleted();
		        

		        // Notify the buyer about the accepted order (for demonstration purposes)
		    } else {
		        // Handle the case where the order ID is not found
		        OrderResponse response = OrderResponse.newBuilder()
		                .setSuccess(false)
		                .build();

		        responseObserver.onNext(response);
		        responseObserver.onCompleted();

		        // Notify the buyer about the unsuccessful acceptance (for demonstration purposes)
		    }
		}
		
		@Override
		public void declineOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
			String orderId = request.getOrderId();
			OrderRequest order = orders.get(orderId);
			String buyerClientId = order.getBuyerClientId();
			String sellerClientId = order.getSellerClientId();
			String symbol = order.getSymbol();
			int quantity = order.getQuantity();
			double price = order.getPrice();

		    // Check if the order ID exists in the orders map
		    if (orders.containsKey(orderId)) {
		        // Assume that the order is accepted
		        // In a real-world scenario, you might want to implement additional validation
		        // or communicate with the seller to confirm the acceptance


		        // Remove the accepted order from the orders map

				changeOrderStatus(orderId, false);
				processOrderRequests(orderId);

		        OrderResponse response = OrderResponse.newBuilder()
		                .setSuccess(true)
		                .build();

		        responseObserver.onNext(response);
		        responseObserver.onCompleted();
		        notifyClient(buyerClientId, "Your order "+orderId+" has been declined");

		        // Notify the buyer about the accepted order (for demonstration purposes)
		    } else {
		        // Handle the case where the order ID is not found
		        OrderResponse response = OrderResponse.newBuilder()
		                .setSuccess(false)
		                .build();

		        responseObserver.onNext(response);
		        responseObserver.onCompleted();

		        // Notify the buyer about the unsuccessful acceptance (for demonstration purposes)
		    }
		}
		
		@Override
		public void cancelOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
			String orderId = request.getOrderId();
			OrderRequest order = orders.get(orderId);
			String buyerClientId = order.getBuyerClientId();
			String sellerClientId = order.getSellerClientId();
			String symbol = order.getSymbol();
			int quantity = order.getQuantity();
			double price = order.getPrice();

		    // Check if the order ID exists in the orders map
		    if (orders.containsKey(orderId)) {
		        // Assume that the order is accepted
		        // In a real-world scenario, you might want to implement additional validation
		        // or communicate with the seller to confirm the acceptance


		        // Remove the accepted order from the orders map

		    	orders.remove(orderId);

		        OrderResponse response = OrderResponse.newBuilder()
		                .setSuccess(true)
		                .build();

		        responseObserver.onNext(response);
		        responseObserver.onCompleted();
		        notifyClient(sellerClientId, "Order "+orderId+" has been canceled");

		        // Notify the buyer about the accepted order (for demonstration purposes)
		    } else {
		        // Handle the case where the order ID is not found
		        OrderResponse response = OrderResponse.newBuilder()
		                .setSuccess(false)
		                .build();

		        responseObserver.onNext(response);
		        responseObserver.onCompleted();

		        // Notify the buyer about the unsuccessful acceptance (for demonstration purposes)
		    }
		}
		
		

		
		
		private void processOrderRequests(String orderId) {
		    // Retrieve the order from the orders map using the orderId
		    OrderRequest orderRequest = orders.get(orderId);

		    if (orderRequest != null) {
		        // Your existing logic for processing order requests...

		        // Check the status and move completed orders to doneTrades
		        
		            // If the status is true, move the order to doneTrades map
	            doneTrades.put(orderId, orderRequest);

	            // Remove the order from the orders map
	            orders.remove(orderId);

		        

		        // Rest of your existing logic...
		    } else {
		        System.out.println("Order with ID " + orderId + " not found in the orders map.");
		    }
		}
		
		private void changeOrderStatus(String orderId, boolean newStatus) {
		    OrderRequest orderRequest = orders.get(orderId);

		    if (orderRequest != null) {
		        // Update the status of the order
		        orderRequest = orderRequest.toBuilder()
		                .setStatus(newStatus)
		                .build();

		        // Put the updated order back in the orders map
		        orders.put(orderId, orderRequest);

		        // Print a message or log the status change
		        System.out.println("Order " + orderId + " status changed to " + newStatus);
		    } else {
		        // Handle the case where the order doesn't exist
		        System.out.println("Order with ID " + orderId + " not found in orders map.");
		    }
		}








		
		private Company updateReportAfterOrder(String symbol, double price) {
			
					
			Company company = companyMap.get(symbol);

		    if (company != null) {
		        Company.Builder companyBuilder = company.toBuilder();
		        
		        companyBuilder.setPreviousPrice(company.getPrice());
		        
		        companyBuilder.addHistory(company.getPrice());
		        double change = price - company.getPrice();
		        // Update the price
		        companyBuilder.setPrice(price);
		        

		        // Calculate the change based on the new price and the previous change
		        
		        companyBuilder.setChange(change);

		        // Build the updated company object
		        Company updatedCompany = companyBuilder.build();

		        // Update the company in the map
		        companyMap.put(symbol, updatedCompany);

		        return updatedCompany;
		    } else {
		        System.out.println("Company with symbol " + symbol + " not found.");
		        return null;
		    }
			
		}
		
		
		
		private ClientInfo updateAfterOrder(ClientInfo client, String symbol, int quantity, boolean addToNotForSale) {
		    // Get the client information
			String id = client.getClientId();
			ClientInfo clientInfo = registeredClients.get(id);
		    if (clientInfo != null) {
		    // Check if the client already has the stock
			    boolean stockExists = false;
			    for (int i = 0; i < clientInfo.getStocksCount(); i++) {
					StockInfo.Builder stockBuilder = clientInfo.getStocks(i).toBuilder();
			        if (stockBuilder.getSymbol().equals(symbol)) {
			            // Update the existing stock
			            stockBuilder.setForSale(addToNotForSale ? stockBuilder.getForSale() : stockBuilder.getForSale()-quantity);
			            stockBuilder.setNotForSale(addToNotForSale ? stockBuilder.getNotForSale()+quantity : stockBuilder.getNotForSale());
			            stockExists = true;
						clientInfo = clientInfo.toBuilder().setStocks(i, stockBuilder.build()).build();
			        }
			    }
	
			    // If the client doesn't have the stock, create a new one
			    if (!stockExists) {
			        StockInfo newStock = StockInfo.newBuilder()
			                .setSymbol(symbol)
			                .setForSale(addToNotForSale ? 0 : quantity)
			                .setNotForSale(addToNotForSale ? quantity : 0)
			                .build();
			        clientInfo = clientInfo.toBuilder().addStocks(newStock).build();
			    }

			    return clientInfo;
		    } else {
		        // Handle the case where the client doesn't exist
		        System.out.println("Client with ID " + " not found.");
				return null;
		    }
		}
		
		
		@Override
		public void bid(None request, StreamObserver<BidList> responseObserver) {
			BidList.Builder orderListBuilder = BidList.newBuilder();

		    // Iterate through orders and add them to the response
		    for (Map.Entry<String, OrderRequest> entry : orders.entrySet()) {
		        orderListBuilder.addOrders(entry.getValue());
		    }

		    responseObserver.onNext(orderListBuilder.build());
		    responseObserver.onCompleted();
		}
        
        
		
		

	    

		// Replace this with your actual method to get the latest company data

		
		
		
		
		
		
		
		
	}
	
	
	

}
