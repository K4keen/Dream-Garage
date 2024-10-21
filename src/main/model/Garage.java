package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

//Represent a garage which has a name and a list of cars
public class Garage implements Writable{
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
        return this.garageName;
    }

    // EFFECTS: Get the list of cars in this garage
    public ArrayList<Car> getCars() {
        return this.cars;
    }

    // MODIFIES: this.cars
    // EFFECTS: Add a car into the garage
    public void addCar(Car car) {
        cars.add(car);
    }

    // MODIFIES: this.cars
    // EFFECTS: Remove all the cars in the garage given
    public void removeCars(Garage garage) {
        cars = garage.getCars();
        cars.removeAll(cars);
    }

    //EFFECTS: returns this garage as a JSON object
    @Override
    public JSONObject toJson() {
        //stub
    }

    // EFFECTS: returns the cars in this garage as a JSON array
    public JSONArray carsToJsonArray(){
        //stub
    }
}
