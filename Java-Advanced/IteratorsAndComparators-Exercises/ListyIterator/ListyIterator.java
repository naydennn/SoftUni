package ListyIterator;

import java.util.List;

public class ListyIterator {
    private int index;
    private List<String> collections;

    public ListyIterator(List<String> collections) {
        this.collections = collections;
        if (collections.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move() {
        if (index + 1 < this.collections.size()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (index != -1) {
            System.out.println(collections.get(index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        if (index + 1 < this.collections.size() ) {
            return true;
        }
        return false;
    }

}
