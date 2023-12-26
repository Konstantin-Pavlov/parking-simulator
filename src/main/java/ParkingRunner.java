import customExceptions.CarNotPresentException;
import customExceptions.IlligalDateException;
import customExceptions.RecordNotPresentException;
import model.Car;
import model.ParkingLog;
import model.ParkingRecord;
import util.ConsoleColors;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingRunner {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            CarRegNumberGenerator.getNewRegNumber();
//        }

//        CarRegNumberGenerator.getAllCarNumbers().forEach(System.out::println);

        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 22, 15, 21);
        Car car = new Car("fgf654");

        ParkingLog parkingLog = new ParkingLog();
        parkingLog.checkIn(car, entryTime);
        try {
            parkingLog.checkOut(car, exitTime);
        } catch (IlligalDateException | CarNotPresentException | RecordNotPresentException e) {
            System.out.println(ConsoleColors.ANSI_RED + e.getMessage() + ConsoleColors.ANSI_RESET);

        }

        parkingLog.checkIn(car, LocalDateTime.of(2023, 12, 23, 15, 2));
        try {
            parkingLog.checkOut(car, LocalDateTime.of(2023, 12, 23, 19, 57));
        } catch (IlligalDateException | CarNotPresentException | RecordNotPresentException e) {
            System.out.println(ConsoleColors.ANSI_RED + e.getMessage() + ConsoleColors.ANSI_RESET);

        }

        List<ParkingRecord> records = parkingLog.getCarParkingRecords(car);

        records.forEach(record -> {
            System.out.println(record.isRecordComplete());
            System.out.println(record.getCar().getRegNumber());
            System.out.println(record.getArrivalTime());
            System.out.println(record.getDepartureTime());
            System.out.println(record.getDuration());
            System.out.println(record.getCheck());
            System.out.println(record.getBill());
            System.out.println();
        });


    }

}


