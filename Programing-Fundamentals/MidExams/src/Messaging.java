import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> list = new ArrayList<>();

        String start = scanner.nextLine();
        while (!start.equals("end")) {
            String[] commands = start.split(" ");

            switch (commands[0]) {
                case "Chat":
                    list.add(commands[1]);
                    break;
                case "Delete":
                    while (list.contains(commands[1])) {
                        list.remove(commands[1]);
                    }
                    break;
                case "Edit":

                    list.remove(commands[1]);
                    list.add(commands[2]);
                    break;
                case "Pin":
                    list.remove(commands[1]);
                    list.add(commands[1]);
                    break;
                case "Spam":
                    for (int i = 1; i < commands.length; i++) {
                        list.add(commands[i]);
                    }
                    break;
            }

            start = scanner.nextLine();
        }
        for (String s:list) {
            System.out.println(s);
        }
    }
}
