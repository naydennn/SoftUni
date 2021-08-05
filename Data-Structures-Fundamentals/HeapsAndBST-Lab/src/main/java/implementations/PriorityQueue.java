package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    public List<E> getElements() {
        return elements;
    }

    public void setElements(List<E> elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);

        swim(this.elements.size() - 1);
    }

    private void swim(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;

        if (isLessThan(parentIndex, index)) {
            swap(index, parentIndex);
            swim(parentIndex);
        }
    }

    private void swap(int index, int parentIndex) {
        E oldElement = this.elements.get(parentIndex);
        this.elements.set(parentIndex, this.elements.get(index));
        this.elements.set(index, oldElement);
    }

    private boolean isLessThan(int index, int parentIndex) {
        return elements.get(index).compareTo(elements.get(parentIndex)) < 0;
    }

    @Override
    public E peek() {
        if (this.elements.size() == 0) {
            throw new IllegalArgumentException("Heap is empty!");
        }
        return this.elements.get(0);
    }

    @Override
    public E poll() {
        if (this.size() == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        E maxElement = this.elements.get(0);

        this.elements.set(0, this.elements.get(this.elements.size() - 1));
        elements.remove(elements.size() - 1);

        sink(0);
        return maxElement;
    }

    private void sink(int index) {
        int firstChild = index * 2 + 1;
        int secondChild = index * 2 + 2;

        if (!isValidIndex(firstChild)) {
            return;
        }

        int maxIndex;
        if (isValidIndex(secondChild) && isLessThan(firstChild, secondChild)) {
            maxIndex = secondChild;
        } else {
            maxIndex = firstChild;
        }

        if (isLessThan(index, maxIndex)) {
            swap(index, maxIndex);
            sink(maxIndex);
        }


    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.elements.size() - 1;
    }
}
