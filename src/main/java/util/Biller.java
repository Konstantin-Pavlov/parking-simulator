package util;

import customExceptions.IlligalDateException;

import java.time.Duration;
import java.time.LocalDateTime;

public class Biller {
    private Biller() {
    }

    public static double calculateBill(LocalDateTime entryTime, LocalDateTime exitTime) throws IlligalDateException {
        // todo use BigDecimal for cash ops
//        BigDecimal value = new BigDecimal("123.456789");
//        BigDecimal roundedValue = value.setScale(2, RoundingMode.HALF_UP);
//        System.out.println(roundedValue); // Output: 123.46

        if (entryTime.isAfter(exitTime)) {
            throw new IlligalDateException("the entry date can not be after exit date");
        }

        // 30 minutes is free
        if (Duration.between(entryTime, exitTime).toMinutes() <= 30) {
            return 0.0;
        }

        double costPerFiveMinutes = 0.10;
        double totalCost = entryTime.getMinute() % 5 == 0 ? 0.0 : 0.1; // for example: if the car arrives at 15:57 we charge 5 minutes (15:55-16:00)

        int startFreeParkingTime = 21;
        int endFreeParkingTime = 9;

        // maybe use it later
//        LocalDateTime freeParkingStart = LocalDateTime.of(entryTime.getYear(), entryTime.getMonth(), entryTime.getDayOfMonth(), 21, 0).minusDays(1);
//        LocalDateTime freeParkingEnd = LocalDateTime.of(exitTime.getYear(), exitTime.getMonth(), exitTime.getDayOfMonth(), 9, 0);
//
//        Duration parkingDuration = Duration.between(entryTime, exitTime);
//        long totalMinutes = parkingDuration.toMinutes();

        ////

        LocalDateTime currentMinute = entryTime;
        while (currentMinute.isBefore(exitTime)) {
            if (currentMinute.getHour() == startFreeParkingTime) {
                currentMinute = currentMinute.plusHours(12);
            } else {
                if (currentMinute.getMinute() % 5 == 0) {
                    totalCost += costPerFiveMinutes;
                }
                currentMinute = currentMinute.plusMinutes(1);
            }
        }
        System.out.println();

//        System.out.printf("%.2f%n", totalCost);
        return totalCost;
    }
}
