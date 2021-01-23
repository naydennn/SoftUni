package GenerixBoxOfIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box () {
        this.list = new ArrayList<>();
    }
    public void addElement(T element) {
        this.list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element: this.list) {
            sb.append(element.getClass().getName() + ": " + element);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
