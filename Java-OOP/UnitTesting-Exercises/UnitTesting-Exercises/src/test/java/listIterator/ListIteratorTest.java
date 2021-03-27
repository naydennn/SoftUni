package listIterator;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertTrue;

public class ListIteratorTest {

    public static final String[] TEST_VALUES = {"1", "2", "3"};

    private ListIterator data;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.data = new ListIterator(TEST_VALUES);
    }

    //create ListIterator

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateListIteratorByEmptyCells() throws OperationNotSupportedException {
        this.data = new ListIterator();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateListIteratorByNull() throws OperationNotSupportedException {
        this.data = new ListIterator(null);
    }

    //move
    @Test
    public void testDataMoveCorrectly() throws OperationNotSupportedException {
        boolean move = false;

        for (int i = 0; i < 3; i++) {
            move = this.data.move();
        }

        assertTrue(move);

    }

}