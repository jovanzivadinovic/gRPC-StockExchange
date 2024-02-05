// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: companies.proto

package com.berza.grpc;

/**
 * Protobuf type {@code OfferList}
 */
public  final class OfferList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:OfferList)
    OfferListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OfferList.newBuilder() to construct.
  private OfferList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OfferList() {
    offers_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OfferList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              offers_ = new java.util.ArrayList<com.berza.grpc.OrderRequest>();
              mutable_bitField0_ |= 0x00000001;
            }
            offers_.add(
                input.readMessage(com.berza.grpc.OrderRequest.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        offers_ = java.util.Collections.unmodifiableList(offers_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.berza.grpc.Companies.internal_static_OfferList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.berza.grpc.Companies.internal_static_OfferList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.berza.grpc.OfferList.class, com.berza.grpc.OfferList.Builder.class);
  }

  public static final int OFFERS_FIELD_NUMBER = 1;
  private java.util.List<com.berza.grpc.OrderRequest> offers_;
  /**
   * <code>repeated .OrderRequest offers = 1;</code>
   */
  public java.util.List<com.berza.grpc.OrderRequest> getOffersList() {
    return offers_;
  }
  /**
   * <code>repeated .OrderRequest offers = 1;</code>
   */
  public java.util.List<? extends com.berza.grpc.OrderRequestOrBuilder> 
      getOffersOrBuilderList() {
    return offers_;
  }
  /**
   * <code>repeated .OrderRequest offers = 1;</code>
   */
  public int getOffersCount() {
    return offers_.size();
  }
  /**
   * <code>repeated .OrderRequest offers = 1;</code>
   */
  public com.berza.grpc.OrderRequest getOffers(int index) {
    return offers_.get(index);
  }
  /**
   * <code>repeated .OrderRequest offers = 1;</code>
   */
  public com.berza.grpc.OrderRequestOrBuilder getOffersOrBuilder(
      int index) {
    return offers_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < offers_.size(); i++) {
      output.writeMessage(1, offers_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < offers_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, offers_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.berza.grpc.OfferList)) {
      return super.equals(obj);
    }
    com.berza.grpc.OfferList other = (com.berza.grpc.OfferList) obj;

    boolean result = true;
    result = result && getOffersList()
        .equals(other.getOffersList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getOffersCount() > 0) {
      hash = (37 * hash) + OFFERS_FIELD_NUMBER;
      hash = (53 * hash) + getOffersList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.berza.grpc.OfferList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.berza.grpc.OfferList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.berza.grpc.OfferList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.berza.grpc.OfferList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.berza.grpc.OfferList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.berza.grpc.OfferList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.berza.grpc.OfferList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.berza.grpc.OfferList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.berza.grpc.OfferList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.berza.grpc.OfferList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.berza.grpc.OfferList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.berza.grpc.OfferList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.berza.grpc.OfferList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code OfferList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:OfferList)
      com.berza.grpc.OfferListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.berza.grpc.Companies.internal_static_OfferList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.berza.grpc.Companies.internal_static_OfferList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.berza.grpc.OfferList.class, com.berza.grpc.OfferList.Builder.class);
    }

    // Construct using com.berza.grpc.OfferList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getOffersFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (offersBuilder_ == null) {
        offers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        offersBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.berza.grpc.Companies.internal_static_OfferList_descriptor;
    }

    @java.lang.Override
    public com.berza.grpc.OfferList getDefaultInstanceForType() {
      return com.berza.grpc.OfferList.getDefaultInstance();
    }

    @java.lang.Override
    public com.berza.grpc.OfferList build() {
      com.berza.grpc.OfferList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.berza.grpc.OfferList buildPartial() {
      com.berza.grpc.OfferList result = new com.berza.grpc.OfferList(this);
      int from_bitField0_ = bitField0_;
      if (offersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          offers_ = java.util.Collections.unmodifiableList(offers_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.offers_ = offers_;
      } else {
        result.offers_ = offersBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.berza.grpc.OfferList) {
        return mergeFrom((com.berza.grpc.OfferList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.berza.grpc.OfferList other) {
      if (other == com.berza.grpc.OfferList.getDefaultInstance()) return this;
      if (offersBuilder_ == null) {
        if (!other.offers_.isEmpty()) {
          if (offers_.isEmpty()) {
            offers_ = other.offers_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureOffersIsMutable();
            offers_.addAll(other.offers_);
          }
          onChanged();
        }
      } else {
        if (!other.offers_.isEmpty()) {
          if (offersBuilder_.isEmpty()) {
            offersBuilder_.dispose();
            offersBuilder_ = null;
            offers_ = other.offers_;
            bitField0_ = (bitField0_ & ~0x00000001);
            offersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getOffersFieldBuilder() : null;
          } else {
            offersBuilder_.addAllMessages(other.offers_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.berza.grpc.OfferList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.berza.grpc.OfferList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.berza.grpc.OrderRequest> offers_ =
      java.util.Collections.emptyList();
    private void ensureOffersIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        offers_ = new java.util.ArrayList<com.berza.grpc.OrderRequest>(offers_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.berza.grpc.OrderRequest, com.berza.grpc.OrderRequest.Builder, com.berza.grpc.OrderRequestOrBuilder> offersBuilder_;

    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public java.util.List<com.berza.grpc.OrderRequest> getOffersList() {
      if (offersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(offers_);
      } else {
        return offersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public int getOffersCount() {
      if (offersBuilder_ == null) {
        return offers_.size();
      } else {
        return offersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public com.berza.grpc.OrderRequest getOffers(int index) {
      if (offersBuilder_ == null) {
        return offers_.get(index);
      } else {
        return offersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder setOffers(
        int index, com.berza.grpc.OrderRequest value) {
      if (offersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureOffersIsMutable();
        offers_.set(index, value);
        onChanged();
      } else {
        offersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder setOffers(
        int index, com.berza.grpc.OrderRequest.Builder builderForValue) {
      if (offersBuilder_ == null) {
        ensureOffersIsMutable();
        offers_.set(index, builderForValue.build());
        onChanged();
      } else {
        offersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder addOffers(com.berza.grpc.OrderRequest value) {
      if (offersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureOffersIsMutable();
        offers_.add(value);
        onChanged();
      } else {
        offersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder addOffers(
        int index, com.berza.grpc.OrderRequest value) {
      if (offersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureOffersIsMutable();
        offers_.add(index, value);
        onChanged();
      } else {
        offersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder addOffers(
        com.berza.grpc.OrderRequest.Builder builderForValue) {
      if (offersBuilder_ == null) {
        ensureOffersIsMutable();
        offers_.add(builderForValue.build());
        onChanged();
      } else {
        offersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder addOffers(
        int index, com.berza.grpc.OrderRequest.Builder builderForValue) {
      if (offersBuilder_ == null) {
        ensureOffersIsMutable();
        offers_.add(index, builderForValue.build());
        onChanged();
      } else {
        offersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder addAllOffers(
        java.lang.Iterable<? extends com.berza.grpc.OrderRequest> values) {
      if (offersBuilder_ == null) {
        ensureOffersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, offers_);
        onChanged();
      } else {
        offersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder clearOffers() {
      if (offersBuilder_ == null) {
        offers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        offersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public Builder removeOffers(int index) {
      if (offersBuilder_ == null) {
        ensureOffersIsMutable();
        offers_.remove(index);
        onChanged();
      } else {
        offersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public com.berza.grpc.OrderRequest.Builder getOffersBuilder(
        int index) {
      return getOffersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public com.berza.grpc.OrderRequestOrBuilder getOffersOrBuilder(
        int index) {
      if (offersBuilder_ == null) {
        return offers_.get(index);  } else {
        return offersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public java.util.List<? extends com.berza.grpc.OrderRequestOrBuilder> 
         getOffersOrBuilderList() {
      if (offersBuilder_ != null) {
        return offersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(offers_);
      }
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public com.berza.grpc.OrderRequest.Builder addOffersBuilder() {
      return getOffersFieldBuilder().addBuilder(
          com.berza.grpc.OrderRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public com.berza.grpc.OrderRequest.Builder addOffersBuilder(
        int index) {
      return getOffersFieldBuilder().addBuilder(
          index, com.berza.grpc.OrderRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .OrderRequest offers = 1;</code>
     */
    public java.util.List<com.berza.grpc.OrderRequest.Builder> 
         getOffersBuilderList() {
      return getOffersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.berza.grpc.OrderRequest, com.berza.grpc.OrderRequest.Builder, com.berza.grpc.OrderRequestOrBuilder> 
        getOffersFieldBuilder() {
      if (offersBuilder_ == null) {
        offersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.berza.grpc.OrderRequest, com.berza.grpc.OrderRequest.Builder, com.berza.grpc.OrderRequestOrBuilder>(
                offers_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        offers_ = null;
      }
      return offersBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:OfferList)
  }

  // @@protoc_insertion_point(class_scope:OfferList)
  private static final com.berza.grpc.OfferList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.berza.grpc.OfferList();
  }

  public static com.berza.grpc.OfferList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OfferList>
      PARSER = new com.google.protobuf.AbstractParser<OfferList>() {
    @java.lang.Override
    public OfferList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OfferList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OfferList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OfferList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.berza.grpc.OfferList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
