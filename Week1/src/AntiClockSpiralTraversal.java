import java.util.Scanner;

public class AntiClockSpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];

        inputMatrix(matrix);
        printMatrix(matrix);

        int[] spiral = AntiClockFromMatrix(matrix);

        printArray(spiral);
    }

    private static int[] AntiClockFromMatrix(int[][] matrix) {
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


    private static void inputMatrix(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("----------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("----------------");
    }

    private static void printArray(int[] array) {
        System.out.println("------------------------");
        for (int element : array) {
            System.out.print(element + ", ");
        }
        System.out.println();
        System.out.println("------------------------");
    }
}
