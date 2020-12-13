import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        // int[] exchangedArray = new int [array.length];
        String text = scanner.nextLine();

        while (!text.equals("end")) {
            String[] commands = text.split(" ");

            if (commands[0].equals("exchange")) {
                int index = Integer.parseInt(commands[1]);
                if (index >= 0 && index < array.length) {
                    array = exchangeIndexOfArray(array, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (commands[0].equals("max")) {
                if (commands[1].equals("even")) {
                    getMaxEven(array);
                } else if (commands[1].equals("odd")) {
                    getMaxOdd(array);
                }
            } else if (commands[0].equals("min")) {
                if (commands[1].equals("even")) {
                    getMinEven(array);
                } else if (commands[1].equals("odd")) {
                    getMinOdd(array);
                }
            } else if (commands[0].equals("first")) {
                int count = Integer.parseInt(commands[1]);
                if (commands[2].equals("even")) {
                    if (count > 0 && count <= array.length) {
                        getEvenElement(array, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                } else if (commands[2].equals("odd")) {
                    if (count > 0 && count <= array.length) {
                        getOddElement(array, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                }
            } else if (commands[0].equals("last")) {
                int count = Integer.parseInt(commands[1]);
                if (commands[2].equals("odd")) {
                    if (count > 0 && count <= array.length) {
                        getLastOddElement(array, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                } else if (commands[2].equals("even")) {
                    if (count > 0 && count <= array.length) {
                        getLastEvenElement(array, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                }
            }

            text = scanner.nextLine();
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print("," + " ");
            }
        }
        System.out.print("]");
    }

    public static int[] exchangeIndexOfArray(int array[], int index) {

        int[] left = new int[index + 1];
        int[] right = new int[array.length - left.length];

        for (int i = 0; i <= index; i++) {
            left[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            right[i - (index + 1)] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            array[i] = right[i];
        }
        for (int i = right.length; i < array.length; i++) {
            array[i] = left[i - right.length];
        }
        return array;
    }

    public static void getMaxEven(int[] array) {
        int maxEven = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] >= maxEven)
                    maxEven = array[i];
            }
        }
        if (maxEven > 0) {
            for (int i = 0; i < array.length; i++) {
                if (maxEven == array[i]) {
                    index = i;
                }
            }
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    public static void getMaxOdd(int[] array) {
        int maxOdd = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] >= maxOdd) {
                    maxOdd = array[i];
                }
            }
        }
        if (maxOdd > 0) {
            for (int i = 0; i < array.length; i++) {
                if (maxOdd == array[i]) {
                    index = i;
                }
            }
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    public static void getMinEven(int[] array) {
        int minEven = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] <= minEven) {
                minEven = array[i];
            }
        }
        if (minEven >= 0 && minEven != Integer.MAX_VALUE) {
            for (int i = 0; i < array.length; i++) {
                if (minEven == array[i]) {
                    index = i;
                }
            }
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    public static void getMinOdd(int[] array) {
        int minOdd = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] <= minOdd) {
                minOdd = array[i];
            }
        }
        if (minOdd > 0 && minOdd != Integer.MAX_VALUE) {
            for (int i = 0; i < array.length; i++) {
                if (minOdd == array[i]) {
                    index = i;
                }
            }
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    public static void getEvenElement(int[] array, int count) {
        int[] evenArray = new int[array.length];
        int j = 0;
        boolean isAllZero = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < count; i++) {
            if (evenArray[i] != 0) {
                isAllZero = false;
            }
        }
        if (!isAllZero) {
            System.out.print("[");
            for (int i = 0; i < count; i++) {
                if (evenArray[i] == 0) {
                    continue;
                } else {
                    System.out.print(evenArray[i]);
                    if (i < count - 1 && array[i+1] !=0) {
                        System.out.print("," + " ");
                    }
                }
            }
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public static void getOddElement(int[] array, int count) {
        int[] oddArray = new int[array.length];
        int j = 0;
        boolean isAllZero = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddArray[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < count; i++) {
            if (oddArray[i] != 0) {
                isAllZero = false;
            }
        }
        if (!isAllZero) {
            System.out.print("[");
            for (int i = 0; i < count; i++) {
                if (oddArray[i] == 0) {
                    continue;
                } else {
                    System.out.print(oddArray[i]);
                    if (i < count - 1&& oddArray[i+ 1] !=0) {
                        System.out.print("," + " ");
                    }
                }
            }
            System.out.print("]");
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public static void getLastOddElement(int[] array, int count) {
        int[] lastEvenArray = new int[count];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0 && index <= lastEvenArray.length - 1) {
                lastEvenArray[index] = array[i];
                index++;
            }
        }
        int[] lastArray = new int[lastEvenArray.length];
        for (int i = 0; i < lastArray.length; i++) {
            lastArray[i] = lastEvenArray[lastEvenArray.length - 1 - i];
        }
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            if (lastArray[i] == 0) {
                continue;
            } else {
                System.out.print(lastArray[i]);
                if (i < count - 1) {
                    System.out.print("," + " ");
                }
            }
        }
        System.out.print("]");
        System.out.println();
    }
    public static void getLastEvenElement(int[] array, int count) {
        int[] lastOddArray = new int[count];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0 && index <= lastOddArray.length - 1) {
                lastOddArray[index] = array[i];
                index++;
            }
        }
        int[] lastArray = new int[lastOddArray.length];
        for (int i = 0; i < lastArray.length; i++) {
            lastArray[i] = lastOddArray[lastOddArray.length - 1 - i];
        }
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            if (lastArray[i] == 0) {
                continue;
            } else {
                System.out.print(lastArray[i]);
                if (i < count - 1) {
                    System.out.print("," + " ");
                }
            }
        }
        System.out.print("]");
        System.out.println();
    }
}

