package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {
    private Collection testCollection;
    private Car testCar1;
    private Car testCar2;
    private ArrayList<Car> testCarList1;
    private ArrayList<Car> testCarList2;
    private Garage testGarage1;
    private Garage testGarage2;

    @BeforeEach
    void runBefore() {
        testCollection = new Collection();
        testCar1 = new Car("Toyota", "SUV", "Red", 2020, 5000, 300, 30000);
        testCar2 = new Car("Honda", "Sedan", "Blue", 2019, 15000, 250, 20000);
        testGarage1 = new Garage("testGarage1", testCarList1);
        testGarage2 = new Garage("testGarage2", testCarList2);

    }

    @Test
    void testAddCar() {
        testCollection.addCar(testCar1);
        assertTrue(testCollection.getCars().contains(testCar1));
        assertEquals(1, testCollection.getCars().size());
    }

    @Test
    void testRemoveCar() {
        testCollection.addCar(testCar1);
        testCollection.addCar(testCar2);

        testCollection.removeCar(testCollection.getCars(), testCar1.getId());
        assertFalse(testCollection.getCars().contains(testCar1));
        assertEquals(1, testCollection.getCars().size());

        testCollection.removeCar(testCollection.getCars(), "Null");
        assertEquals(1, testCollection.getCars().size());

        testCollection.removeCar(testCollection.getCars(), testCar2.getId());
        assertTrue(testCollection.getCars().isEmpty());
    }

    @Test
    void testAddGarage() {
        testCollection.addGarage(testGarage1);
        assertTrue(testCollection.getSavedGarages().contains(testGarage1));
        assertEquals(1, testCollection.getSavedGarages().size());
    }

    @Test
    void testRemoveGarage() {
        testCollection.addGarage(testGarage1);
        testCollection.addGarage(testGarage2);

        testCollection.removeGarage(testCollection, testGarage1.getName());
        assertFalse(testCollection.getSavedGarages().contains(testGarage1));
        assertEquals(1, testCollection.getSavedGarages().size());

        testCollection.removeGarage(testCollection, "Null");
        assertEquals(1, testCollection.getSavedGarages().size());

        testCollection.removeGarage(testCollection, testGarage2.getName());
        assertTrue(testCollection.getSavedGarages().isEmpty());
    }

}