import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numberAsString = scanner.nextLine().split(" ");
        List<Integer> sequenceOfTarget = new ArrayList<>();
        for (String s : numberAsString) {
            sequenceOfTarget.add(Integer.parseInt(s));
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            int index = Integer.parseInt(commands[1]);
            switch (commands[0]) {
                case "Shoot":
                    if (index >= 0 && index <= sequenceOfTarget.size()) {
                        int power = Integer.parseInt(commands[2]);
                        int valueOfIndex = sequenceOfTarget.get(index);
                        valueOfIndex -= power;
                        sequenceOfTarget.set(index, valueOfIndex);
                        if (valueOfIndex <= 0) {
                            sequenceOfTarget.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index <= sequenceOfTarget.size()) {
                        int valueToAdd = Integer.parseInt(commands[2]);
                        sequenceOfTarget.add(index,valueToAdd);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(commands[2]);
                    int strikeIndex = sequenceOfTarget.get(index);
                    strikeIndex = sequenceOfTarget.indexOf(strikeIndex);

                    int left = strikeIndex - radius;
                    if (left >=0 && strikeIndex + radius < sequenceOfTarget.size()) {
                        sequenceOfTarget.remove(index);
                        for (int i = strikeIndex; i >= left; i--) {
                            sequenceOfTarget.remove(i);
                        }
                        for (int i = strikeIndex; i >= strikeIndex + radius ; i++) {
                            sequenceOfTarget.remove(i);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < sequenceOfTarget.size(); i++) {
            if (i < sequenceOfTarget.size() - 1) {
                System.out.print(sequenceOfTarget.get(i) + "|");
            } else {
                System.out.print(sequenceOfTarget.get(i));
            }
        }
    }
}
