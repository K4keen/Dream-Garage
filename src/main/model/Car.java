package model;

// Represents a car having its name, type, color, hp , the year it was made and the milage it has run.
public class Car {
    private String id;
    private String name;
    private String type;
    private String color;
    private int year;
    private int miles;
    private int hp;
    private int price;

    // MODIFIES: this
    // EFFECTS: creates a car having its name, type, color, hp ,
    // the year it was made and the milage it has run. It will automatically
    // generate an ID
    public Car(String name, String type, String color, int year, int miles, int hp, int price) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.year = year;
        this.miles = miles;
        this.hp = hp;
        this.price = price;
        this.id = idCreator();
    }

    // MODIFIES: this.id
    // REQUIRES: Name, type and color has more than 1 character, Milage has more
    // than 1 digit
    // EFFECTS: generate an ID for each car
    public String idCreator() {
        return "null";
    }

    // EFFECTS: get the name of this car
    public String getName() {
        return "null";
    }

    // EFFECTS: get the type of this car
    public String getType() {
        return "null";
    }

    // EFFECTS: get the color of this car
    public String getColor() {
        return "null";
    }

    // EFFECTS: get the year of this car
    public int getYear() {
        return 0;
    }

    // EFFECTS: get the miles of this car
    public int getMiles() {
        return 0;
    }

    // EFFECTS: get the horse power of this car
    public int getHp() {
        return 0;
    }

    // EFFECTS: get the price of this car
    public int getPrice() {
        return 0;
    }

    // EFFECTS: get the id of this car
    public String getId() {
        return "null";
    }

}
