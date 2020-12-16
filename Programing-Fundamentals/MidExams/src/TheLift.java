import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int finish = people;
        int[] wagons = getWagons(scanner);

        int peopleInWagons;
        int peopleAlreadyIn =0;
        boolean isFull = false;

        for (int i = 0; i <wagons.length ; i++) {
            peopleInWagons = wagons[i];
            peopleAlreadyIn += peopleInWagons;
            for (int j = peopleInWagons; j <4 ; j++) {
                people--;
                peopleInWagons++;
                if (people==0) {
                    isFull = true;
                    break;
                }
            }
            wagons[i] = peopleInWagons;
            if (isFull) {
                break;
            }
        }
        int spaceInWagons = wagons.length * 4;
        finish -= spaceInWagons - peopleAlreadyIn;

        if (finish==0) {
            printArrays(wagons);
        } else if (finish < 0) {
            System.out.println("The lift has empty spots!");
            printArrays(wagons);
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            printArrays(wagons);
        }
    }

    private static int[] getWagons(Scanner scanner) {
        String[] wagonsInString = scanner.nextLine().split(" ");
        int[] wagons = new int[wagonsInString.length];

        for (int i = 0; i <wagons.length ; i++) {
            wagons[i] = Integer.parseInt(wagonsInString[i]);
        }
        return wagons;
    }

    private static void printArrays(int[] wagons) {
        for (int n:wagons) {
            System.out.print(n + " ");
        }
    }
}
