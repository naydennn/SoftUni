
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarShips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPirate = getIntegers(scanner);
        List<Integer> warShip = getIntegers(scanner);
        int healthCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String[] commands =input.split(" ");
            switch (commands[0]) {
                case "Fire":
                    int index = Integer.parseInt(commands[1]);
                    int damage = Integer.parseInt(commands[2]);
                    if (index >=0 && index < warShip.size()) {
                        int section = warShip.get(index);
                        section-=damage;
                        if (section <=0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        } else {
                            warShip.set(index, section);
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    int defendDamage = Integer.parseInt(commands[3]);
                    if (defend(firstPirate, startIndex, endIndex, defendDamage)) return;
                    break;
                case"Repair":
                    int healthIndex = Integer.parseInt(commands[1]);
                    int heal = Integer.parseInt(commands[2]);
                    if (healthIndex >=0 && healthIndex<firstPirate.size()) {
                        int healSection = firstPirate.get(healthIndex);
                        healSection += heal;
                        if (healSection > 15) {
                            healSection = 15;
                        }
                        firstPirate.set(healthIndex, healSection);
                    }
                    break;
                case"Status":
                    int sectionNeedRepair = 0;
                    double lowerHeal = healthCapacity*0.2;
                    for (Integer integer : firstPirate) {
                        if (integer < lowerHeal) {
                            sectionNeedRepair++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", sectionNeedRepair);
                    break;
            }


            input = scanner.nextLine();
        }
        int sumOfPirates = 0;
        int sumOfWar = 0;
        sumOfPirates = getSumOfWar(firstPirate, sumOfPirates);
        sumOfWar = getSumOfWar(warShip, sumOfWar);
        System.out.printf("Pirate ship status: %d%n", sumOfPirates);
        System.out.printf("Warship status: %d", sumOfWar);
    }

    private static List<Integer> getIntegers(Scanner scanner) {
        String[] second = scanner.nextLine().split(">");
        List<Integer> warShip = new ArrayList<>();
        for (String s : second) {
            warShip.add(Integer.parseInt(s));
        }
        return warShip;
    }

    private static int getSumOfWar(List<Integer> warShip, int sumOfWar) {
        for (int n : warShip) {
            sumOfWar += n;
        }
        return sumOfWar;
    }

    private static boolean defend(List<Integer> firstPirate, int startIndex, int endIndex, int defendDamage) {
        if (startIndex>=0 && endIndex < firstPirate.size()) {
            for (int i = startIndex; i <= endIndex; i++) {
                int defendSection = firstPirate.get(i);
                defendSection -= defendDamage;
                if (defendSection <= 0) {
                    System.out.println("You lost! The pirate ship has sunken.");
                    return true;
                } else {
                    firstPirate.set(i, defendSection);
                }
            }
        }
        return false;
    }
}
