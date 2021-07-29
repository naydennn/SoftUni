import implementations.DoublyLinkedList;
import implementations.Queue;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();

        integers.addLast(1);
        integers.addLast(2);
        integers.addLast(3);
        integers.addLast(4);
        integers.addLast(5);

        integers.removeLast();
        integers.removeLast();
        integers.removeLast();
        integers.removeLast();
        integers.removeLast();


    }
}
