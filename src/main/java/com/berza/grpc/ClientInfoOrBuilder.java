// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: companies.proto

package com.berza.grpc;

public interface ClientInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ClientInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string clientId = 1;</code>
   */
  java.lang.String getClientId();
  /**
   * <code>string clientId = 1;</code>
   */
  com.google.protobuf.ByteString
      getClientIdBytes();

  /**
   * <code>repeated .StockInfo stocks = 2;</code>
   */
  java.util.List<com.berza.grpc.StockInfo> 
      getStocksList();
  /**
   * <code>repeated .StockInfo stocks = 2;</code>
   */
  com.berza.grpc.StockInfo getStocks(int index);
  /**
   * <code>repeated .StockInfo stocks = 2;</code>
   */
  int getStocksCount();
  /**
   * <code>repeated .StockInfo stocks = 2;</code>
   */
  java.util.List<? extends com.berza.grpc.StockInfoOrBuilder> 
      getStocksOrBuilderList();
  /**
   * <code>repeated .StockInfo stocks = 2;</code>
   */
  com.berza.grpc.StockInfoOrBuilder getStocksOrBuilder(
      int index);
}
