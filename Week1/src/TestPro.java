import java.util.Scanner;

public class TestPro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Array Insert At end
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.printf("Enter the element you want to insert at end of array");
        int element = scanner.nextInt();
        print(array);
        array = insertEnd(array, element);
        print(array);

    }

    private static int[] insertEnd(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + "--" + array[i]);
        }
        System.out.printf("+*+****++*+*+*+*+*");
    }
}
