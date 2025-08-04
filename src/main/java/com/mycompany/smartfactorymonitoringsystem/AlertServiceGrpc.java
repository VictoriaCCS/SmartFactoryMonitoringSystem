package com.mycompany.smartfactorymonitoringsystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service2: Unary rpc (1 request/1 response) 
 *Side-Client streaming (Multiple requests/1 response from server)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: SmartFactory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlertServiceGrpc {

  private AlertServiceGrpc() {}

  public static final String SERVICE_NAME = "AlertService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse> getGetAlertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAlerts",
      requestType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest.class,
      responseType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse> getGetAlertsMethod() {
    io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse> getGetAlertsMethod;
    if ((getGetAlertsMethod = AlertServiceGrpc.getGetAlertsMethod) == null) {
      synchronized (AlertServiceGrpc.class) {
        if ((getGetAlertsMethod = AlertServiceGrpc.getGetAlertsMethod) == null) {
          AlertServiceGrpc.getGetAlertsMethod = getGetAlertsMethod =
              io.grpc.MethodDescriptor.<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAlerts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AlertServiceMethodDescriptorSupplier("GetAlerts"))
              .build();
        }
      }
    }
    return getGetAlertsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary> getSendDiagnosticsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDiagnostics",
      requestType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry.class,
      responseType = com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry,
      com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary> getSendDiagnosticsMethod() {
    io.grpc.MethodDescriptor<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary> getSendDiagnosticsMethod;
    if ((getSendDiagnosticsMethod = AlertServiceGrpc.getSendDiagnosticsMethod) == null) {
      synchronized (AlertServiceGrpc.class) {
        if ((getSendDiagnosticsMethod = AlertServiceGrpc.getSendDiagnosticsMethod) == null) {
          AlertServiceGrpc.getSendDiagnosticsMethod = getSendDiagnosticsMethod =
              io.grpc.MethodDescriptor.<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry, com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendDiagnostics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary.getDefaultInstance()))
              .setSchemaDescriptor(new AlertServiceMethodDescriptorSupplier("SendDiagnostics"))
              .build();
        }
      }
    }
    return getSendDiagnosticsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlertServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlertServiceStub>() {
        @java.lang.Override
        public AlertServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlertServiceStub(channel, callOptions);
        }
      };
    return AlertServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlertServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlertServiceBlockingStub>() {
        @java.lang.Override
        public AlertServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlertServiceBlockingStub(channel, callOptions);
        }
      };
    return AlertServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlertServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlertServiceFutureStub>() {
        @java.lang.Override
        public AlertServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlertServiceFutureStub(channel, callOptions);
        }
      };
    return AlertServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service2: Unary rpc (1 request/1 response) 
   *Side-Client streaming (Multiple requests/1 response from server)
   * </pre>
   */
  public static abstract class AlertServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAlerts(com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAlertsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry> sendDiagnostics(
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendDiagnosticsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAlertsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest,
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse>(
                  this, METHODID_GET_ALERTS)))
          .addMethod(
            getSendDiagnosticsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry,
                com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary>(
                  this, METHODID_SEND_DIAGNOSTICS)))
          .build();
    }
  }

  /**
   * <pre>
   *Service2: Unary rpc (1 request/1 response) 
   *Side-Client streaming (Multiple requests/1 response from server)
   * </pre>
   */
  public static final class AlertServiceStub extends io.grpc.stub.AbstractAsyncStub<AlertServiceStub> {
    private AlertServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAlerts(com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAlertsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry> sendDiagnostics(
        io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendDiagnosticsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Service2: Unary rpc (1 request/1 response) 
   *Side-Client streaming (Multiple requests/1 response from server)
   * </pre>
   */
  public static final class AlertServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AlertServiceBlockingStub> {
    private AlertServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse getAlerts(com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAlertsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service2: Unary rpc (1 request/1 response) 
   *Side-Client streaming (Multiple requests/1 response from server)
   * </pre>
   */
  public static final class AlertServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AlertServiceFutureStub> {
    private AlertServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse> getAlerts(
        com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAlertsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALERTS = 0;
  private static final int METHODID_SEND_DIAGNOSTICS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlertServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlertServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALERTS:
          serviceImpl.getAlerts((com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse>) responseObserver);
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
        case METHODID_SEND_DIAGNOSTICS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendDiagnostics(
              (io.grpc.stub.StreamObserver<com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlertServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlertService");
    }
  }

  private static final class AlertServiceFileDescriptorSupplier
      extends AlertServiceBaseDescriptorSupplier {
    AlertServiceFileDescriptorSupplier() {}
  }

  private static final class AlertServiceMethodDescriptorSupplier
      extends AlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlertServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlertServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlertServiceFileDescriptorSupplier())
              .addMethod(getGetAlertsMethod())
              .addMethod(getSendDiagnosticsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
