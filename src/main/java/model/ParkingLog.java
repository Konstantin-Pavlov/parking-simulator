package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLog {
    private final Map<Car, List<ParkingRecord>> parkingRecords = new HashMap<>();

    public void checkIn(Car car, LocalDateTime arrivalTime) {
        if (parkingRecords.containsKey(car)) {
            parkingRecords.get(car).add(new ParkingRecord(car, arrivalTime));
        } else {
            parkingRecords.put(car, new ArrayList<ParkingRecord>(List.of(new ParkingRecord(car, arrivalTime))));
        }
    }

    public void checkOut(Car car, LocalDateTime departureTime) {
        // add checks
        Car checkingOutCar = searchByCar(car).orElse(null);
        // or Car foundCar = searchByCar(someCar).orElseThrow(() -> new CarNotFoundException("Car not found"));
        if (checkingOutCar == null) {
            System.err.println("error: car doesn't exist");
        } else {
            // will be the map updated? need to test it
            List<ParkingRecord> checkingOutCarRecords = parkingRecords.get(checkingOutCar);
            checkingOutCarRecords.getLast().registerLeavingTheParkingLot(departureTime);
        }
    }

    private Optional<Car> searchByCar(Car car) {
        return parkingRecords.keySet().stream()
                .filter(c -> c.equals(car))
                .findFirst();
    }

    public List<ParkingRecord> getCarParkingRecords(Car car) {
        return parkingRecords.get(car);
    }

    public BigDecimal getTotalRevenue() {
        return null;
    }

}
