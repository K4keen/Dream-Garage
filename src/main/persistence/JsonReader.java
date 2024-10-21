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
        // stub
    }

    // EFFECTS: reads collection from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Collection read() throws IOException {
        // stub
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        // stub
    }

    // EFFECTS: parses collection from JSON object and returns it
    private Collection parseCollection(JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: collection
    // EFFECTS: parses car from JSON object and adds it to collection
    private void addCar(Collection collection, JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: collection
    // EFFECTS: parses cars from JSON object and adds it to collection
    private void addCars(Collection collection, JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: collection
    // EFFECTS: parses garage from JSON object and adds it to collection
    private void addGarage(Collection collection, JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: collection
    // EFFECTS: parses garage from JSON object and adds them to collection
    private void addGarages(Collection collection, JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: garage
    // EFFECTS: parses car from JSON object and adds it to garage
    private void addCarGarage(Garage g, JSONObject jsonObject) {
        // stub
    }

    // MODIFIES: garage
    // EFFECTS: parses cars from JSON object and adds them to garage
    private void addCarsGarage(Garage g, JSONObject jsonObject) {
        // stub
    }

}
