package CustomListSorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Box box = new Box();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case"Add":
                    String element = tokens[1];
                    box.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    box.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    boolean contains = box.contains(element);
                    System.out.println(contains);
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    box.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = tokens[1];
                    int countGreaterThan = box.countGreaterThan(element);
                    System.out.println(countGreaterThan);
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Print":
                    System.out.println(box.toString());
                    break;
                case "Sort":
                        Sort.sort(box);
                    break;
            }

            input = reader.readLine();
        }

    }
}
