package smartfactorysystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class SmartFactoryDiscovery {

    public static void main(String[] args) {
        // Set to store services already resolved (avoid duplicates)
        Set<String> resolvedServices = new HashSet<>();

        // Clear the serviceinfo.txt file at start
        try (PrintWriter clearFile = new PrintWriter("serviceinfo.txt")) {
            clearFile.print("");
        } catch (IOException e) {
            System.err.println("Error clearing serviceinfo.txt: " + e.getMessage());
        }

        try {
            // Create JmDNS instance for service discovery
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Define a generic listener for your three service types
            ServiceListener listener = new ServiceListener() {

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: " + event.getName());
                    // Request detailed info to trigger serviceResolved
                    jmdns.requestServiceInfo(event.getType(), event.getName());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getName());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    ServiceInfo info = event.getInfo();

                    String ip = info.getInetAddresses()[0].getHostAddress();
                    int port = info.getPort();
                    String serviceKey = ip + ":" + port;

                    // Check if this service is already recorded
                    if (!resolvedServices.contains(serviceKey)) {
                        resolvedServices.add(serviceKey);

                        // Append IP:Port to serviceinfo.txt
                        try (PrintWriter out = new PrintWriter(new FileWriter("serviceinfo.txt", true))) {
                            out.println(serviceKey);
                        } catch (IOException e) {
                            System.err.println("Error writing to serviceinfo.txt: " + e.getMessage());
                        }

                        System.out.println("Service Resolved:");
                        System.out.println("Name: " + info.getName());
                        System.out.println("Type: " + info.getType());
                        System.out.println("Address: " + ip);
                        System.out.println("Port: " + port);
                        System.out.println("Metadata: " + info.getNiceTextString());
                    }
                }
            };

            // Add listeners for your three services
            jmdns.addServiceListener("_machinemonitorservice._tcp.local.", listener);
            jmdns.addServiceListener("_alertservice._tcp.local.", listener);
            jmdns.addServiceListener("_maintenanceservice._tcp.local.", listener);

            System.out.println("Discovery started. Listening for 60 seconds...");

            // Listen for 60 seconds
            Thread.sleep(60000);

            jmdns.close();
            System.out.println("Discovery stopped.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
