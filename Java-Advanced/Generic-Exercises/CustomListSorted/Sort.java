package CustomListSorted;

public class Sort {

    public static<T extends Comparable<T>> void sort(Box<T> box) {
        for (int i = 0; i < box.size(); i++) {
            T element =  box.get(i);
            for (int j = i + 1; j < box.size(); j++) {
                T nextElement =  box.get(j);
                if (element.compareTo(nextElement) > 0) {
                    box.swap(i, j);
                }
            }
        }
    }
}
