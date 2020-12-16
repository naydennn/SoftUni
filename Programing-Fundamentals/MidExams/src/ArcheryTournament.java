import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = getField(scanner);

        String input = scanner.nextLine();
        int points = 0;

        while (!input.equals("Game over")) {
            String[] token = input.split(" ");
            switch (token[0]) {
                case "Shoot":
                    String[] commands = token[1].split("@");
                    int startIndex = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]) + 1;
                    int target;
                    if (startIndex >= 0 && startIndex < numbers.length) {
                        switch (commands[0]) {
                            case "Left":
                                target = startIndex + length;
                                while (target <= numbers.length){
                                    if (numbers[target] >=5) {
                                        points+=5;
                                        numbers[target] -= 5;
                                    } else {
                                        points += numbers[target];
                                        numbers[target] = 0;
                                    }
                                    target += startIndex+length;
                                }
                                break;
                            case "Right":
                                target = startIndex - length;
                                if (target<0)
                                break;
                        }
                    }
                    break;
                case "Reverse":
                    for (int i = 0; i < numbers.length / 2; i++) {
                        int temp = numbers[i];
                        numbers[i] = numbers[numbers.length - i - 1];
                        numbers[numbers.length - i - 1] = temp;
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (int n:numbers) {
            System.out.print(n + "-");
        }
    }

    private static int[] getField(Scanner scanner) {
        String[] numInString = scanner.nextLine().split("\\|");
        int[] numbers = new int[numInString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numInString[i]);
        }
        return numbers;
    }
}
