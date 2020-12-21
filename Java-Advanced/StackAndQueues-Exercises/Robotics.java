import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");
        Map<String, Integer> robots = getLinkedHashMap(input);
        String[] time = scanner.nextLine().split(":");
        long totalTimeInSeconds = Long.parseLong(time[0]) * 3600 + Long.parseLong(time[1]) * 60
                + Long.parseLong(time[2]);

        String product = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!product.equals("End")) {
            queue.offer(product);
            product = scanner.nextLine();
        }
        int[] robotTime = new int[robots.size()];

        while (!queue.isEmpty()) {
            String productToPass = queue.poll();
            totalTimeInSeconds += 1;
            for (int i = 0; i < robotTime.length; i++) {
                if (robotTime[i] > 0) {
                    robotTime[i] -= 1;
                }
            }
            boolean isAssigned = false;

            for (int i = 0; i < robotTime.length; i++) {
                if (robotTime[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                        if (count == i) {
                            robotTime[i] = entry.getValue();
                            long hours =  (totalTimeInSeconds / 3600 % 24);
                            long minutes =  (totalTimeInSeconds % 3600 / 60);
                            long seconds =  totalTimeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", entry.getKey(),
                                    productToPass, hours, minutes, seconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                queue.offer(productToPass);
            }
        }

    }

    private static Map<String, Integer> getLinkedHashMap(String[] input) {
        Map<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String name = input[i].split("-")[0];
            int time = Integer.parseInt(input[i].split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
