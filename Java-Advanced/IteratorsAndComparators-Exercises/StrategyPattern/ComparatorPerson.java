package StrategyPattern;

import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int compare = Integer.compare(first.getName().length(), second.getName().length());
        if (compare == 0) {
            compare = first.getName().toLowerCase().charAt(0) - second.getName().toLowerCase().charAt(0);
        }
        return compare;
    }
}
