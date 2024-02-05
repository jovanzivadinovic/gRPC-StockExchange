package com.berza;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import com.berza.grpc.AskData;
import com.berza.grpc.AskList;
import com.berza.grpc.AskReq;
import com.berza.grpc.BerzaServiceGrpc;
import com.berza.grpc.BerzaServiceGrpc.BerzaServiceImplBase;
import com.berza.grpc.BidList;
import com.berza.grpc.ClientInfo;
import com.berza.grpc.Company;
import com.berza.grpc.CompanyList;
import com.berza.grpc.None;
import com.berza.grpc.OfferList;
import com.berza.grpc.OfferRequest;
import com.berza.grpc.OrderRequest;
import com.berza.grpc.OrderResponse;
import com.berza.grpc.RegisterResponse;
import com.berza.grpc.StockInfo;
import com.berza.grpc.SubscriptionRequest;
import com.berza.grpc.UpdateStockAmountsRequest;
import com.berza.grpc.UpdateStockAmountsResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class BerzaClient extends BerzaServiceImplBase{
	
	private ClientInfo clientInfo;
    private Socket tcpSocket;
    BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub;
    private final ManagedChannel grpcChannel;

    
    public BerzaClient(ManagedChannel channel) {
        blockingStub = BerzaServiceGrpc.newBlockingStub(channel);
        this.clientInfo = generateClientInfo();
        grpcChannel = channel;
        sendUserIdToServer();
    }

	
	private static ClientInfo generateClientInfo() {
        // Generate a unique client ID
        String clientId = UUID.randomUUID().toString();

        // Create stock information for the client
        StockInfo stock1 = StockInfo.newBuilder()
                .setSymbol("AAPL")
                .setForSale(10)
                .setNotForSale(10)
                .build();
		StockInfo stock2 = StockInfo.newBuilder()
				.setSymbol("MSFT")
				.setForSale(10)
				.setNotForSale(10)
				.build();

        
        ClientInfo clientInfo = ClientInfo.newBuilder()
                .setClientId(clientId)
                .addStocks(stock1)
				.addStocks(stock2)
                // Add more stocks as needed
                .build();

        return clientInfo;
    }
	
	private void sendUserIdToServer() {
        try {
        	tcpSocket = new Socket("localhost", 8888);
            PrintWriter writer = new PrintWriter(tcpSocket.getOutputStream(), true);
            writer.println(clientInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	

	

	
	public static void main(String[] args) throws UnknownHostException, IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
          .usePlaintext()
          .build();
        BerzaClient client = new BerzaClient(channel);
//        BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub = BerzaServiceGrpc.newBlockingStub(channel);
//        BerzaServiceGrpc.BerzaServiceStub asyncStub = BerzaServiceGrpc.newStub(channel);
        
        
        
        registerClient(client);
        
        try(Socket socket = new Socket("localhost",8888)){
            System.out.println("Client connected." );


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			String userId = client.clientInfo.getClientId();
			writer.println(userId);
			

			Scanner scanner = new Scanner(System.in);

			
			


            Thread serverListener = new Thread(() -> {
                String serverMessage;
                try {
					while ((serverMessage = in.readLine()) != null) {
					    
					    System.out.println(serverMessage);
					    

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
            serverListener.start();
            
            Thread grpcThread = new Thread(() -> {
                while (true) {
                    // Handle user input continuously
                    handleUserInput(client, scanner, client.blockingStub);
                }
            });
            
            grpcThread.start();
            
            try {
                grpcThread.join();
                serverListener.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           
        }
        
  

        
        
        

        

        channel.shutdown();
	}
	
	
	private static void registerClient(BerzaClient client) {
		try {
            // Use the gRPC stub to call the server's registration method
            RegisterResponse registerResponse = client.blockingStub.registerClient(client.clientInfo);

            // Process the response as needed
            if (registerResponse.getSuccess()) {
                System.out.println("Client registration successful. Client ID: " + client.clientInfo.getClientId());
            } else {
                System.out.println("Client registration failed.");
            }
        } catch (StatusRuntimeException e) {
            System.out.println("Error registering client: " + e.getStatus());
        }
	}
	
	
	
	private void ispisReport(CompanyList companyList, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
		List<Company> companies = companyList.getCompaniesList();
		
        
		for (Company company : companies) {
            // Handle each company as needed
            System.out.println("Symbol: " + company.getSymbol() +
                    ", Name: " + company.getName() +
                    ", Price: " + company.getPrice() +
                    ", Change: " + company.getChange() +
                    ", Date: " + company.getDate());
        }
	}
	
	
	
	private static void ispisAsk(String clientId, String symbol,  int amount, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
        AskReq request = AskReq.newBuilder().setSymbol(symbol).setAmount(amount).build();
        try {
            AskList askList = blockingStub.ask(request);

            System.out.println("Stocks for sale (Symbol: " + symbol + "):");
            for (AskData askData : askList.getAsksList()) {
            	if (askData.getClientId().equals(clientId)) {
            		continue;
            	}
                System.out.println("Client ID: " + askData.getClientId() +
                        ", Symbol: " + askData.getSymbol() +
                        ", Quantity: " + askData.getAmount() );
            }
        } catch (StatusRuntimeException e) {
            System.out.println("Error getting stocks for sale: " + e.getStatus());
        }
    }
	
	public static void updateStockAmounts(BerzaClient client, String clientId, String symbol, int newForSaleValue, int newNotForSaleValue,  BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
        // Build the request
        UpdateStockAmountsRequest request = UpdateStockAmountsRequest.newBuilder()
                .setClientId(clientId)
                .setSymbol(symbol)
                .setNewForSaleValue(newForSaleValue)
                .setNewNotForSaleValue(newNotForSaleValue)
                .build();

        try {
            // Call the updateStockAmounts RPC method
            UpdateStockAmountsResponse response = blockingStub.updateStockAmounts(request);
            
            // Process the response as needed
            if (response.getSuccess()) {
                System.out.println("Stock amounts updated successfully");
				List<StockInfo> updatedStocks = new ArrayList<>();
				for (int i = 0; i < client.clientInfo.getStocksCount(); i++) {
					StockInfo stockInfo = client.clientInfo.getStocks(i);
					if (stockInfo.getSymbol().equals(symbol)) {
						StockInfo.Builder stockInfoBuilder = stockInfo.toBuilder();
						stockInfoBuilder.setForSale(newForSaleValue);
						stockInfoBuilder.setNotForSale(newNotForSaleValue);
						stockInfo = stockInfoBuilder.build();
					}
					updatedStocks.add(stockInfo);
				}

// Create a new ClientInfo with updated stock information
				ClientInfo.Builder clientInfoBuilder = client.clientInfo.toBuilder();
				clientInfoBuilder.clearStocks().addAllStocks(updatedStocks);
				client.clientInfo = clientInfoBuilder.build();

            } else {
                System.out.println("Stock amounts update failed." );
            }
        } catch (StatusRuntimeException e) {
            System.out.println("Error updating stock amounts: " + e.getStatus());
        }
    }
	
	public static void placeOrder(String buyerId, String sellerClientId, String symbol, double price, int quantity, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
	    // Build the request for placing an order
	    OrderRequest request = OrderRequest.newBuilder()
	            .setBuyerClientId(buyerId)
	            .setSellerClientId(sellerClientId)
	            .setSymbol(symbol)
	            .setPrice(price)
	            .setQuantity(quantity)
	            .setStatus(false)
	            .setOrderId(UUID.randomUUID().toString())// Assuming the order is not accepted initially
	            .build();

	    try {
	        // Call the placeOrder RPC method
	        OrderResponse response = blockingStub.placeOrder(request);

	        // Process the response as needed
	        if (response.getSuccess()) {
	            System.out.println("Order placed successfully. Waiting for seller acceptance.");
	        } else {
	            System.out.println("Failed to place order. Seller may not have enough stocks for sale.");
	        }
	    } catch (StatusRuntimeException e) {
	        System.out.println("Error placing order: " + e.getStatus());
	    }
	}
	
	public static void acceptOrder(String orderId, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
	    // Build the request
	    OrderRequest request = OrderRequest.newBuilder()
	            .setOrderId(orderId)
	            .build();

	    try {
	        // Call the acceptOrder RPC method
	        OrderResponse response = blockingStub.acceptOrder(request);
	        
	        

	        // Process the response as needed
	        if (response.getSuccess()) {
	            System.out.println("Order accepted successfully");
	        } else {
	            System.out.println("Order acceptance failed.");
	        }
	    } catch (StatusRuntimeException e) {
	        System.out.println("Error accepting order: " + e.getStatus());
	    }
	}
	
	public static void declineOrder(String orderId, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
	    // Build the request
	    OrderRequest request = OrderRequest.newBuilder()
	            .setOrderId(orderId)
	            .build();

	    try {
	        // Call the acceptOrder RPC method
	        OrderResponse response = blockingStub.declineOrder(request);

	        // Process the response as needed
	        if (response.getSuccess()) {
	            System.out.println("Order declined successfully");
	        } else {
	            System.out.println("Order declination failed.");
	        }
	    } catch (StatusRuntimeException e) {
	        System.out.println("Error declining order: " + e.getStatus());
	    }
	}
	
	public static void cancelOrder(String orderId, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
	    // Build the request
	    OrderRequest request = OrderRequest.newBuilder()
	            .setOrderId(orderId)
	            .build();

	    try {
	        // Call the acceptOrder RPC method
	        OrderResponse response = blockingStub.cancelOrder(request);

	        // Process the response as needed
	        if (response.getSuccess()) {
	            System.out.println("Order canceled successfully");
	        } else {
	            System.out.println("Order cancelation failed.");
	        }
	    } catch (StatusRuntimeException e) {
	        System.out.println("Error canceling order: " + e.getStatus());
	    }
	}
	
	
	
	public static void showMySellOrders(String clientId, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
	    None request = None.newBuilder().build();

	    try {
	        BidList orderList = blockingStub.bid(request);

	        System.out.println("Your sell orders:");

	        for (OrderRequest order : orderList.getOrdersList()) {
	            if (clientId.equals(order.getSellerClientId())) {
	                System.out.println("Order ID: " + order.getOrderId() +
	                        ", Buyer: " + order.getBuyerClientId() +
	                        ", Symbol: " + order.getSymbol() +
	                        ", Price: " + order.getPrice() +
	                        ", Quantity: " + order.getQuantity());
	            }
	        }
	    } catch (StatusRuntimeException e) {
	        System.out.println("Error showing your sell orders: " + e.getStatus());
	    }
	}
	
	private static final int UPDATE_INTERVAL = 6; // in minutes
	private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private static ScheduledFuture<?> scheduledFuture;


	
	
	public static void subscribe(List<String> symbols, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub, ClientInfo clientInfo) {


		SubscriptionRequest.Builder builder = SubscriptionRequest.newBuilder();
		for (String symbol : symbols) {
			builder.addSymbols(symbol);
		}
		builder.setClientId(clientInfo.getClientId());
		
		SubscriptionRequest request = builder.build();

	    try {
	        CompanyList companies = blockingStub.report(request);

	        
//	        for (Company company : companies.getCompaniesList()) {
//	        	for (String symbol : symbols) {
//	        		if (symbol.equals(company.getSymbol())) {
//		        		System.out.println("Symbol: " + company.getSymbol() +
//			                    ", Name: " + company.getName() +
//			                    ", Price: " + company.getPrice() +
//			                    ", Change: " + company.getChange() +
//			                    ", Date: " + company.getDate());
//		        	}
//	        	}
//	        	
//	        	
//	        	
//	            // Handle each company as needed
//	            
//	        }
	    } catch (StatusRuntimeException e) {
	        System.out.println("Error showing your sell orders: " + e.getStatus());
	    }
	}

	public static void offers(String buyerId, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
        OfferRequest request = OfferRequest.newBuilder().setBuyerId(buyerId).build();
        
        try {
            OfferList offers = blockingStub.checkOffers(request);

            System.out.println("My offers:");
            for (OrderRequest order : offers.getOffersList()) {
                System.out.println("Order ID: " + order.getOrderId() +
                		", Seller: " + order.getSellerClientId() +
                        ", Symbol: " + order.getSymbol() +
                        ", Quantity: " + order.getQuantity() +
                        ", Price: " + order.getPrice());
            }
        } catch (StatusRuntimeException e) {
            System.out.println("Error getting offers: " + e.getStatus());
        }
    }

    

	
	
	
	
	private static void handleUserInput(BerzaClient grpcClient, Scanner scanner, BerzaServiceGrpc.BerzaServiceBlockingStub blockingStub) {
        String choice = scanner.nextLine();
        String[] parts = choice.split(" ");

//        if (choice.toUpperCase().startsWith("REPORT")) {
//            None request = None.newBuilder().build();
//			CompanyList companyList = blockingStub.report(request);
//			grpcClient.ispisReport(companyList, blockingStub);
//        } 
        if (choice.toUpperCase().startsWith("ASK")) {
            if (parts.length == 3) {
                String symbol = parts[1];
                int amount = Integer.parseInt(parts[2]);
                grpcClient.ispisAsk(grpcClient.clientInfo.getClientId() ,symbol, amount, blockingStub);
            }
        } else if (choice.toUpperCase().startsWith("CHANGE AMOUNT")) {
            if (parts.length == 5) {
                String symbol = parts[2];
                int amount1 = Integer.parseInt(parts[3]);
                int amount2 = Integer.parseInt(parts[4]);
                grpcClient.updateStockAmounts(grpcClient, grpcClient.clientInfo.getClientId() ,symbol, amount1, amount2, blockingStub);
            }
       
        } else if (choice.toUpperCase().startsWith("ORDER")) {
        	if (parts.length == 5) {
                String sellerClientId = parts[1];
                String symbol = parts[2];
                double price = Double.parseDouble(parts[3]);
                int quantity = Integer.parseInt(parts[4]);
                placeOrder(grpcClient.clientInfo.getClientId(),sellerClientId, symbol, price, quantity, blockingStub);
            }
        } else if (choice.toUpperCase().startsWith("ACCEPT")) {
        	if (parts.length == 2) {
                String orderId = parts[1];
                
                acceptOrder(orderId, blockingStub);
                
            }
        } else if (choice.toUpperCase().startsWith("DECLINE")) {
        	if (parts.length == 2) {
                String orderId = parts[1];
                
                declineOrder(orderId, blockingStub);
            }
        } else if (choice.toUpperCase().startsWith("BIDS")) {
        	showMySellOrders(grpcClient.clientInfo.getClientId(), blockingStub);
        } else if (choice.toUpperCase().startsWith("SUBSCRIBE")) {
			List<String> symbols = new ArrayList<>();
			for (int i =0; i<parts.length; i++) {
				if (i==0) {
					continue;
				}
				symbols.add(parts[i]);

			}
			subscribe(symbols, blockingStub, grpcClient.clientInfo);
			// Handle other commands...
		}else if (choice.toUpperCase().startsWith("INFO")) {
			System.out.println(grpcClient.clientInfo);
			// Handle other commands...
		}else if (choice.toUpperCase().startsWith("OFFERS")) {
			offers(grpcClient.clientInfo.getClientId(), blockingStub);
			// Handle other commands...
		}else if (choice.toUpperCase().startsWith("CANCEL")) {
			if (parts.length == 2) {
                String orderId = parts[1];
                
                cancelOrder(orderId, blockingStub);
                
            }
		} else {
            System.out.println("That command does not exist.");
        }
    }
	
	
	

	

        
    
}
