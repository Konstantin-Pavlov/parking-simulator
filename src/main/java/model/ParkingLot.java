package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    final static private int CAPACITY = 20;
    final static private List<Car> parkedCars = new ArrayList<>(CAPACITY);

    private ParkingLot() {
    }

    public void add(Car car) {
        if (parkedCars.size() == CAPACITY) {
            System.out.printf("Not possible to park the %s, parking lot is full%n", car);
            return;
        }
        parkedCars.add(car);
    }

    public List<Car> getParkedCars(){
        return parkedCars;
    }
}
