import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tracker {
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> c) {
        Map<String, List<String>> methods = new TreeMap<>();
        Method[] declaredMethods = c.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            Author annotation = declaredMethod.getAnnotation(Author.class);
            if (annotation != null) {
                methods.putIfAbsent(annotation.name(),
                        new ArrayList<>());
                methods.get(annotation.name())
                        .add(declaredMethod.getName());
            }
        }

        for (Map.Entry<String, List<String>> entry : methods.entrySet()) {
            System.out.println(entry.getKey() + ": " +entry.getValue());
        }
    }
}
