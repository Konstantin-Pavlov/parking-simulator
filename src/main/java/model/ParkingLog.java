package model;

import customExceptions.CarNotPresentException;
import customExceptions.IlligalDateException;
import customExceptions.RecordNotPresentException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLog {
    private final Map<Car, List<ParkingRecord>> parkingRecords;
    private BigDecimal totalIncome;

    public ParkingLog() {
        this.parkingRecords = new HashMap<>();
        this.totalIncome = BigDecimal.ZERO;
    }

    public void checkIn(Car car, LocalDateTime arrivalTime) {
        if (parkingRecords.containsKey(car)) {
            parkingRecords.get(car).add(new ParkingRecord(car, arrivalTime));
        } else {
            parkingRecords.put(car, new ArrayList<ParkingRecord>(List.of(new ParkingRecord(car, arrivalTime))));
        }
    }

    public void checkOut(Car car, LocalDateTime departureTime)
            throws IlligalDateException, CarNotPresentException, RecordNotPresentException {

        Car checkingOutCar = checkAndGetTheCar(car);
        ParkingRecord thisCarParkingRecord = getAndCheckParkingRecord(checkingOutCar);
        arrivalAndDepartureTimeCheck(thisCarParkingRecord.getArrivalTime(), departureTime);

        // will be the map updated? need to test it. yes, it updates
//        List<ParkingRecord> checkingOutCarRecords = parkingRecords.get(checkingOutCar);
        thisCarParkingRecord.registerLeavingTheParkingLot(departureTime);


        totalIncome = totalIncome.add(thisCarParkingRecord.getBill());

    }


    public Optional<Car> searchByCar(Car car) {
        return parkingRecords.keySet().stream()
                .filter(c -> c.equals(car))
                .findFirst();
    }

    public List<ParkingRecord> getCarParkingRecords(Car car) {
        return parkingRecords.get(car);
    }

    public BigDecimal getTotalRevenue() {
        return totalIncome;
    }

    private void arrivalAndDepartureTimeCheck(LocalDateTime arrivalTime, LocalDateTime departureTime) throws IlligalDateException {
        if (arrivalTime == null) {
            throw new IlligalDateException("arrival time is null");
        }
        if (departureTime == null) {
            throw new IlligalDateException("departure time is null");
        }
        if (arrivalTime.isAfter(departureTime)) {
            throw new IlligalDateException("the entry date can not be after exit date");
        }
    }

    private ParkingRecord getAndCheckParkingRecord(Car car) throws RecordNotPresentException {
        ParkingRecord thisCarParkingRecord = parkingRecords.get(car).getLast();
        if (thisCarParkingRecord == null) {
            throw new RecordNotPresentException("couldn't fine the car record");
        }
        return thisCarParkingRecord;
    }

    private Car checkAndGetTheCar(Car car) throws CarNotPresentException {
        Car checkingOutCar = searchByCar(car).orElse(null);
        // or Car foundCar = searchByCar(someCar).orElseThrow(() -> new CarNotFoundException("Car not found"));
        if (checkingOutCar == null) {
            throw new CarNotPresentException("error: car doesn't exist");
        }
        return checkingOutCar;
    }

}
