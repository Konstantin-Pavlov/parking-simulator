# Parking Simulation

This project is a parking simulation that tracks cars entering and exiting a parking lot, records their visits, and calculates associated costs. It provides a log to store parking records and a simulation to orchestrate the parking process.

## Project Structure

The project follows the following package structure:

- src
    - main
        - java
            - com.yourcompany.parking
                - model
                    - Car.java
                    - ParkingLot.java
                - log
                    - ParkingRecord.java
                    - ParkingLog.java
                - simulation
                    - ParkingSimulation.java
    - test
        - java
            - com.yourcompany.parking
                - model
                    - CarTest.java
                    - ParkingLotTest.java
                - log
                    - ParkingRecordTest.java
                    - ParkingLogTest.java
                - simulation
                    - ParkingSimulationTest.java


## Class Descriptions

### Car

Represents a car and its attributes.

### ParkingLot

Represents the parking lot and its properties, such as capacity, availability, and pricing information.

### ParkingRecord

Represents a record of a car's visit to the parking lot, including the entry time, exit time, and associated cost.

### ParkingLog

Manages the log of parking records, including adding new records, retrieving records, and calculating total revenue.

### ParkingSimulation

Orchestrates the parking simulation, handling car arrivals and departures, interacting with the parking lot and log, and generating reports.

## Usage

To use the parking simulation, you can create an instance of the `ParkingSimulation` class and call its methods to simulate car arrivals and departures. The simulation will interact with the parking lot and log to record the visits and calculate costs.

```java
// Create a ParkingSimulation instance
ParkingSimulation simulation = new ParkingSimulation();

// Simulate a car arrival
simulation.carArrival(car);

// Simulate a car departure
simulation.carDeparture(car);