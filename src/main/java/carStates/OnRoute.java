package carStates;

import customExceptions.IlligalCarStateException;
import interfaces.CarState;
import model.Car;
import util.ConsoleColors;

public class OnRoute implements CarState {
    @Override
    public void park(Car car) {
        System.out.println(ConsoleColors.ANSI_GREEN_BACKGROUND + "the car " + car.getRegNumber() + " was parked successfully, car state was changed to parked" + ConsoleColors.RESET);
        car.setState(new OnPark());
    }

    @Override
    public void leaveParking(Car car) throws IlligalCarStateException {
        throw new IlligalCarStateException(ConsoleColors.RED_BACKGROUND +
                "it is impossible to leave the parking lot because the car is on the way and is not in the parking lot" +
                ConsoleColors.RESET);
    }
}
