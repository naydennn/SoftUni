package GenericCountWithDoubles;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private static int count = 0;

    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element) {
        this.elements.add(element);
    }

    public void compareElement(T elementToCompare) {
        for (T element : elements) {
            int compare = elementToCompare.compareTo(element);
            if (compare < 0) {
                count++;
            }
        }
    }

    public static int getCount() {
        return count;
    }
}
