import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();
        while (!input.equals("PARTY")) {
            char symbol = input.charAt(0);
            if (Character.isDigit(symbol)) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("END")) {
            char symbol = input.charAt(0);
            if (Character.isDigit(symbol)) {
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vipGuests.size() + regularGuests.size());
        if (!vipGuests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vipGuests));
        }
        if (!regularGuests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regularGuests));
        }
    }
}
