# Smart Factory Monitoring System

**gRPC-based Java project simulating a smart factory environment**

## Description
This project simulates a **smart factory** using **gRPC services** in Java. It demonstrates communication between multiple services, service discovery using **jmDNS**, and real-time monitoring of machines, alerts, and maintenance schedules.

The project was created as a **student project** for learning **distributed systems and gRPC in Java**.

## Architecture / Services
The system consists of three main services:

1. **MachineMonitorService**  
   - Monitors factory machines
   - Provides temperature and operational status data

2. **AlertService**  
   - Receives data from machines
   - Generates alerts based on thresholds (e.g., overheating)

3. **MaintenanceScheduleService**  
   - Tracks machine maintenance schedules
   - Suggests upcoming maintenance tasks

## Features
- Uses **gRPC with Java** (all 4 RPC types: unary, server streaming, client streaming, bidirectional)  
- Implements **service discovery** using jmDNS  
- Writes discovered services to `serviceinfo.txt`  
- Demonstrates real-time communication between multiple services  
- Error handling and defensive programming included  

## Tech Stack
- Java 17  
- gRPC  
- Maven  
- jmDNS  

## How to Run
1. Clone the repo:  
   ```bash
   git clone https://github.com/YOUR_USERNAME/SmartFactory.git
