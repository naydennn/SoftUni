import java.util.Scanner;

public class L10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            int num = Integer.parseInt(number);
            if (num <= 9) {
                char a = number.charAt(0);
                if (a - '0'  == 5 || a - '0' == 7) {
                    System.out.println(a + " " + "->" + " " + "True");
                } else {
                    System.out.println(a + " " + "->" + " " + "False");
                }
            } else {
                char a = number.charAt(0);
                char b = number.charAt(1);
                if (a - '0' + b - '0' == 5 || a - '0' + b - '0' == 7 || a - 48 + b - 48 == 11) {
                    System.out.println(number + " " + "->" + " " + "True");
                } else {
                    System.out.println(number + " " + "->" + " " + "False");
                }
            }


        }

    }
}


