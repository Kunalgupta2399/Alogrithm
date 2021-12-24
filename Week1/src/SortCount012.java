import java.util.Arrays;
import java.util.Scanner;

public class SortCount012 {

    //sort an array that contains only 3 distinct elements (0, 1, 2)
    //{1, 1, 1, 1, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 2, 2, 2, 2}
    //{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your size");
        int size = scanner.nextInt();
        int [] a = new int[size];

        inputArray(a);

        printArray(a);

        a = sort(a);

        printArray(a);
    }

    private static void inputArray(int[] a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements of the array of size " + a.length);

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
    }

    private static int [] sort(int[] a) {
        //count how many 0s, 1s and 2s are
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                count0++;
            } else if (a[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        //fill the array first with 0 then 1 then 2
        int index = 0;

//        while(count0 > 0) {
//            a[index++] = 0;
//            count0--;
//        }
//        while(count1 > 0) {
//            a[index++] = 1;
//            count1--;
//        }
//        while(count2 > 0) {
//            a[index++] = 2;
//            count2--;
//        }

        for (int i = 0; i < count0; i++) {
            a[index++] = 0;
        }

        for (int i = 0; i < count1; i++) {
            a[index++] = 1;
        }

        for (int i = 0; i < count2; i++) {
            a[index++] = 2;
        }
        //return the resulting array
        return a;
    }

    private static void printArray(int [] array) {
        System.out.println("------------------------");
        for (int element : array) {
            System.out.print(element + ", ");
        }
        System.out.println();
        System.out.println("------------------------");
    }
}
