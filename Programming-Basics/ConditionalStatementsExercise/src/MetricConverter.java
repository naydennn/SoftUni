import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double end = 0;
        double number = Double.parseDouble(scanner.nextLine());

        String vhodnaEdinica = scanner.nextLine();
        String izhodnaEdinica = scanner.nextLine();

        if (vhodnaEdinica.equals("mm") && izhodnaEdinica.equals("m")) {
            end = number / 1000;
        } else if (vhodnaEdinica.equals("cm") && izhodnaEdinica.equals("m")) {
            end = number / 100;
        } else if (vhodnaEdinica.equals("m") && izhodnaEdinica.equals("mm"))  {
            end = number * 1000;
        } else if (vhodnaEdinica.equals("cm") && izhodnaEdinica.equals("mm")) {
            end = number * 10;
        } else if (vhodnaEdinica.equals("mm") && izhodnaEdinica.equals("cm")) {
            end = number / 10;
        } else if (vhodnaEdinica.equals("m") && izhodnaEdinica.equals("cm")) {
            end = number * 100;
        }else if (vhodnaEdinica.equals("cm") && izhodnaEdinica.equals("m")) {
            end = number / 100;
        } else {
            end = number;
        }
        System.out.printf("%.3f", end);


    }
}
