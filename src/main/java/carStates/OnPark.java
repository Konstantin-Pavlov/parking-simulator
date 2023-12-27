package carStates;

import customExceptions.IlligalCarStateException;
import interfaces.CarState;
import model.Car;
import util.ConsoleColors;

public class OnPark implements CarState {
    @Override
    public void park(Car car) throws IlligalCarStateException {
        throw new IlligalCarStateException(ConsoleColors.RED_BACKGROUND +
                "it is impossible to park the car because the car is already parked and is in the parking lot" +
                ConsoleColors.RESET);
    }

    @Override
    public void leaveParking(Car car) {
        System.out.println(ConsoleColors.ANSI_GREEN_BACKGROUND +
                "the car " + car.getRegNumber() + " has successfully left the parking lot, car state was changed to driving" +
                ConsoleColors.RESET);
        car.setState(new OnRoute());
    }
}
