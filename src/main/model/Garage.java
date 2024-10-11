package model;

import java.util.ArrayList;

//Represent a garage which has a name and a list of cars
public class Garage {
    private String garageName;
    private ArrayList<Car> cars;

    // MODIFIES: this
    // EFFECTS: Construct a new garage with an empty list of cars
    // and a garage name
    public Garage(String garageName, ArrayList<Car> cars) {
        this.garageName = garageName;
        this.cars = cars;
    }

    // EFFECTS: Get the name of the garage
    public String getName() {
        return "null";
    }

    // EFFECTS: Get the list of cars in this garage
    public ArrayList<Car> getCars() {
        //stub
    }

    // MODIFIES: this.cars
    // EFFECTS: Add a car into the garage
    public void addCar(Car car) {
        //stub
    }

    // MODIFIES: this.cars
    // EFFECTS: Remove all the cars in the garage given
    public void removeCars(Garage garage) {
        //stub
    }

}
