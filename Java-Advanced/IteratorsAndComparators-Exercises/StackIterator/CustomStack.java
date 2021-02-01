package StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer> {
    private List<Integer> numbers;
    private int index;

    public CustomStack() {
        this.numbers = new ArrayList<>();
        this.index = -1;
    }

    public void push(int number) {
        this.numbers.add(number);
        index++;
    }

    public void pop() {
        numbers.remove(index--);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int index1 = CustomStack.this.index;

            @Override
            public boolean hasNext() {
                return this.index1 >= 0;
            }

            @Override
            public Integer next() {
                return numbers.get(this.index1--);
            }
        };
    }
}
