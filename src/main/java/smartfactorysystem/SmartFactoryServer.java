
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
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author vcaro
 */
public class SmartFactoryServer {
    public static void main (String args []) throws IOException, InterruptedException{
        Server server = ServerBuilder.forPort(9001)
                .addService(new MachineMonitorServiceImpl())
                .build()
                .start();
        
          Server server2 = ServerBuilder.forPort(9002)
            .addService(new AlertServiceImpl())
            .build()
            .start();
        
        Server server3 = ServerBuilder.forPort(9003)
            .addService(new MaintenanceScheduleServiceImpl())
            .build()
            .start();

        System.out.println("Server1 started on port 9001");
        System.out.println("Server2 started on port 9002");
        System.out.println("Server3 started on port 9003");

        server.awaitTermination();
        server2.awaitTermination();
        server3.awaitTermination();
    }


    
    //MACHINE MONITOR SERVICE Implement
    //Define messages for server-side streaming
    //The user ask for one request and receives multiple responses about different machines in the factory
    static class MachineMonitorServiceImpl extends MachineMonitorServiceGrpc.MachineMonitorServiceImplBase{
        @Override
        public void streamMetrics(MonitorRequest req, StreamObserver<MetricUpdate> responseObserver){
            try{
            long currentTimeMillis = System.currentTimeMillis();
            Date date = new Date(currentTimeMillis);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // format pattern
            String formattedDate = formatter.format(date);

                    //Response 1
                    MetricUpdate resp = MetricUpdate.newBuilder()
                            .setMachine("Motor A")
                            .setTemperature(90)
                            .setVibration(100)
                            .setTime(currentTimeMillis)
                            .build();
                    System.out.println(resp.getMachine() + "\nTemperature: " + resp.getTemperature()  + "F" +
                            "\nVibration: " + resp.getVibration() + "\nCurrent Time " + formattedDate);
                    
                    //Response 2
                    MetricUpdate resp2 = MetricUpdate.newBuilder()
                            .setMachine("Motor B")
                            .setTemperature(100)
                            .setVibration(050)
                            .setTime(currentTimeMillis)
                            .build();
                    System.out.println(resp2.getMachine() + "\nTemperature: " + resp2.getTemperature()  + "F" +
                            "\nVibration: " + resp2.getVibration() + "\nCurrent Time " + formattedDate);
                    
                    //Response 3
                    MetricUpdate resp3 = MetricUpdate.newBuilder()
                            .setMachine("Motor C")
                            .setTemperature(50)
                            .setVibration(80)
                            .setTime(currentTimeMillis)
                            .build();
                    System.out.println(resp3.getMachine() + "\nTemperature: " + resp3.getTemperature() + "%-5d" + "F" +
                            "\nVibration: " + resp3.getVibration() + "\nCurrent Time " + formattedDate);
                    
                    
                    responseObserver.onNext(resp);
                    responseObserver.onNext(resp2);
                    responseObserver.onNext(resp3);
                    
                    responseObserver.onCompleted();
        } catch (Exception e) {
            System.err.println("Error in streamMetrics: " + e.getMessage());
            e.printStackTrace();

        // Inform client of the error via gRPC status
        responseObserver.onError(io.grpc.Status.INTERNAL
            .withDescription("Server error: " + e.getMessage())
            .withCause(e)
            .asRuntimeException());
    }
}
        }
    
        
    //ALERT SERVICE Implement
    //RPC 1: Unary rpc (1 request / 1 response)
    static class AlertServiceImpl extends AlertServiceGrpc.AlertServiceImplBase{
       @Override
       public void getAlerts(AlertRequest req, StreamObserver<AlertResponse> responseObserver){
           try{
           AlertResponse resp = AlertResponse.newBuilder()
                   .setAlertType("Alert: Overheating")
                   .setSeverityLevel("4 (High)")
                   .build();
           System.out.println("Alert! All machines need to be check! " + resp.getAlertType()+ resp.getSeverityLevel());
           
           responseObserver.onNext(resp);
           responseObserver.onCompleted();
           
           }catch (Exception e){
               System.err.println("Error in alert service: " + e.getMessage());
               e.printStackTrace();
           
           responseObserver.onError(io.grpc.Status.INTERNAL
            .withDescription("Server error: " + e.getMessage())
            .withCause(e)
            .asRuntimeException());
       }
       } 
    
       
        //RPC 2: Client-Side streaming (multiple requests/ 1 response) 
      
       @Override
        public StreamObserver<LogEntry> sendDiagnostics(StreamObserver<LogSummary> responseObserver){
            
            return new StreamObserver<LogEntry>(){
                StringBuilder receivedSummary = new StringBuilder();

                @Override
                public void onNext(LogEntry ent) {
                    receivedSummary.append(ent.getDiagnostic()).append("");
                    receivedSummary.append(ent.getErrors()).append("");
                    System.out.println("Received Summary: " + ent.getDiagnostic() + ent.getErrors());
                     }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                   }

                @Override
                //Once the client has sent all data needed
                public void onCompleted() {
                    try{
                    LogSummary sum = LogSummary.newBuilder()
                            .setMessage("Summary of checking process: " + receivedSummary.toString())
                            .build();
                    
                responseObserver.onNext(sum);
                responseObserver.onCompleted();  
              }catch (Exception e){
               System.err.println("Error in alert service: " + e.getMessage());
               e.printStackTrace();
           
           responseObserver.onError(io.grpc.Status.INTERNAL
            .withDescription("Server error: " + e.getMessage())
            .withCause(e)
            .asRuntimeException());
       }
       } 
            };  
       };
     }
                    
        
    //SERVICE 3
    static class MaintenanceScheduleServiceImpl extends MaintenanceScheduleServiceGrpc.MaintenanceScheduleServiceImplBase{
    @Override
    public StreamObserver<MaintenanceRequest>scheduleMaintenance(StreamObserver<MaintenanceResponse> responseObserver){
        return new StreamObserver <MaintenanceRequest>(){
            @Override
            public void onNext(MaintenanceRequest req) {
                try{
                long currentTimeMillis = System.currentTimeMillis();
                Date date = new Date(currentTimeMillis);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                String formattedDate = formatter.format(date);
                String MachineID = req.getMachineID();
                
                String Description = req.getDescription();
                String Status = req.getStatus();
                String Technician = req.getTechnician();
                        
                MaintenanceResponse resp = MaintenanceResponse.newBuilder()
                        .setMachineID(MachineID)
                        .setDate(currentTimeMillis)
                        .setDescription(Description)
                        .setStatus(Status)
                        .setTechnician(Technician)
                        .build();
                responseObserver.onNext(resp);
                }catch (Exception e){
               System.err.println("Error in alert service: " + e.getMessage());
               e.printStackTrace();
           
           responseObserver.onError(io.grpc.Status.INTERNAL
            .withDescription("Server error: " + e.getMessage())
            .withCause(e)
            .asRuntimeException());
       }
       } 
                
                 

            @Override
            public void onError(Throwable t) {
                System.out.println("Error in bidirectional strem " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
                 }
            
        };
    }    
   }
    
    
}
                    
        
        
    
        

