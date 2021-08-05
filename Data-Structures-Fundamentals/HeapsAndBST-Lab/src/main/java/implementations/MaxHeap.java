package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private List<E> elements;

    public MaxHeap() {
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

        swim(this.size() - 1);
    }

    private void swim(int index) {

        if (index == 0) {
            return;
        }
        int parentIndex = (index - 1) / 2;

        if (isLessThan(index, parentIndex)) {
            swap(index, parentIndex);
            swim(parentIndex);
        }
    }

    private void swap(int index, int parentIndex) {
        E oldElement = this.elements.get(parentIndex);
        this.elements.set(parentIndex, this.elements.get(index));
        this.elements.set(index, oldElement);
    }

    private boolean isLessThan(int indexA, int indexB) {
        return this.elements.get(indexB).compareTo(this.elements.get(indexA)) < 0;
    }


    @Override
    public E peek() {
        if (this.elements.size() == 0) {
            throw new IllegalArgumentException("Heap is empty!");
        }
        return this.elements.get(0);
    }
}
