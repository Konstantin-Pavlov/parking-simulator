package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingRecord {
    private final  Car car; // maybe move to parking log
    private boolean valid; // change to complete? flag that the record is done (car arrives, stays, pays the bill, leaves)
    private final LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Duration duration;

    public ParkingRecord(Car car, LocalDateTime arrivalTime) {
        this.car = car;
        this.valid = false; // until car leaves the parking and pays the bill
        this.arrivalTime = arrivalTime;

        // we can't know departureTime and duration when car just arrives to the parking lot
//        this.departureTime = departureTime;
//        this.duration = Duration.between(arrivalTime, departureTime);
    }

    public void registerEntryToParking(){

    }

    public void registerLeavingTheParkingLot(LocalDateTime departureTime){
        this.departureTime = departureTime;
        this.valid = true;
        // generate bill?
        // generate check?
    }


}
