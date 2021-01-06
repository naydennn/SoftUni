import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            symbols.putIfAbsent(symbol, 0);
            symbols.put(symbol, symbols.get(symbol) + 1);
        }
        for (Map.Entry<Character, Integer> symbol : symbols.entrySet()) {
            System.out.println(symbol.getKey() + ": " + symbol.getValue() + " time/s");
        }
    }
}
