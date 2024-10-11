package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car testCar;

    @BeforeEach
    void runBefore() {
        testCar = new Car("Toyota", "SUV", "Red", 2020, 5000, 300, 30000);
    }

    @Test
    void testIdCreator() {
        String expectedId = "TSR5000";
        assertEquals(expectedId, testCar.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Toyota", testCar.getName());
    }

    @Test
    void testGetType() {
        assertEquals("SUV", testCar.getType());
    }

    @Test
    void testGetColor() {
        assertEquals("Red", testCar.getColor());
    }

    @Test
    void testGetYear() {
        assertEquals(2020, testCar.getYear());
    }

    @Test
    void testGetMiles() {
        assertEquals(5000, testCar.getMiles());
    }

    @Test
    void testGetHp() {
        assertEquals(300, testCar.getHp());
    }

    @Test
    void testGetPrice() {
        assertEquals(30000, testCar.getPrice());
    }

    @Test
    void testGetId() {
        String expectedId = testCar.idCreator();
        assertEquals(expectedId, testCar.getId());
    }
    
}
