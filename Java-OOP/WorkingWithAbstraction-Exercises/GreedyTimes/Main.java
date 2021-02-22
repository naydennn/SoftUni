package GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);
        for (int i = 0; i < input.length; i+=2) {
            String item = input[i];
            long currency = Long.parseLong(input[i + 1]);

            bag.addItem(item, currency);
        }
        System.out.println(bag.toString());
    }
}
