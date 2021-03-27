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
    //remove

    @Test
    public void testRemovePersonFromDatabaseCorrectly() throws OperationNotSupportedException {
        this.database.remove();

        Person[] people = this.database.getPeople();
        Person actualPerson = people[people.length - 1];

        assertEquals(actualPerson.getName(), "Peter");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < 3; i++) {
            this.database.remove();
        }
    }
    //constructor

    @Test(expected = OperationNotSupportedException.class)
    public void addMorePeopleThanCapacity() throws OperationNotSupportedException {
        Person[] arr = new Person[17];
        new Database(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNull() throws OperationNotSupportedException {
        this.database.addPerson(null);
    }

    //find by ID

    @Test(expected = OperationNotSupportedException.class)
    public void testSearchWithInvalidId() throws OperationNotSupportedException {
        this.database.findById(17L);
    }

    @Test
    public void testFindPeopleById() throws OperationNotSupportedException {
        Person personById = this.database.findById(19L);

        assertEquals("Peter",personById.getName());
    }

    // find person by name

    @Test
    public void testFindPeopleByRealName() throws OperationNotSupportedException {
        Person peter = this.database.findByName("Peter");

        Long expectedId = 19L;
        assertEquals(expectedId , peter.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfPersonNameIsEmpty() throws OperationNotSupportedException {
        this.database.findByName(" ");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfPersonNameIsNull() throws OperationNotSupportedException {
        this.database.findByName(null);
    }
}