import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        calculation(command, firstNum, secondNum);
    }
    public static void calculation (String command, int firstNum, int secondNum) {
        if (command.equals("add")) {
            System.out.println(firstNum + secondNum);
        } else if (command.equals("multiply")) {
            System.out.println(firstNum * secondNum);
        } else if (command.equals("divide")) {
            System.out.println(firstNum / secondNum);
        }else if (command.equals("subtract")) {
            System.out.println(firstNum - secondNum);
        }
    }
}
