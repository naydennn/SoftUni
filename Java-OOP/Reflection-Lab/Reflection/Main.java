import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;

        System.out.println(reflectionClass);

        System.out.println(reflectionClass.getSuperclass());

        Class<?>[] interfaces = reflectionClass.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        try {
            Constructor<Reflection> declaredConstructor = reflectionClass.getDeclaredConstructor();
            Reflection reflection = declaredConstructor.newInstance();
            System.out.println(reflection.toString());
        } catch (InstantiationException
                    | IllegalAccessException
                    | InvocationTargetException
                    | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
