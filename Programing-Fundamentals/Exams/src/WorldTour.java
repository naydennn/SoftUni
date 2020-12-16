import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    String state = commands[2];
                    if (index >=0 && index < stops.length()) {
                        StringBuilder sb = new StringBuilder(stops);
                        stops = sb.insert(index, state).toString();
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (startIndex >=0 && endIndex < stops.length()) {
                        String stringToReplace = stops.substring(startIndex, endIndex +1);
                        stops = stops.replace(stringToReplace, "");
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldState = commands[1];
                    String newState = commands[2];
                    if (stops.contains(oldState)) {
                        stops = stops.replaceAll(oldState, newState);
                    }
                    System.out.println(stops);
                    break;

            }

            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
}
