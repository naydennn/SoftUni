import java.util.Scanner;

public class ListManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] friend = scanner.nextLine().split(", ");

        String input = scanner.nextLine();
        int blacklistedName = 0;
        int lostNames = 0;

        while (!input.equals("Report")) {
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Blacklist":
                    boolean isBlacklisted = false;
                    for (int i = 0; i < friend.length; i++) {
                        if (friend[i].equals(commands[1])) {
                            blacklistedName++;
                            friend[i] = "Blacklisted";
                            isBlacklisted = true;
                            break;
                        }
                    }
                    if (isBlacklisted) {
                        System.out.printf("%s was blacklisted.%n", commands[1]);

                    } else {
                        System.out.printf("%s was not found.%n", commands[1]);

                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(commands[1]);
                        if ((!friend[index].equals("Blacklisted") && !(friend[index].equals("Lost")))) {
                            lostNames++;
                            System.out.printf("%s was lost due to an error.%n", friend[index]);
                            friend[index] = "Lost";
                        }
                    break;
                case "Change":
                    int indexToChange = Integer.parseInt(commands[1]);
                    String newName = commands[2];
                    if (indexToChange >=0 && indexToChange< friend.length) {
                        String currentName = friend[indexToChange];
                        friend[indexToChange] = newName;
                        System.out.printf("%s changed his username to %s.%n", currentName, newName);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n",blacklistedName );
        System.out.printf("Lost names: %d%n",lostNames );
        for (String name:friend) {
            System.out.print(name + " ");
        }
    }
}
