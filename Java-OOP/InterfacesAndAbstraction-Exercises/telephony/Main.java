package telephony;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> numbers = List.of("0882134215", "0882134333", "08992134215", "0558123", "3333", "1");
        List<String> urls = List.of("http://softuni.bg", "http://youtube.com", "http://www.g00gle.com");

        Smartphone samsung = new Smartphone(numbers, urls);
        System.out.println(samsung.call());
        System.out.println(samsung.browse());
    }
}
