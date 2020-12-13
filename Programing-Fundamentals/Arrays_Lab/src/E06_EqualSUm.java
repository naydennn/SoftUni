import javax.naming.InterruptedNamingException;
import java.util.Arrays;
import java.util.Scanner;

public class E06_EqualSUm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isEqual = false;
        int currentIndex= 0;
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(value -> Integer.parseInt(value)).toArray();

        for (int i = 0; i <array.length ; i++) {

            int rightSum = 0;
            int leftSum = 0;

            for (int j = 0; j <array.length ; j++) {
                if (i >j) {
                    rightSum+= array[j];
                } else if (i < j){
                    leftSum+= array[j];
                }
            }
            if (leftSum == rightSum) {
                isEqual = true;
                currentIndex = i;
            }
        }
        if (isEqual) {
            System.out.println(currentIndex);
        } else {
            System.out.println("no");
        }
    }
}
