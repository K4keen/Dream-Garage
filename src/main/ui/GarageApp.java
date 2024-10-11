package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Car;
import model.Collection;
import model.Garage;

//UI for Dream Garage Application

public class GarageApp {

    private boolean running;
    private String input;
    private Scanner scan = new Scanner(System.in);

    private Collection myCollection = new Collection();
    private ArrayList<Garage> garages = new ArrayList<Garage>();

    // MODIFIES: this
    // EFFECTS: initializes the application with the starting values
    public void init() {
        this.myCollection = new Collection();

        this.scan = new Scanner(System.in);
        this.running = true;
    }

    // EFFECTS: Run the Dream Garage Application
    public GarageApp() {
        init();

        while (running) {
            runGarage();
        }
    }
}