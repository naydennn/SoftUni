package GenericWithSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Box box = new Box();

        for (int i = 0; i < n; i++) {
            String element = reader.readLine();
            box.addElement(element);
        }
        String[] indexes = reader.readLine().split("\\s+");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);

        box.swapIndexes(firstIndex, secondIndex);
        System.out.println(box.toString());
    }
}
