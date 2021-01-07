import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        putZeroValues(keyMaterials);

        Map<String, Integer> junkMaterials = new TreeMap<>();

        String winner = " ";
        while (winner.equals(" ")) {
            String[] items = scanner.nextLine().split(" ");

            int quantity;
            String materials;
            boolean haveWinner = false;

            for (int i = 1; i < items.length; i += 2) {
                quantity = Integer.parseInt(items[i - 1]);
                materials = items[i].toLowerCase();
                switch (materials) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        keyMaterials.put(materials, keyMaterials.get(materials) + quantity);
                        if (keyMaterials.get(materials) >= 250) {
                            winner = materials;
                            keyMaterials.put(materials, keyMaterials.get(materials) - 250);
                            haveWinner = true;
                        }
                        break;
                    default:
                        if (!junkMaterials.containsKey(materials)) {
                            junkMaterials.put(materials, quantity);
                        } else {
                            junkMaterials.put(materials, junkMaterials.get(materials) + quantity);
                        }
                        break;
                }
                if (haveWinner) {
                    break;
                }
            }
        }
        getWinner(winner);

        keyMaterials.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).
                forEach(a -> System.out.println(a.getKey() + ": " + a.getValue()));

        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void putZeroValues(Map<String, Integer> keyMaterials) {
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
    }

    private static void getWinner(String winner) {
        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
    }
}