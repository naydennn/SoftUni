package mathOperation;

public class MathOperation {

    public int add(int first, int second) {
        return first + second;
    }

    public int add(int first, int second, int third) {
        return first + second + third;
    }

    public int add(int first, int second, int third, int forth) {
        return add(first, second, third) + forth;
    }
}
