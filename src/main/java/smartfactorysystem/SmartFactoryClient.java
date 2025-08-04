package smartfactorysystem;

import com.mycompany.smartfactorymonitoringsystem.AlertServiceGrpc;
import com.mycompany.smartfactorymonitoringsystem.MachineMonitorServiceGrpc;
import com.mycompany.smartfactorymonitoringsystem.MaintenanceScheduleServiceGrpc;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertRequest;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.AlertResponse;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogEntry;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.LogSummary;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceRequest;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MaintenanceResponse;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MetricUpdate;
import com.mycompany.smartfactorymonitoringsystem.SmartFactoryProto.MonitorRequest;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SmartFactoryClient {
    public static void main(String[] args) {
        Set<String> connectedServers = new HashSet<>();  // To avoid duplicate connections

        try (BufferedReader reader = new BufferedReader(new FileReader("serviceinfo.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
             String serverAddress = line.trim();
        if (serverAddress.isEmpty()) continue;

        // Skip duplicates
        if (connectedServers.contains(serverAddress)) {
             continue;
        }
        connectedServers.add(serverAddress);

        String[] parts = serverAddress.split(":");
        if (parts.length != 2) {
        System.out.println("Skipping malformed line: " + line);
        continue;
        }
        String IP = parts[0];
        int Port;
        try {
        Port = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println("Skipping line with invalid port: " + line);
                    continue;
        }

        System.out.println("Connected to discovered server at " + IP + ":" + Port);

        
        ManagedChannel channel = ManagedChannelBuilder.forAddress(IP, Port)
                .usePlaintext()
                .build();
        Metadata.Key<String> AUTH_KEY = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
        Metadata headers = new Metadata();
        headers.put(AUTH_KEY, "my_secret_token");
        
        
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(date);
         try {
                    if (Port == 9001) {
                        MachineMonitorServiceGrpc.MachineMonitorServiceStub asyncStub = MachineMonitorServiceGrpc.newStub(channel)
                                .withDeadline(Deadline.after(5, TimeUnit.SECONDS));
                        asyncStub = MetadataUtils.attachHeaders(asyncStub, headers);

                        MonitorRequest request = MonitorRequest.newBuilder()
                                .setMachine("MA01")
                                .setTemperature(90)
                                .setVibration(100)
                                .setTime(currentTimeMillis)
                                .build();

                        StreamObserver<MetricUpdate> responseObserver = new StreamObserver<MetricUpdate>() {
                            int counter = 0;

                            @Override
                            public void onNext(MetricUpdate update) {
                                System.out.println("Monitor :  " + update.getMachine() +
                                        "\nTemperature: " + update.getTemperature() +
                                        "\nVibration: " + update.getVibration() +
                                        "\nTime: " + formattedDate +
                                        "\n");

                                counter++;
                                if (counter == 1) {
                                    System.out.println("Cancelling stream after first update...");
                                    channel.shutdownNow();
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                System.err.println("Stream cancelled or failed: " + t.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("Stream completed by server.");
                            }
                        };

                        asyncStub.streamMetrics(request, responseObserver);
                        Thread.sleep(3000);
                        
                        
                        

                    } else if (Port == 9002) {
                        AlertServiceGrpc.AlertServiceBlockingStub stub2 = AlertServiceGrpc.newBlockingStub(channel)
                                .withDeadline(Deadline.after(3, TimeUnit.SECONDS));
                        stub2 = MetadataUtils.attachHeaders(stub2, headers);

                        try {
                            AlertResponse resp = stub2.getAlerts(AlertRequest.newBuilder()
                                    .setAlertType("Alert: Overheating")
                                    .setSeverityLevel("4 (High)")
                                    .build());
                            System.out.println("Alert! All machines need to be check! " +
                                    "\n" + resp.getAlertType() +
                                    "\n" + resp.getSeverityLevel());
                        } catch (StatusRuntimeException e) {
                            System.err.println("Error communicating with server: " + e.getStatus());
                        }

                        AlertServiceGrpc.AlertServiceStub asyncStub = AlertServiceGrpc.newStub(channel)
                                .withDeadline(Deadline.after(5, TimeUnit.SECONDS));
                        asyncStub = MetadataUtils.attachHeaders(asyncStub, headers);

                        StreamObserver<LogSummary> responseObserver = new StreamObserver<LogSummary>() {
                            @Override
                            public void onNext(LogSummary summary) {
                                System.out.println(summary.getMessage());
                            }

                            @Override
                            public void onError(Throwable t) {
                                System.out.println("Error from server: " + t.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("Server has finished processing the diagnostics.");
                            }
                        };

                        StreamObserver<LogEntry> requestObserver = asyncStub.sendDiagnostics(responseObserver);
                        try {
                            requestObserver.onNext(LogEntry.newBuilder().setDiagnostic("Danger of overheating. ").build());
                            requestObserver.onNext(LogEntry.newBuilder().setErrors("overheating Motor A01 and Motor B02").build());
                            Thread.sleep(1000);
                            requestObserver.onCompleted();
                        } catch (RuntimeException | InterruptedException e) {
                            requestObserver.onError(e);
                            throw new RuntimeException(e);
                        }
                        
                        
                        

                    } else if (Port == 9003) {
                        MaintenanceScheduleServiceGrpc.MaintenanceScheduleServiceStub asyncStub2 = MaintenanceScheduleServiceGrpc.newStub(channel)
                                .withDeadline(Deadline.after(5, TimeUnit.SECONDS));
                                 asyncStub2 = MetadataUtils.attachHeaders(asyncStub2, headers);


                        StreamObserver<MaintenanceResponse> responseObserver2 = new StreamObserver<MaintenanceResponse>() {
                            int counter =0;
                            @Override
                            public void onNext(MaintenanceResponse resp) {
                                System.out.println("MachineID: " + resp.getMachineID() +
                                        "\nDate: " + formattedDate +
                                        "\nDescription: " + resp.getDescription() +
                                        "\nStatus: " + resp.getStatus() +
                                        "\nTechnician: " + resp.getTechnician());
                                counter++;
                           if (counter == 1) {
                            channel.shutdownNow();
                            }
                            }
                            @Override
                            public void onError(Throwable t) {
                                System.out.println("Error: " + t.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("Server finished sending messages.");
                            }
                        };

                        StreamObserver<MaintenanceRequest> requestObserver2 = asyncStub2.scheduleMaintenance(responseObserver2);
                        try {
                            requestObserver2.onNext(MaintenanceRequest.newBuilder()
                                    .setMachineID("MA01")
                                    .setDate(currentTimeMillis)
                                    .setDescription("Schedule inspections due to high levels of vibration")
                                    .setStatus("Orange: medium danger")
                                    .setTechnician("John Doe")
                                    .build());
                            requestObserver2.onNext(MaintenanceRequest.newBuilder()
                                    .setMachineID("MA02")
                                    .setDate(currentTimeMillis)
                                    .setDescription("Schedule inspections due to high levels of temperature")
                                    .setStatus("Red: high danger")
                                    .setTechnician("Thomas Clarke")
                                    .build());
                            requestObserver2.onNext(MaintenanceRequest.newBuilder()
                                    .setMachineID("MA20")
                                    .setDate(currentTimeMillis)
                                    .setDescription("Schedule inspections does not show errors")
                                    .setStatus("White: perfect conditions")
                                    .setTechnician("John Connolly")
                                    .build());
                            
                            requestObserver2.onCompleted();
                        } catch (RuntimeException e) {
                            requestObserver2.onError(e);
                            throw e;
                        }
                    } else {
                        System.out.println("Unknown service port: " + Port);
                    }
                } catch (Exception e) {
                    System.out.println("Error communicating with server " + IP + ":" + Port + " - " + e.getMessage());
                } finally {
                    channel.shutdown();
                }

                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

        




                