import java.util.*;

public class ListOfProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> linesOfProduct = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            linesOfProduct.add(product);
        }
        Collections.sort(linesOfProduct);
        int count = 1;
        for (String product : linesOfProduct) {
            System.out.println(count + "." + product);
            count++;
        }
    }
}
