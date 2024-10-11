package model;

import java.util.ArrayList;

// Represent all cars and garages the user saved
public class Collection {

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
        //stub
    }

    // EFFECTS: Get the saved garages in the collection
    public ArrayList<Garage> getSavedGarages() {
        //stub
    }

    // MODIFIES: this.cars
    // EFFECTS: Add a car to the collection and return a message if the car was
    // added successfully
    public void addCar(Car car) {
        //stub
    }

    // MODIFIES: this.cars
    // EFFECTS: Remove a specific car from the collection by ID
    public void removeCar(ArrayList<Car> cars, String id) {
       //stub
    }

    // MODIFIES: this.garage
    // EFFECTS: Add a garage to the collection and return a message if the car was
    // added successfully
    public void addGarage(Garage garage) {
        //stub
    }

    // MODIFIES: this.collection
    // REQUIRES: the garage removed was in the collection
    // EFFECTS: Remove a specific garage from the collection by using its name，then
    // show the garages left
    public void removeGarage(Collection myCollection, String garage) {
        //stub
    }

}
