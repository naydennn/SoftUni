package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");

        List<TrafficLights> trafficLights = new ArrayList<>();

        for (String signal : signals) {
            trafficLights.add(new TrafficLights(Lights.valueOf(signal)));
        }

        int countOfUpdates = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfUpdates; i++) {
            for (TrafficLights light : trafficLights) {
                light.update();
                System.out.print(light.toString() + " ");
            }
            System.out.println();
        }
    }
}
