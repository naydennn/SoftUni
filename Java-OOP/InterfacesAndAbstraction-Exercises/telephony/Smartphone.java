package telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();

        boolean isValidUrl = true;

        for (String url : this.urls) {
            char[] arr = url.toCharArray();
            for (char symbol : arr) {
                if (Character.isDigit(symbol)) {
                    result.append("Invalid URL!").append(System.lineSeparator());
                    isValidUrl = false;
                    break;
                }
            }
            if (isValidUrl) {
                result.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        boolean isValidNumber = true;

        for (String number : this.numbers) {
            char[] arr = number.toCharArray();
            for (char symbol : arr) {
                if (!Character.isDigit(symbol)) {
                    result.append("Invalid number!").append(System.lineSeparator());
                    isValidNumber = false;
                    break;
                }
            }
            if (isValidNumber) {
                result.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return result.toString().trim();
    }
}
