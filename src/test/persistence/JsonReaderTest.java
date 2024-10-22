package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    //EFFECTS: Test the reader when there is no existent file
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

    //EFFECTS: Test the reader when there is an empty collection
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
            assertEquals(5, cars.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}