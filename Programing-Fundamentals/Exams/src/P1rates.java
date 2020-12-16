import java.util.*;

public class P1rates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> populationMap = new TreeMap<>();
        Map<String, Integer> goldMap = new TreeMap<>();

        while (!input.equals("Sail")) {
            String[] token = input.trim().split("\\|\\|");
            String cities = token[0];
            int population = Integer.parseInt(token[1]);
            int gold = Integer.parseInt(token[2]);

            if (!populationMap.containsKey(cities)) {
                populationMap.put(cities, population);
                goldMap.put(cities, gold);
            } else {
                populationMap.put(cities, populationMap.get(cities) + population);
                goldMap.put(cities, goldMap.get(cities) + gold);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.trim().split("=>");
            switch (commands[0]) {
                case "Plunder":
                    String town = commands[1];
                    int people = Integer.parseInt(commands[2]);
                    int gold = Integer.parseInt(commands[3]);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                    for (Map.Entry<String, Integer> entry : populationMap.entrySet()) {
                        if (entry.getKey().equals(town)) {
                            if (entry.getValue() - people != 0) {
                                populationMap.put(town, populationMap.get(town) - people);
                            } else {
                                populationMap.remove(town);
                                goldMap.remove(town);
                                System.out.println(town + " has been wiped off the map!");
                                break;
                            }
                        }
                    }

                    for (Map.Entry<String, Integer> entry : goldMap.entrySet()) {
                        if (entry.getKey().equals(town)) {
                            if (entry.getValue() - gold != 0) {
                                goldMap.put(town, goldMap.get(town) - gold);
                            } else {
                                goldMap.remove(town);
                                populationMap.remove(town);
                                System.out.println(town + " has been wiped off the map!");
                                break;
                            }
                        }
                    }

                    break;
                case "Prosper":
                    town = commands[1];
                    gold = Integer.parseInt(commands[2]);

                    increaseGold(goldMap, town, gold);

                    break;
            }

            input = scanner.nextLine();
        }
        if (goldMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", goldMap.size());

            goldMap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(a -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", a.getKey(), populationMap.get(a.getKey()), a.getValue()));
        }
    }

    private static void increaseGold(Map<String, Integer> goldMap, String town, int gold) {
        if (gold >= 0) {
            goldMap.put(town, goldMap.get(town) + gold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, goldMap.get(town));
        } else {
            System.out.println("Gold added cannot be a negative number!");
        }

    }
}






