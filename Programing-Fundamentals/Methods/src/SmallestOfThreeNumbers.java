import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int result = getSmallestNumber(firstNum, secondNum, thirdNum);
        System.out.println(result);
    }
    static int getSmallestNumber(int first, int second, int third) {

        if (first < second && first< third){
            return first;
        } else if (second< first && second< third) {
            return second;
        }
        return third;


    }
}
