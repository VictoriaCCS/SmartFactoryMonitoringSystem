package com.mycompany.smartfactorymonitoringsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *SERVICES
 *Service1 : Server-Side streaming (1 request and multiple responses from server)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: SmartFactory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MachineMonitorServiceGrpc {

  private MachineMonitorServiceGrpc() {}

  public static final String SERVICE_NAME = "MachineMonitorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate> getStreamMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamMetrics",
      requestType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest.class,
      responseType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate> getStreamMetricsMethod() {
    io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate> getStreamMetricsMethod;
    if ((getStreamMetricsMethod = MachineMonitorServiceGrpc.getStreamMetricsMethod) == null) {
      synchronized (MachineMonitorServiceGrpc.class) {
        if ((getStreamMetricsMethod = MachineMonitorServiceGrpc.getStreamMetricsMethod) == null) {
          MachineMonitorServiceGrpc.getStreamMetricsMethod = getStreamMetricsMethod =
              io.grpc.MethodDescriptor.<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamMetrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new MachineMonitorServiceMethodDescriptorSupplier("StreamMetrics"))
              .build();
        }
      }
    }
    return getStreamMetricsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MachineMonitorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineMonitorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineMonitorServiceStub>() {
        @java.lang.Override
        public MachineMonitorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineMonitorServiceStub(channel, callOptions);
        }
      };
    return MachineMonitorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MachineMonitorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineMonitorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineMonitorServiceBlockingStub>() {
        @java.lang.Override
        public MachineMonitorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineMonitorServiceBlockingStub(channel, callOptions);
        }
      };
    return MachineMonitorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MachineMonitorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MachineMonitorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MachineMonitorServiceFutureStub>() {
        @java.lang.Override
        public MachineMonitorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MachineMonitorServiceFutureStub(channel, callOptions);
        }
      };
    return MachineMonitorServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *SERVICES
   *Service1 : Server-Side streaming (1 request and multiple responses from server)
   * </pre>
   */
  public static abstract class MachineMonitorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamMetrics(com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamMetricsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest,
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate>(
                  this, METHODID_STREAM_METRICS)))
          .build();
    }
  }

  /**
   * <pre>
   *SERVICES
   *Service1 : Server-Side streaming (1 request and multiple responses from server)
   * </pre>
   */
  public static final class MachineMonitorServiceStub extends io.grpc.stub.AbstractAsyncStub<MachineMonitorServiceStub> {
    private MachineMonitorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineMonitorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineMonitorServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamMetrics(com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamMetricsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *SERVICES
   *Service1 : Server-Side streaming (1 request and multiple responses from server)
   * </pre>
   */
  public static final class MachineMonitorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MachineMonitorServiceBlockingStub> {
    private MachineMonitorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineMonitorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineMonitorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate> streamMetrics(
        com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamMetricsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *SERVICES
   *Service1 : Server-Side streaming (1 request and multiple responses from server)
   * </pre>
   */
  public static final class MachineMonitorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MachineMonitorServiceFutureStub> {
    private MachineMonitorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MachineMonitorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MachineMonitorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_METRICS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MachineMonitorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MachineMonitorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_METRICS:
          serviceImpl.streamMetrics((com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate>) responseObserver);
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

  private static abstract class MachineMonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MachineMonitorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MachineMonitorService");
    }
  }

  private static final class MachineMonitorServiceFileDescriptorSupplier
      extends MachineMonitorServiceBaseDescriptorSupplier {
    MachineMonitorServiceFileDescriptorSupplier() {}
  }

  private static final class MachineMonitorServiceMethodDescriptorSupplier
      extends MachineMonitorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MachineMonitorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MachineMonitorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MachineMonitorServiceFileDescriptorSupplier())
              .addMethod(getStreamMetricsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
