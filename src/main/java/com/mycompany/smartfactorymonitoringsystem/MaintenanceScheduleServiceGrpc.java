package com.mycompany.smartfactorymonitoringsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service3: Bidirectional Streaming (Multiple requests/ Multiple responses)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: SmartFactory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MaintenanceScheduleServiceGrpc {

  private MaintenanceScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "MaintenanceScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse> getScheduleMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleMaintenance",
      requestType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest.class,
      responseType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse> getScheduleMaintenanceMethod() {
    io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse> getScheduleMaintenanceMethod;
    if ((getScheduleMaintenanceMethod = MaintenanceScheduleServiceGrpc.getScheduleMaintenanceMethod) == null) {
      synchronized (MaintenanceScheduleServiceGrpc.class) {
        if ((getScheduleMaintenanceMethod = MaintenanceScheduleServiceGrpc.getScheduleMaintenanceMethod) == null) {
          MaintenanceScheduleServiceGrpc.getScheduleMaintenanceMethod = getScheduleMaintenanceMethod =
              io.grpc.MethodDescriptor.<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleMaintenance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MaintenanceScheduleServiceMethodDescriptorSupplier("ScheduleMaintenance"))
              .build();
        }
      }
    }
    return getScheduleMaintenanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MaintenanceScheduleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceScheduleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MaintenanceScheduleServiceStub>() {
        @java.lang.Override
        public MaintenanceScheduleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MaintenanceScheduleServiceStub(channel, callOptions);
        }
      };
    return MaintenanceScheduleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MaintenanceScheduleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceScheduleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MaintenanceScheduleServiceBlockingStub>() {
        @java.lang.Override
        public MaintenanceScheduleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MaintenanceScheduleServiceBlockingStub(channel, callOptions);
        }
      };
    return MaintenanceScheduleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MaintenanceScheduleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MaintenanceScheduleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MaintenanceScheduleServiceFutureStub>() {
        @java.lang.Override
        public MaintenanceScheduleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MaintenanceScheduleServiceFutureStub(channel, callOptions);
        }
      };
    return MaintenanceScheduleServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service3: Bidirectional Streaming (Multiple requests/ Multiple responses)
   * </pre>
   */
  public static abstract class MaintenanceScheduleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest> scheduleMaintenance(
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getScheduleMaintenanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScheduleMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest,
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse>(
                  this, METHODID_SCHEDULE_MAINTENANCE)))
          .build();
    }
  }

  /**
   * <pre>
   *Service3: Bidirectional Streaming (Multiple requests/ Multiple responses)
   * </pre>
   */
  public static final class MaintenanceScheduleServiceStub extends io.grpc.stub.AbstractAsyncStub<MaintenanceScheduleServiceStub> {
    private MaintenanceScheduleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceScheduleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceScheduleServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest> scheduleMaintenance(
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getScheduleMaintenanceMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Service3: Bidirectional Streaming (Multiple requests/ Multiple responses)
   * </pre>
   */
  public static final class MaintenanceScheduleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MaintenanceScheduleServiceBlockingStub> {
    private MaintenanceScheduleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceScheduleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceScheduleServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *Service3: Bidirectional Streaming (Multiple requests/ Multiple responses)
   * </pre>
   */
  public static final class MaintenanceScheduleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MaintenanceScheduleServiceFutureStub> {
    private MaintenanceScheduleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceScheduleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MaintenanceScheduleServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SCHEDULE_MAINTENANCE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MaintenanceScheduleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MaintenanceScheduleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCHEDULE_MAINTENANCE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.scheduleMaintenance(
              (io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MaintenanceScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MaintenanceScheduleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MaintenanceScheduleService");
    }
  }

  private static final class MaintenanceScheduleServiceFileDescriptorSupplier
      extends MaintenanceScheduleServiceBaseDescriptorSupplier {
    MaintenanceScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class MaintenanceScheduleServiceMethodDescriptorSupplier
      extends MaintenanceScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MaintenanceScheduleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MaintenanceScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MaintenanceScheduleServiceFileDescriptorSupplier())
              .addMethod(getScheduleMaintenanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
