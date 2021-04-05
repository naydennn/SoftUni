package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {

    private Spaceship spaceship;
    private Astronaut astronaut1;
    private Astronaut astronaut2;

    @Before
    public void setUp() {
        spaceship = new Spaceship("space", 2);
        astronaut1 = new Astronaut("test_1", 0.9);
        astronaut2 = new Astronaut("test_2", 1.0);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithEmptyName() {
        Spaceship spaceship = new Spaceship("  ", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithNull() {
        Spaceship spaceship = new Spaceship(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithNegativeValue() {
        Spaceship spaceship = new Spaceship("SpaceEX", -10);
    }

    @Test
    public void testSetCapacityWithCorrectValue() {
        Spaceship spaceship = new Spaceship("SpaceEX", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWithExistName() {
        astronaut2 = new Astronaut("test_1", 10);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsLessThanNumberOfAstronaut() {
        Astronaut astronaut3 = new Astronaut("test_3", 1.2);
        Astronaut astronaut4 = new Astronaut("test_4", 1.3);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        spaceship.add(astronaut4);
    }

    @Test
    public void setRemoveAstronautCorrectly() {
        spaceship.add(astronaut1);
        boolean remove = spaceship.remove("test_1");
        assertTrue(remove);
    }

    @Test
    public void setRemoveAstronautWithNotExistAstronaut() {
        boolean remove = spaceship.remove("test_1");
        assertFalse(remove);
    }

    @Test
    public void testGetCapacityCorrectly() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        int capacity = spaceship.getCapacity();

        assertEquals(2, capacity);
    }
}
