package CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void validateIndex (int index) {
        if (index< 0 || index >= this.list.size()) {
            throw  new IndexOutOfBoundsException("Invalid index");
        }
    }
    public void add(T element) {
        this.list.add(element);
    }
    public void remove(int index) {
        validateIndex(index);
        this.list.remove(index);
    }
    public  boolean contains(T element) {
        return list.contains(element);
    }
    public void swap(int firstIndex, int secondIndex) {
        validateIndex(firstIndex);
        validateIndex(secondIndex);
        T firstElement = this.list.get(firstIndex);
        T secondElement = this.list.get(secondIndex);
        this.list.add(firstIndex, secondElement);
        this.list.remove(firstIndex + 1);
        this.list.add(secondIndex,firstElement);
        this.list.remove(secondIndex + 1);
    }
    public int countGreaterThan(T greaterElement) {
        int count = 0;
        for (T element : list) {
            int result = greaterElement.compareTo(element);
            if (result < 0) {
                count++;
            }
        }
        return count;
    }
    public T getMax() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T maxElement = list.stream().max(Comparable::compareTo).get();
        return maxElement;
    }
    public T getMin() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T minElement = list.stream().min(Comparable::compareTo).get();
        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            sb.append(element);
            if (i < list.size() - 1){
                sb.append(System.lineSeparator());
            }
        }

        return  sb.toString();
    }
}
