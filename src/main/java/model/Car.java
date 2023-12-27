package model;

import carStates.OnRoute;
import customExceptions.IlligalCarStateException;
import interfaces.CarState;

import java.util.Objects;

public class Car {
    private final String regNumber;

    private CarState state;
    private String stateMessage;

    public Car(String regNumber) {
        this.regNumber = regNumber;
        this.setState(new OnRoute());
    }

    public void park() {
        try {
            this.state.park(this);
        } catch (IlligalCarStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void leave() {
        try {
            this.state.leaveParking(this);
        } catch (IlligalCarStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
        switch (this.state.getClass().getSimpleName()) {
            case "OnRoute":
                setStateMessage("driving");
                break;
            case "OnPark":
                setStateMessage("parked");
                break;
            default:
                System.err.println("unknown state");
        }
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car otherCar = (Car) obj;
        return regNumber.equals(otherCar.regNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                '}';
    }
}
