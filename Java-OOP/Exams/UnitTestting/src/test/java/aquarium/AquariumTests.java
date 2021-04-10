package aquarium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {

    private Aquarium aquarium;
    private Fish fish1;
    private Fish fish2;

    @Before
    public void setUp() {
        aquarium = new Aquarium("test", 3);
        fish1 = new Fish("test_1");
        fish2 = new Fish("test_2");
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyName() {
        Aquarium emptyName = new Aquarium(" ", 10);
    }
    @Test(expected = NullPointerException.class)
    public void testSetName() {
        Aquarium emptyName = new Aquarium(null, 10);
    }
    @Test
    public void testSetNameCorrectly() {
        String name = this.aquarium.getName();
        assertNotNull(name);

        assertEquals("test", name);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity() {
        Aquarium emptyName = new Aquarium("test", -1);
    }
    @Test
    public void testSetCapacityCorrectly() {
        int capacity = this.aquarium.getCapacity();

        assertEquals(3, capacity);

    }
    @Test
    public void testGetCountCorrectly(){
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);

        int count = this.aquarium.getCount();

        assertEquals(2,count);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddFish() {
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);
        this.aquarium.add(fish2);
        this.aquarium.add(fish2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFishWithNullName() {
        this.aquarium.remove("Naiden");
    }
    @Test
    public void testRemoveFishCorrectly() {
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);
        this.aquarium.remove("test_1");
        int count = this.aquarium.getCount();

        assertEquals(1, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSellNotExistingFish() {
        this.aquarium.sellFish("non-existing");
    }
    @Test
    public void testSellFishCorrectly(){
        this.aquarium.add(fish1);
        this.aquarium.add(fish2);

        Fish test_1 = this.aquarium.sellFish("test_1");
        assertNotNull(test_1);

        assertFalse(test_1.isAvailable());
    }
    @Test
    public void testReport() {
        this.aquarium.add(fish1);
        String report = this.aquarium.report();

        assertEquals(String.format("Fish available at %s: %s",this.aquarium.getName(), this.fish1.getName()), report);
    }

}

