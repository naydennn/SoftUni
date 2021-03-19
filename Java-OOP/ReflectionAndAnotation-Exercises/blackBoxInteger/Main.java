package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();


        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");

            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = BlackBoxInt.class.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.getInt(blackBoxInt));
            input = scanner.nextLine();
        }
    }
}
