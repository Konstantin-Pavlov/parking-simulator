package model;

import customExceptions.IlligalDateException;
import util.Biller;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Check {
    Car car;
    private final LocalDateTime arrivalTime;
    private final LocalDateTime departureTime;
    private final Duration duration;
    boolean valid;
    BigDecimal bill;
    private final UUID id;

    public Check(Car car, LocalDateTime arrivalTime, LocalDateTime departureTime) throws IlligalDateException {
        this.car = car;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.duration = Duration.between(arrivalTime, departureTime);
        this.valid = true;
        this.bill = Biller.calculateBill(arrivalTime, departureTime);
        this.id = UUID.randomUUID(); // Generate a unique ID using UUID
    }

    public UUID getId() {
        return id;
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

    public Duration getDuration() {
        return duration;
    }

    public boolean isValid() {
        return valid;
    }

    public BigDecimal getBill() {
        return bill;
    }
}
