package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    private Garage testGarage;
    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void runBefore() {
        testCar1 = new Car("Toyota", "SUV", "Red", 2020, 5000, 300, 30000);
        testCar2 = new Car("Honda", "Sedan", "Blue", 2019, 15000, 250, 20000);
        ArrayList<Car> testCarList = new ArrayList<>();
        testGarage = new Garage("testGarage", testCarList);
    }

    @Test
    void testGetName() {
        assertEquals("testGarage", testGarage.getName());
    }

    @Test
    void testGetCarsInitiallyEmpty() {
        assertTrue(testGarage.getCars().isEmpty());
    }

    @Test
    void testAddCar() {
        testGarage.addCar(testCar1);
        assertTrue(testGarage.getCars().contains(testCar1));
        assertEquals(1, testGarage.getCars().size());

        testGarage.addCar(testCar2);
        assertTrue(testGarage.getCars().contains(testCar2));
        assertEquals(2, testGarage.getCars().size());
    }

    @Test
    void testRemoveCars() {
        testGarage.addCar(testCar1);
        testGarage.addCar(testCar2);
        assertEquals(2, testGarage.getCars().size());

        testGarage.removeCars(testGarage);
        assertTrue(testGarage.getCars().isEmpty());
    }
}
