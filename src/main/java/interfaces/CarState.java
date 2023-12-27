package interfaces;

import customExceptions.IlligalCarStateException;
import model.Car;

public interface CarState {
    public void park(Car car) throws IlligalCarStateException;
    public void leaveParking(Car car) throws IlligalCarStateException;
}
