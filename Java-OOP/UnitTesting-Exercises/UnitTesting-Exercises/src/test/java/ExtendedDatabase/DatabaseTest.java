package ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    public static final Person[] TEST_PERSON_INFORMATION = {new Person("Peter", 19L),
            new Person("Ivan", 20L)};

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(TEST_PERSON_INFORMATION);
    }

    //add
    @Test
    public void testAddPersonCorrectly() throws OperationNotSupportedException {
        Person rosen = new Person("Rosen", 1L);

        this.database.addPerson(rosen);
        Person[] people = this.database.getPeople();
        Person actualPerson = people[people.length - 1];

        assertEquals(rosen.getId(), actualPerson.getId());
        assertEquals(rosen.getName(), actualPerson.getName());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddEmptyPerson() throws OperationNotSupportedException {
        this.database.addPerson(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithNegativeId() throws OperationNotSupportedException {
        this.database.addPerson(new Person("NegativeValues" , -1L));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPeopleWithExistingId() throws OperationNotSupportedException {
        this.database.addPerson(new Person("PersonWithExistId" , 19L));
    }
}