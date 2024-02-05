// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: companies.proto

package com.berza.grpc;

public final class Companies {
  private Companies() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SubscriptionRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SubscriptionRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Company_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Company_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CompanyList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CompanyList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AskReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AskReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AskData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AskData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AskList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AskList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OrderRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OrderResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BidList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BidList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OfferRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OfferRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OfferList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OfferList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ClientInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ClientInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegisterResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegisterResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StockInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StockInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UpdateStockAmountsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UpdateStockAmountsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UpdateStockAmountsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UpdateStockAmountsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_None_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_None_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017companies.proto\032\037google/protobuf/times" +
      "tamp.proto\"8\n\023SubscriptionRequest\022\020\n\010Cli" +
      "entId\030\001 \001(\t\022\017\n\007Symbols\030\002 \003(\t\"\230\001\n\007Company" +
      "\022\016\n\006Symbol\030\001 \001(\t\022\014\n\004Name\030\002 \001(\t\022\r\n\005Price\030" +
      "\003 \001(\001\022\016\n\006Change\030\004 \001(\001\022(\n\004Date\030\005 \001(\0132\032.go" +
      "ogle.protobuf.Timestamp\022\025\n\rPreviousPrice" +
      "\030\006 \001(\001\022\017\n\007History\030\007 \003(\001\"*\n\013CompanyList\022\033" +
      "\n\tcompanies\030\001 \003(\0132\010.Company\"(\n\006AskReq\022\016\n" +
      "\006Symbol\030\001 \001(\t\022\016\n\006Amount\030\002 \001(\005\"J\n\007AskData" +
      "\022\016\n\006Symbol\030\001 \001(\t\022\r\n\005Price\030\002 \001(\001\022\016\n\006Amoun" +
      "t\030\003 \001(\005\022\020\n\010clientId\030\004 \001(\t\"!\n\007AskList\022\026\n\004" +
      "asks\030\001 \003(\0132\010.AskData\"\217\001\n\014OrderRequest\022\025\n" +
      "\rbuyerClientId\030\001 \001(\t\022\026\n\016sellerClientId\030\002" +
      " \001(\t\022\016\n\006symbol\030\003 \001(\t\022\r\n\005price\030\004 \001(\001\022\020\n\010q" +
      "uantity\030\005 \001(\005\022\016\n\006status\030\006 \001(\010\022\017\n\007orderId" +
      "\030\007 \001(\t\" \n\rOrderResponse\022\017\n\007success\030\001 \001(\010" +
      "\"(\n\007BidList\022\035\n\006orders\030\001 \003(\0132\r.OrderReque" +
      "st\"\037\n\014OfferRequest\022\017\n\007buyerId\030\001 \001(\t\"*\n\tO" +
      "fferList\022\035\n\006offers\030\001 \003(\0132\r.OrderRequest\"" +
      ":\n\nClientInfo\022\020\n\010clientId\030\001 \001(\t\022\032\n\006stock" +
      "s\030\002 \003(\0132\n.StockInfo\"#\n\020RegisterResponse\022" +
      "\017\n\007success\030\001 \001(\010\"@\n\tStockInfo\022\016\n\006symbol\030" +
      "\001 \001(\t\022\022\n\nnotForSale\030\002 \001(\005\022\017\n\007forSale\030\003 \001" +
      "(\005\"r\n\031UpdateStockAmountsRequest\022\020\n\010clien" +
      "tId\030\001 \001(\t\022\016\n\006symbol\030\002 \001(\t\022\027\n\017newForSaleV" +
      "alue\030\003 \001(\005\022\032\n\022newNotForSaleValue\030\004 \001(\005\"-" +
      "\n\032UpdateStockAmountsResponse\022\017\n\007success\030" +
      "\001 \001(\010\"\006\n\004None2\341\003\n\014BerzaService\022.\n\006Report" +
      "\022\024.SubscriptionRequest\032\014.CompanyList\"\000\022\032" +
      "\n\003Ask\022\007.AskReq\032\010.AskList\"\000\0222\n\016RegisterCl" +
      "ient\022\013.ClientInfo\032\021.RegisterResponse\"\000\022O" +
      "\n\022UpdateStockAmounts\022\032.UpdateStockAmount" +
      "sRequest\032\033.UpdateStockAmountsResponse\"\000\022" +
      "-\n\nPlaceOrder\022\r.OrderRequest\032\016.OrderResp" +
      "onse\"\000\022.\n\013AcceptOrder\022\r.OrderRequest\032\016.O" +
      "rderResponse\"\000\022/\n\014DeclineOrder\022\r.OrderRe" +
      "quest\032\016.OrderResponse\"\000\022\030\n\003Bid\022\005.None\032\010." +
      "BidList\"\000\022(\n\013CheckOffers\022\r.OfferRequest\032" +
      "\n.OfferList\022,\n\013CancelOrder\022\r.OrderReques" +
      "t\032\016.OrderResponseB\022\n\016com.berza.grpcP\001b\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_SubscriptionRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SubscriptionRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SubscriptionRequest_descriptor,
        new java.lang.String[] { "ClientId", "Symbols", });
    internal_static_Company_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Company_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Company_descriptor,
        new java.lang.String[] { "Symbol", "Name", "Price", "Change", "Date", "PreviousPrice", "History", });
    internal_static_CompanyList_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CompanyList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CompanyList_descriptor,
        new java.lang.String[] { "Companies", });
    internal_static_AskReq_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_AskReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AskReq_descriptor,
        new java.lang.String[] { "Symbol", "Amount", });
    internal_static_AskData_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_AskData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AskData_descriptor,
        new java.lang.String[] { "Symbol", "Price", "Amount", "ClientId", });
    internal_static_AskList_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_AskList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AskList_descriptor,
        new java.lang.String[] { "Asks", });
    internal_static_OrderRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_OrderRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OrderRequest_descriptor,
        new java.lang.String[] { "BuyerClientId", "SellerClientId", "Symbol", "Price", "Quantity", "Status", "OrderId", });
    internal_static_OrderResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_OrderResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OrderResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_BidList_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_BidList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BidList_descriptor,
        new java.lang.String[] { "Orders", });
    internal_static_OfferRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_OfferRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OfferRequest_descriptor,
        new java.lang.String[] { "BuyerId", });
    internal_static_OfferList_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_OfferList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OfferList_descriptor,
        new java.lang.String[] { "Offers", });
    internal_static_ClientInfo_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ClientInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ClientInfo_descriptor,
        new java.lang.String[] { "ClientId", "Stocks", });
    internal_static_RegisterResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_RegisterResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegisterResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_StockInfo_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_StockInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StockInfo_descriptor,
        new java.lang.String[] { "Symbol", "NotForSale", "ForSale", });
    internal_static_UpdateStockAmountsRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_UpdateStockAmountsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UpdateStockAmountsRequest_descriptor,
        new java.lang.String[] { "ClientId", "Symbol", "NewForSaleValue", "NewNotForSaleValue", });
    internal_static_UpdateStockAmountsResponse_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_UpdateStockAmountsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UpdateStockAmountsResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_None_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_None_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_None_descriptor,
        new java.lang.String[] { });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}