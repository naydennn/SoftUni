package garage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {

    private Garage garage;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() {
        this.car1 = new Car("audi", 200, 2000);
        this.car2 = new Car("vw", 220, 2200);
        this.garage = new Garage();
    }

    @Test
    public void testAddCarSuccessToGarage() {
        this.garage.addCar(car1);
        List<Car> cars = this.garage.getCars();
        Car car = cars.get(0);
        assertNotNull(car);

        assertEquals(car.getBrand(), car1.getBrand());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullInGarage() {
        this.garage.addCar(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsAndModify() {
        this.garage.addCar(car1);
        this.garage.addCar(car2);

        List<Car> cars = this.garage.getCars();
        cars.add(car1);
    }
    @Test
    public void testGetCarsCorrectly() {
        this.garage.addCar(car1);
        this.garage.addCar(car2);

        List<Car> cars = this.garage.getCars();

        assertNotNull(cars);

        assertEquals(cars.get(0).getBrand(), car1.getBrand());
    }
    @Test
    public void testGetCountOfCarsCorrectly() {
        this.garage.addCar(car1);
        this.garage.addCar(car2);
        int count = this.garage.getCount();

        assertEquals(2,count);
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAboveCorrectly() {
        this.garage.addCar(car1);
        this.garage.addCar(car2);

        List<Car> allCarsWithMaxSpeedAbove = this.garage.findAllCarsWithMaxSpeedAbove(201);
        Car car = allCarsWithMaxSpeedAbove.get(0);

        assertNotNull(car);
        assertEquals(220,car.getMaxSpeed());
    }
    @Test
    public void testGetTheMostExpensiveCarCorrectly() {
        this.garage.addCar(car1);
        this.garage.addCar(car2);
        Car theMostExpensiveCar = this.garage.getTheMostExpensiveCar();

        assertNotNull(theMostExpensiveCar);
        assertEquals(2200,theMostExpensiveCar.getPrice(),0);
    }
    @Test
    public void testGetTheMostExpensiveCarWithNoCarsInGarage() {
        Car theMostExpensiveCar = this.garage.getTheMostExpensiveCar();
        assertNull(theMostExpensiveCar);
    }
    @Test
    public void testFindAllCarsByBrand() {
        this.garage.addCar(car1);
        this.garage.addCar(car2);

        List<Car> vw = this.garage.findAllCarsByBrand("vw");
        assertNotNull(vw);
        assertEquals(1, vw.size());
    }

}