
import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resources = scanner.nextLine();
        Map<String, Integer> resourcesAndQuantity = new LinkedHashMap<>();
        while (!resources.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourcesAndQuantity.containsKey(resources)) {
                resourcesAndQuantity.put(resources, quantity);
            } else {
                resourcesAndQuantity.put(resources, resourcesAndQuantity.get(resources) + quantity);
            }
            resources = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resourcesAndQuantity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
