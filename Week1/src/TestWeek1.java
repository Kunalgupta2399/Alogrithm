import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestWeek1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //take input for row and column
        //create a matrix and print the same
        //create a function to get the elements of the matrix when travelled in spiral(spriral1) fashion in anti-clockwise
        //create a function to get the elements of the matrix when travelled in spiral(spriral2) fashion in clockwise
        //find the union and intersection of spiral1 and spiral2
        System.out.println("Enter you row size");
        int row = scanner.nextInt();
        System.out.println("Enter you column size");
        int column = scanner.nextInt();
        int[][] matrix = new int[row][column];

        inputMatrix(matrix);
        printMatrix(matrix);

        int[] spiral2 = clockwise(matrix);
        printArray(spiral2);

        int[] spiral = antiClockwise(matrix);
        printArray(spiral);

        int[] a = spiral2;
        int[] b = spiral;

        Object[] union = unionOfArray(a, b);
        Object[] intersection = intersectionOfArray(a, b);

        print(union);
        print(intersection);

    }

    private static void print(Object[] a) {
        System.out.println("-------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        System.out.println("---------");
    }

    private static Object[] intersectionOfArray(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int element : a) {
            set.add(element);
        }

        for (int element : b) {
            if (set.contains(element)) {
                intersection.add(element);
            }
        }
        return intersection.toArray();
    }

    private static Object[] unionOfArray(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();

        for (int element : a) {
            set.add(element);
        }

        for (int element : b) {
            set.add(element);
        }
        return set.toArray();
    }

    private static int[] clockwise(int[][] matrix) {
        int count = matrix.length * matrix[0].length;

        int minR = 0;
        int minC = 0;

        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;

        int[] spiral = new int[count];

        int index = 0;

        while (index < count) {
            // right

            for (int j = minC; j <= maxC; j++) {
                spiral[index++] = matrix[minR][j];
            }
            minR++;

            //down

            for (int i = minR; i <= maxR; i++) {
                spiral[index++] = matrix[i][maxC];
            }
            maxC--;

            //left

            for (int j = maxC; j >= minC; j--) {
                spiral[index++] = matrix[maxR][j];
            }
            maxR--;

            //up

            for (int i = maxR; i >= minR; i--) {
                spiral[index++] = matrix[i][minC];
            }
            minC++;
        }
        return spiral;
    }

    private static void printArray(int[] spiral) {
        for (int i = 0; i < spiral.length; i++) {
            System.out.print(spiral[i] + " ,");
        }
        System.out.println();
    }

    private static int[] antiClockwise(int[][] matrix) {
        int count = matrix.length * matrix[0].length;

        int minR = 0;
        int minC = 0;

        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;

        int[] spiral = new int[count];

        int index = 0;

        while (index < count) {

            //down

            for (int i = minR; i <= maxR; i++) {
                spiral[index++] = matrix[i][minC];
            }
            minC++;

            //right

            for (int j = minC; j <= maxC; j++) {
                spiral[index++] = matrix[maxR][j];
            }
            maxR--;


            //up

            for (int i = maxR; i >= minR; i--) {
                spiral[index++] = matrix[i][maxC];
            }
            maxC--;


            //left

            for (int j = maxC; j >= minC; j--) {
                spiral[index++] = matrix[minR][j];
            }
            minR++;

        }
        return spiral;
    }

    private static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        System.out.println("----------");
        System.out.println("Your elements are :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    private static void inputMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        System.out.println("Enter your Elements");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
