package com.berza.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: companies.proto")
public final class BerzaServiceGrpc {

  private BerzaServiceGrpc() {}

  public static final String SERVICE_NAME = "BerzaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.SubscriptionRequest,
      com.berza.grpc.CompanyList> getReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Report",
      requestType = com.berza.grpc.SubscriptionRequest.class,
      responseType = com.berza.grpc.CompanyList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.SubscriptionRequest,
      com.berza.grpc.CompanyList> getReportMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.SubscriptionRequest, com.berza.grpc.CompanyList> getReportMethod;
    if ((getReportMethod = BerzaServiceGrpc.getReportMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getReportMethod = BerzaServiceGrpc.getReportMethod) == null) {
          BerzaServiceGrpc.getReportMethod = getReportMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.SubscriptionRequest, com.berza.grpc.CompanyList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "Report"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.CompanyList.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("Report"))
                  .build();
          }
        }
     }
     return getReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.AskReq,
      com.berza.grpc.AskList> getAskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ask",
      requestType = com.berza.grpc.AskReq.class,
      responseType = com.berza.grpc.AskList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.AskReq,
      com.berza.grpc.AskList> getAskMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.AskReq, com.berza.grpc.AskList> getAskMethod;
    if ((getAskMethod = BerzaServiceGrpc.getAskMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getAskMethod = BerzaServiceGrpc.getAskMethod) == null) {
          BerzaServiceGrpc.getAskMethod = getAskMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.AskReq, com.berza.grpc.AskList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "Ask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.AskReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.AskList.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("Ask"))
                  .build();
          }
        }
     }
     return getAskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.ClientInfo,
      com.berza.grpc.RegisterResponse> getRegisterClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterClient",
      requestType = com.berza.grpc.ClientInfo.class,
      responseType = com.berza.grpc.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.ClientInfo,
      com.berza.grpc.RegisterResponse> getRegisterClientMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.ClientInfo, com.berza.grpc.RegisterResponse> getRegisterClientMethod;
    if ((getRegisterClientMethod = BerzaServiceGrpc.getRegisterClientMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getRegisterClientMethod = BerzaServiceGrpc.getRegisterClientMethod) == null) {
          BerzaServiceGrpc.getRegisterClientMethod = getRegisterClientMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.ClientInfo, com.berza.grpc.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "RegisterClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.ClientInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("RegisterClient"))
                  .build();
          }
        }
     }
     return getRegisterClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.UpdateStockAmountsRequest,
      com.berza.grpc.UpdateStockAmountsResponse> getUpdateStockAmountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStockAmounts",
      requestType = com.berza.grpc.UpdateStockAmountsRequest.class,
      responseType = com.berza.grpc.UpdateStockAmountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.UpdateStockAmountsRequest,
      com.berza.grpc.UpdateStockAmountsResponse> getUpdateStockAmountsMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.UpdateStockAmountsRequest, com.berza.grpc.UpdateStockAmountsResponse> getUpdateStockAmountsMethod;
    if ((getUpdateStockAmountsMethod = BerzaServiceGrpc.getUpdateStockAmountsMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getUpdateStockAmountsMethod = BerzaServiceGrpc.getUpdateStockAmountsMethod) == null) {
          BerzaServiceGrpc.getUpdateStockAmountsMethod = getUpdateStockAmountsMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.UpdateStockAmountsRequest, com.berza.grpc.UpdateStockAmountsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "UpdateStockAmounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.UpdateStockAmountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.UpdateStockAmountsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("UpdateStockAmounts"))
                  .build();
          }
        }
     }
     return getUpdateStockAmountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PlaceOrder",
      requestType = com.berza.grpc.OrderRequest.class,
      responseType = com.berza.grpc.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = BerzaServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getPlaceOrderMethod = BerzaServiceGrpc.getPlaceOrderMethod) == null) {
          BerzaServiceGrpc.getPlaceOrderMethod = getPlaceOrderMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "PlaceOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("PlaceOrder"))
                  .build();
          }
        }
     }
     return getPlaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getAcceptOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptOrder",
      requestType = com.berza.grpc.OrderRequest.class,
      responseType = com.berza.grpc.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getAcceptOrderMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse> getAcceptOrderMethod;
    if ((getAcceptOrderMethod = BerzaServiceGrpc.getAcceptOrderMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getAcceptOrderMethod = BerzaServiceGrpc.getAcceptOrderMethod) == null) {
          BerzaServiceGrpc.getAcceptOrderMethod = getAcceptOrderMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "AcceptOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("AcceptOrder"))
                  .build();
          }
        }
     }
     return getAcceptOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getDeclineOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeclineOrder",
      requestType = com.berza.grpc.OrderRequest.class,
      responseType = com.berza.grpc.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getDeclineOrderMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse> getDeclineOrderMethod;
    if ((getDeclineOrderMethod = BerzaServiceGrpc.getDeclineOrderMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getDeclineOrderMethod = BerzaServiceGrpc.getDeclineOrderMethod) == null) {
          BerzaServiceGrpc.getDeclineOrderMethod = getDeclineOrderMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "DeclineOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("DeclineOrder"))
                  .build();
          }
        }
     }
     return getDeclineOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.None,
      com.berza.grpc.BidList> getBidMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Bid",
      requestType = com.berza.grpc.None.class,
      responseType = com.berza.grpc.BidList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.None,
      com.berza.grpc.BidList> getBidMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.None, com.berza.grpc.BidList> getBidMethod;
    if ((getBidMethod = BerzaServiceGrpc.getBidMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getBidMethod = BerzaServiceGrpc.getBidMethod) == null) {
          BerzaServiceGrpc.getBidMethod = getBidMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.None, com.berza.grpc.BidList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "Bid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.None.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.BidList.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("Bid"))
                  .build();
          }
        }
     }
     return getBidMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.OfferRequest,
      com.berza.grpc.OfferList> getCheckOffersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckOffers",
      requestType = com.berza.grpc.OfferRequest.class,
      responseType = com.berza.grpc.OfferList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.OfferRequest,
      com.berza.grpc.OfferList> getCheckOffersMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.OfferRequest, com.berza.grpc.OfferList> getCheckOffersMethod;
    if ((getCheckOffersMethod = BerzaServiceGrpc.getCheckOffersMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getCheckOffersMethod = BerzaServiceGrpc.getCheckOffersMethod) == null) {
          BerzaServiceGrpc.getCheckOffersMethod = getCheckOffersMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.OfferRequest, com.berza.grpc.OfferList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "CheckOffers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OfferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OfferList.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("CheckOffers"))
                  .build();
          }
        }
     }
     return getCheckOffersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getCancelOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelOrder",
      requestType = com.berza.grpc.OrderRequest.class,
      responseType = com.berza.grpc.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest,
      com.berza.grpc.OrderResponse> getCancelOrderMethod() {
    io.grpc.MethodDescriptor<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse> getCancelOrderMethod;
    if ((getCancelOrderMethod = BerzaServiceGrpc.getCancelOrderMethod) == null) {
      synchronized (BerzaServiceGrpc.class) {
        if ((getCancelOrderMethod = BerzaServiceGrpc.getCancelOrderMethod) == null) {
          BerzaServiceGrpc.getCancelOrderMethod = getCancelOrderMethod = 
              io.grpc.MethodDescriptor.<com.berza.grpc.OrderRequest, com.berza.grpc.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BerzaService", "CancelOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.berza.grpc.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BerzaServiceMethodDescriptorSupplier("CancelOrder"))
                  .build();
          }
        }
     }
     return getCancelOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BerzaServiceStub newStub(io.grpc.Channel channel) {
    return new BerzaServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BerzaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BerzaServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BerzaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BerzaServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BerzaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void report(com.berza.grpc.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.CompanyList> responseObserver) {
      asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
    }

    /**
     */
    public void ask(com.berza.grpc.AskReq request,
        io.grpc.stub.StreamObserver<com.berza.grpc.AskList> responseObserver) {
      asyncUnimplementedUnaryCall(getAskMethod(), responseObserver);
    }

    /**
     */
    public void registerClient(com.berza.grpc.ClientInfo request,
        io.grpc.stub.StreamObserver<com.berza.grpc.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterClientMethod(), responseObserver);
    }

    /**
     */
    public void updateStockAmounts(com.berza.grpc.UpdateStockAmountsRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.UpdateStockAmountsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateStockAmountsMethod(), responseObserver);
    }

    /**
     */
    public void placeOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    /**
     */
    public void acceptOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAcceptOrderMethod(), responseObserver);
    }

    /**
     */
    public void declineOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeclineOrderMethod(), responseObserver);
    }

    /**
     */
    public void bid(com.berza.grpc.None request,
        io.grpc.stub.StreamObserver<com.berza.grpc.BidList> responseObserver) {
      asyncUnimplementedUnaryCall(getBidMethod(), responseObserver);
    }

    /**
     */
    public void checkOffers(com.berza.grpc.OfferRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OfferList> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckOffersMethod(), responseObserver);
    }

    /**
     */
    public void cancelOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReportMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.SubscriptionRequest,
                com.berza.grpc.CompanyList>(
                  this, METHODID_REPORT)))
          .addMethod(
            getAskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.AskReq,
                com.berza.grpc.AskList>(
                  this, METHODID_ASK)))
          .addMethod(
            getRegisterClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.ClientInfo,
                com.berza.grpc.RegisterResponse>(
                  this, METHODID_REGISTER_CLIENT)))
          .addMethod(
            getUpdateStockAmountsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.UpdateStockAmountsRequest,
                com.berza.grpc.UpdateStockAmountsResponse>(
                  this, METHODID_UPDATE_STOCK_AMOUNTS)))
          .addMethod(
            getPlaceOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.OrderRequest,
                com.berza.grpc.OrderResponse>(
                  this, METHODID_PLACE_ORDER)))
          .addMethod(
            getAcceptOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.OrderRequest,
                com.berza.grpc.OrderResponse>(
                  this, METHODID_ACCEPT_ORDER)))
          .addMethod(
            getDeclineOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.OrderRequest,
                com.berza.grpc.OrderResponse>(
                  this, METHODID_DECLINE_ORDER)))
          .addMethod(
            getBidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.None,
                com.berza.grpc.BidList>(
                  this, METHODID_BID)))
          .addMethod(
            getCheckOffersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.OfferRequest,
                com.berza.grpc.OfferList>(
                  this, METHODID_CHECK_OFFERS)))
          .addMethod(
            getCancelOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.berza.grpc.OrderRequest,
                com.berza.grpc.OrderResponse>(
                  this, METHODID_CANCEL_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class BerzaServiceStub extends io.grpc.stub.AbstractStub<BerzaServiceStub> {
    private BerzaServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BerzaServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BerzaServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BerzaServiceStub(channel, callOptions);
    }

    /**
     */
    public void report(com.berza.grpc.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.CompanyList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ask(com.berza.grpc.AskReq request,
        io.grpc.stub.StreamObserver<com.berza.grpc.AskList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerClient(com.berza.grpc.ClientInfo request,
        io.grpc.stub.StreamObserver<com.berza.grpc.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStockAmounts(com.berza.grpc.UpdateStockAmountsRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.UpdateStockAmountsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateStockAmountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void placeOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAcceptOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void declineOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeclineOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bid(com.berza.grpc.None request,
        io.grpc.stub.StreamObserver<com.berza.grpc.BidList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBidMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOffers(com.berza.grpc.OfferRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OfferList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckOffersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelOrder(com.berza.grpc.OrderRequest request,
        io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BerzaServiceBlockingStub extends io.grpc.stub.AbstractStub<BerzaServiceBlockingStub> {
    private BerzaServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BerzaServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BerzaServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BerzaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.berza.grpc.CompanyList report(com.berza.grpc.SubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getReportMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.AskList ask(com.berza.grpc.AskReq request) {
      return blockingUnaryCall(
          getChannel(), getAskMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.RegisterResponse registerClient(com.berza.grpc.ClientInfo request) {
      return blockingUnaryCall(
          getChannel(), getRegisterClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.UpdateStockAmountsResponse updateStockAmounts(com.berza.grpc.UpdateStockAmountsRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateStockAmountsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.OrderResponse placeOrder(com.berza.grpc.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.OrderResponse acceptOrder(com.berza.grpc.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getAcceptOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.OrderResponse declineOrder(com.berza.grpc.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeclineOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.BidList bid(com.berza.grpc.None request) {
      return blockingUnaryCall(
          getChannel(), getBidMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.OfferList checkOffers(com.berza.grpc.OfferRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckOffersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.berza.grpc.OrderResponse cancelOrder(com.berza.grpc.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BerzaServiceFutureStub extends io.grpc.stub.AbstractStub<BerzaServiceFutureStub> {
    private BerzaServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BerzaServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BerzaServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BerzaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.CompanyList> report(
        com.berza.grpc.SubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.AskList> ask(
        com.berza.grpc.AskReq request) {
      return futureUnaryCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.RegisterResponse> registerClient(
        com.berza.grpc.ClientInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.UpdateStockAmountsResponse> updateStockAmounts(
        com.berza.grpc.UpdateStockAmountsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateStockAmountsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.OrderResponse> placeOrder(
        com.berza.grpc.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.OrderResponse> acceptOrder(
        com.berza.grpc.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAcceptOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.OrderResponse> declineOrder(
        com.berza.grpc.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeclineOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.BidList> bid(
        com.berza.grpc.None request) {
      return futureUnaryCall(
          getChannel().newCall(getBidMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.OfferList> checkOffers(
        com.berza.grpc.OfferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckOffersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.berza.grpc.OrderResponse> cancelOrder(
        com.berza.grpc.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT = 0;
  private static final int METHODID_ASK = 1;
  private static final int METHODID_REGISTER_CLIENT = 2;
  private static final int METHODID_UPDATE_STOCK_AMOUNTS = 3;
  private static final int METHODID_PLACE_ORDER = 4;
  private static final int METHODID_ACCEPT_ORDER = 5;
  private static final int METHODID_DECLINE_ORDER = 6;
  private static final int METHODID_BID = 7;
  private static final int METHODID_CHECK_OFFERS = 8;
  private static final int METHODID_CANCEL_ORDER = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BerzaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BerzaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT:
          serviceImpl.report((com.berza.grpc.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.CompanyList>) responseObserver);
          break;
        case METHODID_ASK:
          serviceImpl.ask((com.berza.grpc.AskReq) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.AskList>) responseObserver);
          break;
        case METHODID_REGISTER_CLIENT:
          serviceImpl.registerClient((com.berza.grpc.ClientInfo) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.RegisterResponse>) responseObserver);
          break;
        case METHODID_UPDATE_STOCK_AMOUNTS:
          serviceImpl.updateStockAmounts((com.berza.grpc.UpdateStockAmountsRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.UpdateStockAmountsResponse>) responseObserver);
          break;
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder((com.berza.grpc.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse>) responseObserver);
          break;
        case METHODID_ACCEPT_ORDER:
          serviceImpl.acceptOrder((com.berza.grpc.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse>) responseObserver);
          break;
        case METHODID_DECLINE_ORDER:
          serviceImpl.declineOrder((com.berza.grpc.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse>) responseObserver);
          break;
        case METHODID_BID:
          serviceImpl.bid((com.berza.grpc.None) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.BidList>) responseObserver);
          break;
        case METHODID_CHECK_OFFERS:
          serviceImpl.checkOffers((com.berza.grpc.OfferRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.OfferList>) responseObserver);
          break;
        case METHODID_CANCEL_ORDER:
          serviceImpl.cancelOrder((com.berza.grpc.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.berza.grpc.OrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BerzaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BerzaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.berza.grpc.Companies.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BerzaService");
    }
  }

  private static final class BerzaServiceFileDescriptorSupplier
      extends BerzaServiceBaseDescriptorSupplier {
    BerzaServiceFileDescriptorSupplier() {}
  }

  private static final class BerzaServiceMethodDescriptorSupplier
      extends BerzaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BerzaServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BerzaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BerzaServiceFileDescriptorSupplier())
              .addMethod(getReportMethod())
              .addMethod(getAskMethod())
              .addMethod(getRegisterClientMethod())
              .addMethod(getUpdateStockAmountsMethod())
              .addMethod(getPlaceOrderMethod())
              .addMethod(getAcceptOrderMethod())
              .addMethod(getDeclineOrderMethod())
              .addMethod(getBidMethod())
              .addMethod(getCheckOffersMethod())
              .addMethod(getCancelOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
