package smartfactorysystem;

import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

/**
 *
 * @author vcaro
 */
public class SmartFactoryAdvetiser {
    public static void main(String[] args) throws IOException {
        try{
            //Creating jmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            
            //Create a service info for the smartfactory
            ServiceInfo serviceInfo = ServiceInfo.create(
                    "_machinemonitorservice._tcp.local.",
                    "MA01",
                    9001,
                    "status = off"
            );
            
            ServiceInfo serviceInfo2 = ServiceInfo.create(
                    "_alertservice._tcp.local.",
                    "AL01",
                    9002,
                    "status = off"
            );
            
            ServiceInfo serviceInfo3 = ServiceInfo.create(
                    "_maintenanceservice._tcp.local.",
                    "Main00",
                    9003,
                    "status = off"      
            );
            
            
            
            
            jmdns.registerService(serviceInfo);
            jmdns.registerService(serviceInfo2);
            jmdns.registerService(serviceInfo3);
           
            System.out.println("Machine Monitor Service now registered on port 9001");
            System.out.println("Alert Service now registered on port 9002");
            System.out.println("Maintenance Service now registered on port 9003");
            Thread.sleep(60000);
            
            jmdns.unregisterAllServices();
            jmdns.close();
            System.out.println("Machine Monitor Service unregistered");
            
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    
    
    
}
