import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] commands = input.split(", ");
            String carNumber = commands[1];

            switch (commands[0]) {
                case "IN":
                    parkingLot.add(carNumber);
                    break;
                case "OUT":
                    parkingLot.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
