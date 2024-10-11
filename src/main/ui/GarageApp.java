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

    // EFFECTS: Understand user's input and run different helpers
    private void runGarage() {

        printDivider();
        System.out.println("Welcome to your Dream Garage!");
        System.out.println("Please enter your command");

        buildCollection();
    }

    // EFFECTS: Organize the commands for building a new garage
    private void buildCollection() {
        printDivider();
        builderMenu();
        printDivider();
        builderCommand();
    }

    // EFFECTS: Display the menu for building a new garage
    private void builderMenu() {
        System.out.println("Please enter your command:");
        System.out.println("a - add a car to your car collection");
        System.out.println("r - remove cars or garages");
        System.out.println("vc - view your car collection");
        System.out.println("vg - view your garages");
        System.out.println("g - smart generator");
        System.out.println("q - quit the menu");
    }

    // EFFECTS: React to different commands of building garage
    private void builderCommand() {
        input = scan.next();
        switch (input) {
            case "a":
                addCollection();
                break;
            case "r":
                removeCollection();
                break;
            case "vc":
                viewCars();
                break;
            case "vg":
                viewGarageList();
                break;
            case "g":
                smartGenerator();
                break;
            case "q":
                running = false;
                break;
        }
    }

    // -------------------------------------------------------------------------------------

    // EFFECTS: Add a car to the collection
    private void addCollection() {
        // TODO
    }

    // -------------------------------------------------------------------------------------

    // EFFECTS: remove one of the cars or one of the garages in the collection
    private void removeCollection() {
        // TODO
    }

    // -------------------------------------------------------------------------------------
    // EFFECTS: Show a list of all cars in the collection
    public void viewCars() {
        // TODO
    }

    // EFFECTS: Show a list of all garages in the collection
    private void viewGarageList() {
        // TODO
    }

    // EFFECTS: Generate a new garage by adding cars into it
    private void smartGenerator() {
        //TODO
    }
    // -------------------------------------------------------------------------------------

    // EFFECTS: prints out a line of dashes to act as a divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }
}