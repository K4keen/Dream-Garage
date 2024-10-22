package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    // EFFECTS: Test the reader when there is no existent file
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Collection collection = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // EFFECTS: Test the reader when there is an empty collection
    @Test
    void testReaderEmptyCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCollection.json");
        try {
            Collection collection = reader.read();
            assertEquals(0, collection.getCars().size());
            assertEquals(0, collection.getSavedGarages().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralLibrary() {
        JsonReader reader = new JsonReader("./data/testReaderCollection.json");
        try {
            Collection collection = reader.read();
            List<Car> cars = collection.getCars();
            List<Garage> garages = collection.getSavedGarages();
            ArrayList<Car> testGarage1 = new ArrayList<>();

            assertEquals(4, cars.size());
            checkCar("Porsche GT3 RS", "racing car", "white and red", 2024, 2500, 518, 328888, "Prw2500", cars.get(0));
            checkCar("Ferrari SF90", "hyper car", "red", 2020, 40000, 986, 698888, "Fhr40000", cars.get(1));
            checkCar("McLaren P1", "hyper car", "yellow", 2014, 100, 916, 1350000, "Mhy100", cars.get(2));
            checkCar("Maybach S680", "sedan", "black", 2023, 5000, 621, 349597, "Msb5000", cars.get(3));

            testGarage1.add(cars.get(0));
            testGarage1.add(cars.get(3));
            assertEquals(2, garages.size());

            checkGarage("racer's favorite", testGarage1, garages.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}