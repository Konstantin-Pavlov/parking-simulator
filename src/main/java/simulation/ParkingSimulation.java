package simulation;

import model.Car;
import model.ParkingLog;
import util.CarRegNumberGenerator;
import util.ConsoleColors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingSimulation {
    private static final int PARKING_CAPACITY = 20;
    private List<Car>  cars;
    private final List<Car>  parkedCars;
    private final ParkingLog log;
    private final LocalDateTime start;
    private final DateTimeFormatter timeFormatter;
    private final Random random;

    public ParkingSimulation() {
        this.parkedCars = new ArrayList<>(PARKING_CAPACITY);
        this.log = new ParkingLog();
        this.start = LocalDateTime.now();
        this.timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.random = new Random();
        generateCars();
    }

    public void startSimulation(){
        LocalDateTime end = start.plusDays(7);
        for (LocalDateTime currentTime = start; currentTime.isBefore(end); currentTime = currentTime.plusMinutes(5)) {

            // 3% probability that car arrives and park
            if(random.nextInt(100) < 3){
                carArrivesToTheParkingLot(currentTime);
            }

            // 3% probability that car leaves the parking
            if(random.nextInt(100) < 3){
                carLeavesToTheParkingLot(currentTime);
            }


        }
    }

    private void generateCars(){
        cars  = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car(CarRegNumberGenerator.getNewRegNumber()));
        }
    }

    private void carArrivesToTheParkingLot(LocalDateTime currentTime){
        if(parkedCars.size() > PARKING_CAPACITY){
            System.out.println(ConsoleColors.ANSI_RED + "The parking lot is full - it is impossible to park the car" + ConsoleColors.ANSI_RESET);
            return;
        }
        if(cars.isEmpty()){
            System.out.println(ConsoleColors.ANSI_RED + "call for carArrivesToTheParkingLot method but cars list is empty, all cars are parked in the parking" + ConsoleColors.ANSI_RESET);
            return;
        }
        Car car = cars.get(random.nextInt(cars.size()));
        cars.remove(car);
        parkedCars.add(car);
        System.out.println(ConsoleColors.ANSI_GREEN_BACKGROUND + currentTime.format(timeFormatter) +  ": car " + car.getRegNumber() + " arrives to the parkingLot" + ConsoleColors.ANSI_RESET);
        car.park();
        drawLine();
    }

    private void carLeavesToTheParkingLot(LocalDateTime currentTime){
        if(parkedCars.isEmpty()){
            System.out.println(ConsoleColors.ANSI_RED + "call for carLeavesToTheParkingLot method but the parking lot is empty" + ConsoleColors.ANSI_RESET);
            return;
        }
        Car car = parkedCars.get(random.nextInt(parkedCars.size()));
        parkedCars.remove(car);
        cars.add(car);
        System.out.println(ConsoleColors.ANSI_CYAN_BACKGROUND + currentTime.format(timeFormatter) +  ": car " + car.getRegNumber() + " leaves the parkingLot" + ConsoleColors.ANSI_RESET);
        car.leave();
        drawLine();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public ParkingLog getLog() {
        return log;
    }

    private void drawLine(){
        System.out.println(ConsoleColors.BLACK + "#".repeat(100) + ConsoleColors.RESET);
    }
}
