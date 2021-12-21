import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        print(array);
        array = reverseArray(array);
        print(array);

        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(b);
        Collections.reverse(b);
        System.out.println(b);
    }

    private static int[] reverseArray(int[] array) {

        int left = 0;
        int right = array.length - 1;

        while(left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
