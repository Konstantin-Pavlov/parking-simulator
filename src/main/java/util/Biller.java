package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

public class Biller {

    public static double calculateBill(){
        // use BigDecimal for cash ops
        BigDecimal value = new BigDecimal("123.456789");
        BigDecimal roundedValue = value.setScale(2, RoundingMode.HALF_UP);
        System.out.println(roundedValue); // Output: 123.46

        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 22, 15, 21);

        double costPerFiveMinutes = 0.10;
        double totalCost = 0.0;

        int startFreeParkingTime = 21;
        int endFreeParkingTime = 9;

        // maybe use it later
        LocalDateTime freeParkingStart = LocalDateTime.of(entryTime.getYear(), entryTime.getMonth(), entryTime.getDayOfMonth(), 21, 0).minusDays(1);
        LocalDateTime freeParkingEnd = LocalDateTime.of(exitTime.getYear(), exitTime.getMonth(), exitTime.getDayOfMonth(), 9, 0);

        Duration parkingDuration = Duration.between(entryTime, exitTime);
        long totalMinutes = parkingDuration.toMinutes();

        ////

        LocalDateTime currentMinute = entryTime;
        while (currentMinute.isBefore(exitTime)) {
            if (currentMinute.getHour() == startFreeParkingTime) {
                currentMinute = currentMinute.plusHours(12);
            } else {
                if(currentMinute.getMinute() % 5 == 0){
                    totalCost += costPerFiveMinutes;
                }
                currentMinute = currentMinute.plusMinutes(1);
            }

        }

        System.out.printf("%.2f%n", totalCost);
        return totalCost;
    }
}
