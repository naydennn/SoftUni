import java.util.*;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> likedMeals = new TreeMap<>();
        int unlikedMeals = 0;

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] commands = input.split("-");
            String guest = commands[1];
            String meal = commands[2];
            switch (commands[0]) {
                case "Like":
                    List<String> meals = likedMeals.get(guest);
                    if (meals == null) {
                        meals = new ArrayList<>();
                        likedMeals.put(guest, meals);
                    }
                    if (likedMeals.get(guest).contains(meal)) {
                        break;
                    } else {
                        meals.add(meal);
                        likedMeals.put(guest, meals);
                    }
                    break;
                case "Unlike":
                    if (likedMeals.containsKey(guest)) {
                        boolean haveMeal = false;
                        for (Map.Entry<String, List<String>> entry : likedMeals.entrySet()) {
                            if (entry.getKey().equals(guest) && entry.getValue().contains(meal)) {
                                haveMeal = true;
                                entry.getValue().remove(meal);
                                unlikedMeals++;
                                System.out.println(guest + " doesn't like the " + meal + ".");
                            }
                        }
                        if (!haveMeal) {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        }

                    } else {
                        System.out.println(guest + " is not at the party.");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        likedMeals.entrySet().stream().sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(a -> System.out.println(a.getKey() + ": " + String.join(", ", a.getValue())));
        System.out.println("Unliked meals: " + unlikedMeals);
    }
}
