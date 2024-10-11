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
        System.out.println("What's your car's name?");
        String name = scan.next();
        System.out.println("What type is your car");
        String type = scan.next();
        System.out.println("What color is your car");
        String color = scan.next();
        System.out.println("What year is your car");
        int year = scan.nextInt();
        System.out.println("How far did your car run?");
        int miles = scan.nextInt();
        System.out.println("How much horse power does your car have?");
        int hp = scan.nextInt();
        System.out.println("How much is the car?");
        int price = scan.nextInt();

        Car c = new Car(name, type, color, year, miles, hp, price);
        myCollection.addCar(c);
        ArrayList<Car> cars = myCollection.getCars();
        if (cars.contains(c)) {
            System.out.println(c.getName() + " is added to the collection!");
        }
        buildCollection();
    }

    // -------------------------------------------------------------------------------------

    // EFFECTS: remove one of the cars or one of the garages in the collection
    private void removeCollection() {
        System.out.println("Do you want to remove a car or a garage?");
        System.out.println("c - car (by Id)");
        System.out.println("g - garage (by name)");
        System.out.println("Input other keys to return");
        input = scan.next();

        switch (input) {
            case "c":
                carRemover();
                break;

            case "g":
                garageRemover();
                break;

            default:
                buildCollection();
                break;
        }
    }

    // MODIFIES: myCollection.getCars()
    // EFFECTS: Remove a car in the collection
    private void carRemover() {
        System.out.println("Which car do you want to remove?");
        String id = scan.next();
        ArrayList<Car> cars = myCollection.getCars();
        int carSize = cars.size();

        if (carSize == 0) {
            System.out.println("You have no cars to remove!");
        } else {
            myCollection.removeCar(cars, id);

            System.out.println(id + " is removed!");
            System.out.println("Now your collection has:");

            for (Car c : cars) {
                System.out.println(c.getName() + " which is a " + c.getType());
            }
        }
        buildCollection();
    }

    // MODIFIES: myCollection.getSavedGarages()
    // EFFECTS: Remove a garage in the collection
    private void garageRemover() {
        System.out.println("Which garage do you want to remove?");
        String garage = scan.next();
        ArrayList<Garage> garages = myCollection.getSavedGarages();
        int garageSize = garages.size();

        if (garageSize == 0) {
            System.out.println("You have no garages to remove");
        } else {
            myCollection.removeGarage(myCollection, garage);

            System.out.println(garage + " is removed!");
            System.out.println("Now your garages are:");

            for (Garage g : garages) {
                System.out.println(g.getName());
            }
        }
        buildCollection();
    }

    // -------------------------------------------------------------------------------------

    // EFFECTS: Show a list of all cars in the collection
    public void viewCars() {
        ArrayList<Car> cars = myCollection.getCars();
        if (cars.size() == 0) {
            System.out.println("There is no car in your collection!");
        } else {
            System.out.println("You have:");
            for (Car c : cars) {
                System.out.println(c.getName() + " which is a " + c.getType());
            }
        }
        buildCollection();
    }

    // EFFECTS: Show a list of all garages in the collection
    private void viewGarageList() {
        ArrayList<Garage> garages = myCollection.getSavedGarages();
        if (garages.size() == 0) {
            System.out.println("There is no garage in your collection!");
        } else {
            System.out.println("Your garages are:");
            for (Garage g : garages) {
                System.out.println(g.getName());
            }
        }

        System.out.println("Do you want to view your garage?");
        System.out.println("y -Yes");
        System.out.println("n - No");
        input = scan.next();

        switch (input) {
            case "y":
                garageViewer();
                break;

            case "n":
                System.out.println("Press any key to exit");
                break;
        }
        buildCollection();
    }

    // -------------------------------------------------------------------------------------

    // EFFECTS: Show the list of cars in the selected garage from the saved garages
    private void garageViewer() {
        printDivider();
        System.out.println("Which garage you want to view?");
        String garageName = scan.next();
        garages = myCollection.getSavedGarages();

        showCarsInGarage(garages, garageName);
    }

    // EFFECTS: Method to show cars in the selected garage
    private void showCarsInGarage(ArrayList<Garage> garages, String garageName) {
        Garage garage = garageFinder(garages, garageName);
        if (garage != null) {
            System.out.println("Cars in the garage '" + garageName + "':");
            for (Car car : garage.getCars()) {
                System.out.println(car.getName());
            }
        } else {
            System.out.println("Garage with name '" + garageName + "' not found.");
        }

        System.out.println("Press any key to exit");
    }

    // EFFECTS: Find the garage with the name, if can't find just return null
    private Garage garageFinder(ArrayList<Garage> garages, String name) {
        for (Garage garage : garages) {
            if (garage.getName().equals(name)) {
                return garage;
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------------------

    // EFFECTS: Generate a new garage by adding cars into it
    private void smartGenerator() {
        System.out.println("Which function do you want to use?");
        System.out.println("p - create a new garage based on price boundaries");
        System.out.println("y - create a new garage based on year range");
        System.out.println("Input other keys to return");
        input = scan.next();

        switch (input) {
            case "p":
                priceBoundGarageGenerator();
                break;

            case "y":
                yearBoundGarageGenerator();
                break;
        }
        buildCollection();
    }

    // EFFECTS: After asking for boundaries for price, create a new garage and store
    // it into the collection then call the smartGenerator again
    // MODIFIES: this.collection
    private void priceBoundGarageGenerator() {
        ArrayList<Car> cars = myCollection.getCars();

        System.out.println("Your upper bound is?");
        int upper = scan.nextInt();
        System.out.println("Your lower bound is?");
        int lower = scan.nextInt();

        ArrayList<Car> filteredList = filterByPriceRange(cars, lower, upper);
        String garageName = "$" + lower + "$" + upper;

        Garage g = new Garage(garageName, filteredList);
        myCollection.addGarage(g);

        ArrayList<Garage> savedGarages = myCollection.getSavedGarages();
        if (savedGarages.contains(g)) {
            System.out.println(g.getName() + " is added to the collection!");
        }
    }

    // EFFECTS: After asking for boundaries for years, create a new garage and store
    // it into the collection then call the smartGenerator again
    // MODIFIES: this.collection
    private void yearBoundGarageGenerator() {
        ArrayList<Car> cars = myCollection.getCars();

        System.out.println("Your upper bound is?");
        int upper = scan.nextInt();
        System.out.println("Your lower bound is?");
        int lower = scan.nextInt();

        ArrayList<Car> filteredList = filterByYearRange(cars, lower, upper);
        String garageName = "y" + lower + upper;

        Garage g = new Garage(garageName, filteredList);
        myCollection.addGarage(g);

        ArrayList<Garage> savedGarages = myCollection.getSavedGarages();
        if (savedGarages.contains(g)) {
            System.out.println(g.getName() + " is added to the collection!");
        }
    }

    // -------------------------------------------------------------------------------------

    interface Condition<T> {
        boolean test(T t);
    }

    // EFFECTS: Universal filtering method: can be filtered according to any
    // conditions
    // MODIFIES: result
    public static <T> ArrayList<T> filterByCondition(ArrayList<T> list, Condition<T> condition) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // EFFECTS: Filter a list of cars by given boundaries by price
    // REQUIRES: upper >= lower
    private ArrayList<Car> filterByPriceRange(ArrayList<Car> cars, int lower, int upper) {
        return filterByCondition(cars, new Condition<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getPrice() >= lower && car.getPrice() <= upper;
            }
        });
    }

    // EFFECTS: Filter a list of cars by given boundaries by year
    // REQUIRES: upper >= lower
    private ArrayList<Car> filterByYearRange(ArrayList<Car> cars, int lower, int upper) {
        return filterByCondition(cars, new Condition<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getYear() >= lower && car.getYear() <= upper;
            }
        });
    }

    // EFFECTS: prints out a line of dashes to act as a divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }

}
