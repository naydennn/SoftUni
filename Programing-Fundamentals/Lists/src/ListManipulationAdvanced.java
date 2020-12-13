import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = createList(scanner);
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Contains":
                    int number = Integer.parseInt(command[1]);
                    boolean isContains = checkNumber(list, number);
                    if (isContains) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")) {
                        List<Integer> evenList = getEvenList(list);
                        printList(evenList);
                    } else {
                        List<Integer> oddList = getOddList(list);
                        printList(oddList);
                    }
                    break;
                case "Get":
                    int sum = getSumOfList(list);
                    System.out.println(sum);
                    break;
                case "Filter":
                    int index = Integer.parseInt(command[2]);
                    String condition = command[1];
                    List<Integer> filteredList = new ArrayList<>();
                    if (condition.equals("<")) {
                        filteredList = getFilteredList(list, index, condition);
                    } else if (condition.equals(">")) {
                        filteredList = getFilteredList(list, index, condition);
                    } else if (condition.equals(">=")) {
                        filteredList = getFilteredList(list, index, condition);
                    } else if (condition.equals("<=")) {
                        filteredList = getFilteredList(list, index, condition);
                    }
                    printList(filteredList);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    public static List<Integer> getFilteredList(List<Integer> list, int number, String command) {
        List<Integer> filteredList = new ArrayList<>();
        switch (command) {
            case "<":
                for (int num : list) {
                    if (num < number) {
                        filteredList.add(num);
                    }
                }
                break;
            case ">":
                for (int num : list) {
                    if (num > number) {
                        filteredList.add(num);
                    }
                }
                break;
            case ">=":
                for (int num : list) {
                    if (num >= number) {
                        filteredList.add(num);
                    }
                }
                break;
            case "<=":
                for (int num : list) {
                    if (num <= number) {
                        filteredList.add(num);
                    }
                }
                break;
        }
        return filteredList;

    }

    public static int getSumOfList(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static List<Integer> getOddList(List<Integer> list) {
        List<Integer> oddList = new ArrayList<>();
        for (int num : list) {
            if (num % 2 != 0)
                oddList.add(num);
        }
        return oddList;
    }

    public static List<Integer> getEvenList(List<Integer> list) {
        List<Integer> evenList = new ArrayList<>();
        for (int num : list) {
            if (num % 2 == 0)
                evenList.add(num);
        }
        return evenList;
    }

    public static boolean checkNumber(List<Integer> list, int number) {
        for (Integer num : list) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    public static void printList(List<Integer> numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static List<Integer> createList(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsString = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : lineAsString) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
