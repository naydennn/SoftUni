package ShoppingSpree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person pesho = new Person("Pesho", 11);
        Person mimi = new Person("Mimi", 0);
        Product bread = new Product("Bread", 10);
        Product kafence = new Product("Kafence", 2);
        Person gosho = new Person("Gosho", 4);
        Product milk = new Product("Milk", 2);

        mimi.buyProduct(kafence);
        pesho.buyProduct(bread);
        gosho.buyProduct(milk);
        gosho.buyProduct(milk);
        pesho.buyProduct(milk);
        System.out.println(mimi.toString());
        System.out.println(pesho.toString());
        System.out.println(gosho.toString());

        Person jeko = new Person("Jeko", -3);
    }
}
