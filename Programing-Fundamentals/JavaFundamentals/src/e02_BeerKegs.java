import java.util.Scanner;

public class e02_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String maxBeerKeg = "";
        float maxVolume = Float.MIN_VALUE;


        for (int i = 1; i <= count ; i++) {
            float volume = 0;
            String model = scanner.nextLine();
            float radius = Float.parseFloat(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            volume = (float) (Math.PI * (radius * radius) * height);

            if (volume > maxVolume) {
                maxVolume = volume;
                maxBeerKeg = model;
            }
        }
        System.out.println(maxBeerKeg);
    }
}
