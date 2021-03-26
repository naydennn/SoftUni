import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    public static final Integer[] TEST_VALUES = {1, 2, 3};
    private Database data;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.data = new Database(TEST_VALUES);
    }

    @Test
    public void testIndexIsCorrectlySet() {
        assertEquals(3, data.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetDatabaseWithIncorrectValues() throws OperationNotSupportedException {
        this.data = new Database();
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testCannotAddNullElement() throws OperationNotSupportedException {
        data.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfStoreMoreThan16ElementInDatabase() throws OperationNotSupportedException {
        Integer[] incorrectArr = new Integer[17];
        this.data = new Database(incorrectArr);
    }

    @Test
    public void testAddElementToLastIndexInDatabase() throws OperationNotSupportedException {
        int element = 4;
        this.data.add(element);

        assertEquals(element, data.getElement(3));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            this.data.remove();
        }
    }

    @Test
    public void testRemoveElementFormDatabaseCorrectly() throws OperationNotSupportedException {
        this.data.remove();
        assertEquals(2, data.getIndex());
    }
}