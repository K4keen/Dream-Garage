package model;

import org.json.JSONObject;

import persistence.Writable;

// Represents a car having its name, type, color, hp , the year it was made and the milage it has run.
public class Car implements Writable{
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
        char fn = name.charAt(0);
        String firstName = Character.toString(fn);

        char ft = type.charAt(0);
        String firstType = Character.toString(ft);

        char fc = color.charAt(0);
        String firstColor = Character.toString(fc);

        String accMiles = Integer.toString(miles);

        return firstName + firstType + firstColor + accMiles;
    }

    // EFFECTS: get the name of this car
    public String getName() {
        return name;
    }

    // EFFECTS: get the type of this car
    public String getType() {
        return type;
    }

    // EFFECTS: get the color of this car
    public String getColor() {
        return color;
    }

    // EFFECTS: get the year of this car
    public int getYear() {
        return year;
    }

    // EFFECTS: get the miles of this car
    public int getMiles() {
        return miles;
    }

    // EFFECTS: get the horse power of this car
    public int getHp() {
        return hp;
    }

    // EFFECTS: get the price of this car
    public int getPrice() {
        return price;
    }

    // EFFECTS: get the id of this car
    public String getId() {
        return id;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type", type);
        json.put("color", color);
        json.put("year", Integer.toString(year));
        json.put("miles", Integer.toString(miles));
        json.put("hp", Integer.toString(hp));
        json.put("price", Integer.toString(price));
        json.put("id", id);
        return json;
    }
}
