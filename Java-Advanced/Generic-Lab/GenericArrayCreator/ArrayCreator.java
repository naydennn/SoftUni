package GenericArrayCreator;


import java.lang.reflect.Array;

public class ArrayCreator <Type>{

    public static <Type> Type[] create(int length, Type item) {
        Type[] arr =(Type[]) new Object[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }

    public static <Type> Type[] create(Class<Type> clazz, int length, Type item) {
        Type[] arr = (Type[]) Array.newInstance(clazz, length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
