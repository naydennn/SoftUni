import javax.swing.*;
import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int operation = 0;


        for (int i = 0; i <=number ; i++) {
            for (int j = 0; j <=number ; j++) {
                for (int k = 0; k <=number ; k++) {
                    int sum = i + j + k;
                    if (sum == number){
                        operation++;
                    }
                }
            }
        }
        System.out.println(operation);
    }
}
