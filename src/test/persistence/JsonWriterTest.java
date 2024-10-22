package persistence;

import model.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Collection collection = new Collection();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLibrary() {
        try {
            Collection collection = new Collection();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCollection.json");
            writer.open();
            writer.write(collection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCollection.json");
            collection = reader.read();
            assertEquals(0, collection.getCars().size());
            assertEquals(0, collection.getSavedGarages().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralLibrary() {
        try {
            Collection collection = new Collection();
            List<Car> cars = collection.getCars();
            List<Garage> garages = collection.getSavedGarages();

            ArrayList<Car> testCars1 = new ArrayList<>();
            ArrayList<Car> testCars2 = new ArrayList<>();
            Car testCar1 = new Car("Porsche GT3 RS", "racing car", "white and red", 2024, 2500, 518, 328888);
            Car testCar2 = new Car("Ferrari SF90", "hyper car", "red", 2020, 40000, 986, 698888);
            Car testCar3 = new Car("McLaren P1", "hyper car", "yellow", 2014, 100, 916, 1350000);
            testCars1.add(testCar1);
            testCars1.add(testCar3);
            testCars2.add(testCar2);

            Garage testGarage1 = new Garage("G1", testCars1);
            Garage testGarage2 = new Garage("G2", testCars2);
            collection.addCar(testCar1);
            collection.addCar(testCar2);
            collection.addCar(testCar3);
            collection.addGarage(testGarage1);
            collection.addGarage(testGarage2);

            JsonWriter writer = new JsonWriter("./data/testWriterCollection.json");
            writer.open();
            writer.write(collection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterCollection.json");
            collection = reader.read();

            assertEquals(3, cars.size());
            checkCar("Porsche GT3 RS", "racing car", "white and red", 2024, 2500, 518, 328888, "Prw2500",cars.get(0));
            checkCar("Ferrari SF90", "hyper car", "red", 2020, 40000, 986, 698888, "Fhr40000", cars.get(1));
            checkCar("McLaren P1", "hyper car", "yellow", 2014, 100, 916, 1350000, "Mhy100", cars.get(2));

            assertEquals(3, garages.size());
            checkGarage("G1", testCars1, garages.get(1));
            checkGarage("G2", testCars2, garages.get(2));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
