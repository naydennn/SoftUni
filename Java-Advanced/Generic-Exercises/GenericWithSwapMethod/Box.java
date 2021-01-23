package GenericWithSwapMethod;

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
    public void swapIndexes(int firstIndex, int secondIndex) {
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);
        list.add(firstIndex, secondElement);
        list.remove(firstIndex + 1);
        list.add(secondIndex, firstElement);
        list.remove(secondIndex + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element: list) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element));
            sb.append(System.lineSeparator());
        }
        return  sb.toString();
    }
}
