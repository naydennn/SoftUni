package ExtendedDatabase;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database {

    private Person[] people;
    private int index;

    public Database(Person... people) throws OperationNotSupportedException {
        this.people = new Person[16];
        this.index = 0;
        setPerson(people);
    }

    public void setPerson(Person[] people) throws OperationNotSupportedException {
        for (Person person : people) {
            addPerson(people[index]);
            this.index++;
        }
    }

    public void addPerson(Person person) throws OperationNotSupportedException {

        boolean isExist = false;

        try {
            if (person.getId() == null || person.getId() < 0) {
                isExist = Arrays.stream(this.people).anyMatch(p -> p.getId().equals(person.getId()));
                if (isExist) {
                    throw new OperationNotSupportedException();
                }
            }
            this.people[this.index] = person;
        } catch (NullPointerException ignored) {
            throw new OperationNotSupportedException();
        }

    }

    public void remove() throws OperationNotSupportedException {
        if (this.people[index] == null) {
            throw new OperationNotSupportedException();
        }
        this.people[index] = null;
        index--;
    }

    public Person[] getPeople() {
        Person[] bufferPeople = new Person[index + 1];

        int bufferIndex = 0;
        for (Person person : this.people) {
            if (person != null) {
                bufferPeople[bufferIndex] = person;
                bufferIndex++;
            }
        }
        return bufferPeople;
    }
}
