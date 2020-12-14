import java.util.Scanner;

public class me01_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int digit = 0;

        while (count >= digit) {

            digit++;

            int numOfDigit = 0;
            int numOfLetter = 0;

            int number = Integer.parseInt(scanner.nextLine());


            if (number > 9) {
                String num = number + "";
                for (int i = 0; i < num.length(); i++) {
                    number = num.charAt(0) - 48;
                    if (i == 1) {
                        numOfDigit += 1;
                    } else if (i == 2) {
                        numOfDigit += 1;
                    }
                }

            } else if (number == 0) {
                System.out.print(" ");
                continue;
            }

            switch (number) {
                case 2:
                    numOfLetter = 0;
                    break;
                case 22:
                    numOfLetter = 1;
                    break;
                case 222:
                    numOfLetter = 2;
                    break;
                case 8:
                case 9:
                    numOfLetter = (number - 2) * 3;
                    numOfLetter += 1;
                    break;
                default:
                    numOfLetter = (number - 2) * 3;
                    break;
            }
            numOfLetter += numOfDigit;
            switch (numOfLetter) {
                case 0:
                    System.out.print("a");
                    break;
                case 1:
                    System.out.print("b");
                    break;
                case 2:
                    System.out.print("c");
                    break;
                case 3:
                    System.out.print("d");
                    break;
                case 4:
                    System.out.print("e");
                    break;
                case 5:
                    System.out.print("f");
                    break;
                case 6:
                    System.out.print("g");
                    break;
                case 7:
                    System.out.print("h");
                    break;
                case 8:
                    System.out.print("i");
                    break;
                case 9:
                    System.out.print("j");
                    break;
                case 10:
                    System.out.print("k");
                    break;
                case 11:
                    System.out.print("l");
                    break;
                case 12:
                    System.out.print("m");
                    break;
                case 13:
                    System.out.print("n");
                    break;
                case 14:
                    System.out.print("o");
                    break;
                case 15:
                    System.out.print("p");
                    break;
                case 16:
                    System.out.print("q");
                    break;
                case 17:
                    System.out.print("r");
                    break;
                case 18:
                    System.out.print("s");
                    break;
                case 19:
                    System.out.print("t");
                    break;
                case 20:
                    System.out.print("u");
                    break;
                case 21:
                    System.out.print("v");
                    break;
                case 22:
                    System.out.print("w");
                    break;
                case 23:
                    System.out.print("x");
                    break;
                case 24:
                    System.out.print("y");
                    break;
                case 25:
                    System.out.print("z");
                    break;
            }
        }
    }
}
