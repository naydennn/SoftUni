package ExtendedDatabase;

import javax.naming.OperationNotSupportedException;

public class Database {

    private Person[] people;
    private int index;

    public Database(Person... people) throws OperationNotSupportedException {
        this.index = 0;
        setPerson(people);
    }

    public void setPerson(Person[] people) throws OperationNotSupportedException {
        if (people.length > 16 || people.length < 1) {
            throw new OperationNotSupportedException();
        }
        this.people = new Person[16];
        for (Person person : people) {
            addPerson(people[index]);
        }
    }

    public void addPerson(Person person) throws OperationNotSupportedException {

        boolean isExist = false;

        try {
            if (person.getId() == null || person.getId() < 0 || person.getName() == null) {
                throw new OperationNotSupportedException();
            }
            for (Person p : this.people) {
                if (p != null) {
                    isExist = p.getId().equals(person.getId());
                    break;
                }
            }
            if (isExist) {
                throw new OperationNotSupportedException();
            }
            this.people[this.index] = person;
            this.index++;
        } catch (NullPointerException ignored) {
            throw new OperationNotSupportedException();
        }

    }

    public void remove() throws OperationNotSupportedException {
        try {
            this.people[index - 1] = null;
            index--;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            throw new OperationNotSupportedException();
        }
    }

    public Person[] getPeople() {
        Person[] bufferPeople = new Person[index];

        int bufferIndex = 0;
        for (Person person : this.people) {
            if (person != null) {
                bufferPeople[bufferIndex] = person;
                bufferIndex++;
            }
        }
        return bufferPeople;
    }

    public Person findById(Long id) throws OperationNotSupportedException {

        Person person = null;

        for (Person p : this.people) {
            if (p != null) {
                if (p.getId().equals(id)) {
                    person = p;
                }
            }
        }
        if (person == null) {
            throw new OperationNotSupportedException();
        }
        return person;
    }

    public Person findByName(String name) throws OperationNotSupportedException {
        Person person = null;

        for (Person p : this.people) {
            if (p != null) {
                if (p.getName().equals(name)) {
                    person = p;
                }
            }
        }
        if (name == null || name.trim().isEmpty() || person == null) {
            throw new OperationNotSupportedException();
        }
        return person;
    }
}
