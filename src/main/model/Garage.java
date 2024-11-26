package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

//Represent a garage which has a name and a list of cars
public class Garage implements Writable {
    private String garageName;
    private ArrayList<Car> cars;

    // MODIFIES: this
    // EFFECTS: Construct a new garage with an empty list of cars
    // and a garage name
    public Garage(String garageName) {
        this.garageName = garageName;
        cars = new ArrayList<Car>();
    }

    // MODIFIES: this
    // EFFECTS: Construct a new garage with a list of cars
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
        EventLog.getInstance()
                .logEvent(new Event(car.getName() + " was added to garage " + getName() + "."));
    }

    // MODIFIES: this.cars
    // EFFECTS: Remove all the cars in the garage given
    public void removeCars(Garage garage) {
        cars = garage.getCars();
        cars.removeAll(cars);
        EventLog.getInstance()
                .logEvent(new Event(" All cars in "+ garage.getName() + " were removed "));
    }

    // EFFECTS: returns this garage as a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", garageName);
        json.put("cars", carsToJsonArray());
        return json;
    }

    // EFFECTS: returns the cars in this garage as a JSON array
    public JSONArray carsToJsonArray() {
        JSONArray jsonArray = new JSONArray();

        for (Car c : cars) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}
