import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int number = Math.abs(Integer.parseInt(scanner.nextLine()));

      int result = multiplyEvenByOdds(number);
        System.out.println(result);
    }
    public static int multiplyEvenByOdds(int number){
        int sumEven =0;
        int sumOdd = 0;
        while (number >0) {
            int num = number%10;
            if (num % 2 == 0) {
                sumEven+= num;
            } else {
                sumOdd += num;
            }
            number /=10;
        }
        int result = sumEven * sumOdd;
        return result;
    }
}
