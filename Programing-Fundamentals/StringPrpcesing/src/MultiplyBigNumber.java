import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int second = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int n = 0;
        if (firstNum.isEmpty()){
            firstNum = "0";
        }
        if (second == 0) {
            System.out.println(0);
            return;
        }
        for (int i = firstNum.length() - 1; i >= 0; i--) {

            int num = Integer.parseInt(String.valueOf(firstNum.charAt(i))) * second + n;
            result.append(num % 10);
            n = num / 10;


        }
        if (n > 0){
            result.append(n);
        }
        System.out.println(result.reverse());
    }
}
