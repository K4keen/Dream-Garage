package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Represent all cars and garages the user saved
public class Collection implements Writable {

    private ArrayList<Car> cars;
    private ArrayList<Garage> savedGarages;

    // MODIFIES: this
    // EFFECTS: Construct a new collection with an empty list of cars
    // and an empty list of saved car list
    public Collection() {
        cars = new ArrayList<Car>();
        savedGarages = new ArrayList<Garage>();
    }

    // EFFECTS: Get the cars in the collection
    public ArrayList<Car> getCars() {
        return cars;
    }

    // EFFECTS: Get the saved garages in the collection
    public ArrayList<Garage> getSavedGarages() {
        return savedGarages;
    }

    // MODIFIES: this.cars
    // EFFECTS: Add a car to the collection and return a message if the car was
    // added successfully
    public void addCar(Car car) {
        cars.add(car);
    }

    // MODIFIES: this.cars
    // EFFECTS: Remove a specific car from the collection by ID
    public void removeCar(ArrayList<Car> cars, String id) {
        int size = cars.size();

        for (int i = size - 1; i >= 0; i--) {
            Car item = cars.get(i);
            if (id.equals(item.getId())) {
                cars.remove(item);
            }
        }

    }

    // MODIFIES: this.garage
    // EFFECTS: Add a garage to the collection and return a message if the car was
    // added successfully
    public void addGarage(Garage garage) {
        savedGarages.add(garage);
    }

    // MODIFIES: this.collection
    // REQUIRES: the garage removed was in the collection
    // EFFECTS: Remove a specific garage from the collection by using its name，then
    // show the garages left
    public void removeGarage(Collection myCollection, String garage) {

        ArrayList<Garage> garages = myCollection.getSavedGarages();
        int size = garages.size();

        for (int i = size - 1; i >= 0; i--) {
            Garage item = garages.get(i);
            if (garage.equals(item.getName())) {
                garages.remove(item);
            }
        }

    }

    // EFFECTS: Return this collection as a Json objective
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("cars", carsToJson());
        json.put("garages", garagesToJson());
        return json;
    }

    // EFFECTS: returns cars in this collection as a JSON array
    public JSONArray carsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Car c : cars) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns garages in this collection as a JSON array
    public JSONArray garagesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Garage g : savedGarages) {
            jsonArray.put(g.toJson());
        }

        return jsonArray;
    }

}
