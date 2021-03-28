package listIterator;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

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

    @Test(expected = OperationNotSupportedException.class)
    public void testMoveOutOfCollection() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            this.data.move();
        }
    }

    //has next element

    @Test
    public void testHasNextElementInCollection() throws OperationNotSupportedException {
        this.data.move();
        boolean hasNext = this.data.hasNext();

        assertTrue(hasNext);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAlreadyIsAtLastIndex() throws OperationNotSupportedException {
        for (int i = 0; i < 3; i++) {
            this.data.move();
        }
        boolean hasNext = this.data.hasNext();

        assertFalse(hasNext);
    }

    // print element from collection

    @Test
    public void testPrintElementFromCollectionCorrectly() {
        String print = this.data.print();
        String expected = "1";

        assertEquals("Invalid operation!", expected, print);
    }

    @Test
    public void testInvalidPrint() throws OperationNotSupportedException {
        for (int i = 0; i < 3; i++) {
            this.data.move();
        }

        String print = this.data.print();
        String expectedOutput = "Invalid operation!";
        assertEquals(expectedOutput, print);
    }
}