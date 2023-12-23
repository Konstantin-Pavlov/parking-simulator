import util.CarRegNumberGenerator;

public class ParkingRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            CarRegNumberGenerator.getNewRegNumber();
        }

        CarRegNumberGenerator.getAllCarNumbers().forEach(System.out::println);
    }
}
