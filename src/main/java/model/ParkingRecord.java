package model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingRecord {
    private final Car car; // maybe move to parking log
    private Check check;
    private BigDecimal bill;
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

    public void registerEntryToParking() {
        // useless
    }

    public void registerLeavingTheParkingLot(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        this.complete = true;
        // generate bill? and store it in this class
        this.check = new Check(arrivalTime, departureTime);
        // generate check? and store it in this class
        this.bill = check.getBill();
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

    public Check getCheck() {
        return check;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public boolean isRecordComplete() {
        return complete;
    }

    public Duration getDuration() {
        return Duration.between(arrivalTime, departureTime);
    }


}
