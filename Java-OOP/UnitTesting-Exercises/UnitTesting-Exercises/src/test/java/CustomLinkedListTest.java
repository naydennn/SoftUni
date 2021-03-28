import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    public static final int[] TEST_VALUES = {1, 2, 3, 4};
    public static final Integer TEST_VALUE = 1;

    private CustomLinkedList<Integer> list;

    @Before
    public void setUo() {
        list = new CustomLinkedList<>();
        for (int value : TEST_VALUES) {
            list.add(value);
        }
    }
    //get

    @Test
    public void testGetElementFromListAtIndex() {
        Integer actual = this.list.get(0);

        assertEquals(TEST_VALUE, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getElementWithNegativeIndex() {
        this.list.get(-1);
    }

    //set

    @Test
    public void testSetValueAtGivenIndex() {
        this.list.set(1, TEST_VALUE);

        Integer actual = this.list.get(1);

        assertEquals(TEST_VALUE, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValueWithInvalidIndex() {
        this.list.set(-2, TEST_VALUE);
    }
    //add

    @Test
    public void addElementAtListCorrectly() {
        this.list.add(TEST_VALUE);

        Integer actualValue = this.list.get(4);

        assertEquals(TEST_VALUE, actualValue);
    }

    //removeAt

    @Test
    public void testRemoveElementAtGivenIndex() {
        Integer actualValue = this.list.removeAt(0);

        assertEquals(TEST_VALUE, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIndexWithInvalidIndex() {
        this.list.removeAt(10);
    }

    //remove

    @Test
    public void testRemoveElement() {
        int remove = this.list.remove(2);

        assertEquals((int) TEST_VALUE, remove);
    }

    @Test
    public void testRemoveNonExistingElement() {
        int actualValue = this.list.remove(10);

        assertEquals(-1, actualValue);
    }

    //index of

    @Test
    public void testReturnCorrectValueForIndex() {
        int actualValue = this.list.indexOf(2);

        assertEquals((int) TEST_VALUE, actualValue);
    }

    @Test
    public void testReturnIndexForNonExistingElement() {
        int actualValue = this.list.indexOf(10);

        assertEquals(-1, actualValue);
    }

    //contains

    @Test
    public void testContainsExistingElementInList() {
        boolean contains = this.list.contains(2);

        assertTrue(contains);
    }

    @Test
    public void testContainsNonExistingElementInList() {
        boolean contains = this.list.contains(10);

        assertFalse(contains);
    }
}