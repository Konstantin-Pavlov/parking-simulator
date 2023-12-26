package model;

import util.Biller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Check {
    // should be created in parking log? after car exits parking. so we have exit time and can generate a check
    private final BigDecimal bill;
    private final UUID id;

    public Check(LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.bill = Biller.calculateBill(arrivalTime, departureTime);
        this.id = UUID.randomUUID(); // Generate a unique ID using UUID
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return "Check{" +
                "bill=" + bill +
                ", id=" + id +
                '}';
    }
}
