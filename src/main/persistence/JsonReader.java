package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads collection from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads collection from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Collection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCollection(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses collection from JSON object and returns it
    private Collection parseCollection(JSONObject jsonObject) {
        Collection collection = new Collection();
        addCars(collection, jsonObject);
        addGarages(collection, jsonObject);
        return collection;
    }

    // MODIFIES: collection
    // EFFECTS: parses car from JSON object and adds it to collection
    private void addCar(Collection collection, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        String color = jsonObject.getString("color");
        String year = jsonObject.getString("year");
        String miles = jsonObject.getString("miles");
        String hp = jsonObject.getString("hp");
        String price = jsonObject.getString("price");
        Car car = new Car(name, type,color,Integer.parseInt(year),Integer.parseInt(miles),Integer.parseInt(hp),Integer.parseInt(price));
        collection.addCar(car);
    }

    // MODIFIES: collection
    // EFFECTS: parses cars from JSON object and adds it to collection
    private void addCars(Collection collection, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cars");
        for (Object json : jsonArray) {
            JSONObject nextCar = (JSONObject) json;
            addCar(collection, nextCar);
        }
    }

    // MODIFIES: collection
    // EFFECTS: parses garage from JSON object and adds it to collection
    private void addGarage(Collection collection, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Garage g = new Garage(name);
        addCarsGarage(g, jsonObject);
        collection.addGarage(g);
    }

    // MODIFIES: collection
    // EFFECTS: parses garage from JSON object and adds them to collection
    private void addGarages(Collection collection, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("garages");
        for (Object json : jsonArray) {
            JSONObject nextGarage = (JSONObject) json;
            addGarage(collection, nextGarage);
        }
    }

    // MODIFIES: garage
    // EFFECTS: parses car from JSON object and adds it to garage
    private void addCarGarage(Garage g, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String type = jsonObject.getString("type");
        String color = jsonObject.getString("color");
        String year = jsonObject.getString("year");
        String miles = jsonObject.getString("miles");
        String hp = jsonObject.getString("hp");
        String price = jsonObject.getString("price");
        Car car = new Car(name, type,color,Integer.parseInt(year),Integer.parseInt(miles),Integer.parseInt(hp),Integer.parseInt(price));
        g.addCar(car);
    }

    // MODIFIES: garage
    // EFFECTS: parses cars from JSON object and adds them to garage
    private void addCarsGarage(Garage g, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cars");
        for (Object json : jsonArray) {
            JSONObject nextCar = (JSONObject) json;
            addCarGarage(g, nextCar);
        }
    }

}
