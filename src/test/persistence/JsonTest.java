package persistence;

import model.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkCar(String name, String type, String color, int year, int miles, int hp, int price, String id,
            Car car) {
        assertEquals(name, car.getName());
        assertEquals(type, car.getType());
        assertEquals(color, car.getColor());
        assertEquals(year, car.getYear());
        assertEquals(miles, car.getMiles());
        assertEquals(hp, car.getHp());
        assertEquals(price, car.getPrice());
        assertEquals(id, car.getId());
    }

    protected void checkGarage(String garageName, ArrayList<Car> cars, Garage garage) {
        assertEquals(garageName, garage.getName());
        int index = 0;
        for (Car car : cars) {
            checkCar(car.getName(), car.getType(), car.getColor(), car.getYear(), car.getMiles(), car.getHp(),
                    car.getPrice(), car.getId(),
                    garage.getCars().get(index));
            index++;
        }

    }
}
