package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> data = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            
            if (tokens.length == 3) {
                data.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            } else {
                data.add(new Robot(tokens[0], tokens[1]));
            }
            input = scanner.nextLine();
        }
        String id = scanner.nextLine();

        for (Identifiable identifiable : data) {
            if (identifiable.getId().endsWith(id)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
