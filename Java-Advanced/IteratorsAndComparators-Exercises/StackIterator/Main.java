package StackIterator;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();
        String in = scanner.nextLine();
        while (!in.equals("END")) {
            String[] tokens = in.split("\\s+");
            switch (tokens[0]) {
                case "Push":
                    Arrays.stream(in.split(",*\\s+"))
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .forEach(stack::push);
                    break;
                case "Pop":
                    try{
                        stack.pop();
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("No elements");
                    }
            }

            in = scanner.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
