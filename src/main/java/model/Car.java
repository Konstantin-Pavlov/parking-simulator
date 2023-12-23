package model;

import java.util.Objects;

public class Car {
    private final String regNumber;

    public Car(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
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
