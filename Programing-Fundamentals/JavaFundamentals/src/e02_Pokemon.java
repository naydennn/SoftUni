import java.util.Scanner;

public class e02_Pokemon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int pokePowerOriginal = pokePower;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int pokes = 0;

        while (pokePower >= distance) {
            pokePower -= distance;
            pokes++;
            if (pokePower * 2 == pokePowerOriginal && exhaustionFactor !=0) {
                pokePower /= exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(pokes);
    }
}
