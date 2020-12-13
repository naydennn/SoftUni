import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int result = getInteger(firstNum,secondNum,thirdNum);
        System.out.println(result);
    }
    public static int getInteger(int first,int second, int third) {
        int result = (first+ second) - third;
        return result;
    }
}
