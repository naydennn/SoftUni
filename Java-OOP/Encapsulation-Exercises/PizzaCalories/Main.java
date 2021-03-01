package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] commands = input.split("\\s+");
        try {

            Pizza pizza = new Pizza(commands[1], Integer.parseInt(commands[2]));

            commands = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(commands[1], commands[2], Integer.parseInt(commands[3]));
            pizza.setDough(dough);

            input = scanner.nextLine();

            while (!input.equals("END")) {
                commands = input.split("\\s+");

                Topping topping = new Topping(commands[1], Double.parseDouble(commands[2]));
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }
            System.out.println(pizza.toString());
        }catch (Exception exception) {
            System.out.println(exception);
        }
        }
    }
