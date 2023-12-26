package model;

import customExceptions.IlligalDateException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingRecord {
    private final  Car car; // maybe move to parking log
    private boolean complete;
    private final LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public ParkingRecord(Car car, LocalDateTime arrivalTime) {
        this.car = car;
        this.complete = false; // until car leaves the parking and pays the bill
        this.arrivalTime = arrivalTime;

        // we can't know departureTime and duration when car just arrives to the parking lot
//        this.departureTime = departureTime;
//        this.duration = Duration.between(arrivalTime, departureTime);
    }

    public void registerEntryToParking(){
        // useless
    }

    public void registerLeavingTheParkingLot(LocalDateTime departureTime){
        this.departureTime = departureTime;
        this.complete = true;
        // generate bill? and store it in this class
        // generate check? and store it in this class
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public boolean isRecordComplete() {
        return complete;
    }

    public Duration getDuration() throws IlligalDateException {
        if (arrivalTime == null ) {
            throw new  IlligalDateException("arrival time is null");
        } else if(departureTime == null){
            throw new IlligalDateException("departure time is null");
        }
        return Duration.between(arrivalTime, departureTime);
    }
}
