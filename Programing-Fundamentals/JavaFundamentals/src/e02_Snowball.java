import java.util.Scanner;

public class e02_Snowball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowball = Integer.parseInt(scanner.nextLine());
        int   maxSnowballSnow = 0, maxSnowballTime = 0, maxSnowballQuality = 0;
        long snowballValue = 0, maxSnowballValue = 0;
        for (int i =1; i <= numberOfSnowball ; i++) {
            int snowballSnow = scanner.nextInt();
            int snowballTime = scanner.nextInt();
            int snowballQuality = scanner.nextInt();

            int snow = (snowballSnow / snowballTime);
            snowballValue =(long) Math.pow( snow , snowballQuality);
            if (snowballValue >= maxSnowballValue) {
                maxSnowballValue = snowballValue;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality );
    }
}
