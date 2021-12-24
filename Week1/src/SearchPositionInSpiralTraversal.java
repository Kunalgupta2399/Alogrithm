import java.util.Scanner;

public class SearchPositionInSpiralTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] matrix = new int[4][4];

        inputMatrix(matrix);
        printMatrix(matrix);

        int [] spiral = spiralFromMatrix(matrix);
        int [] spiralAnti = antiClockFromMatrix(matrix);

        printArray(spiral);

        System.out.println("Enter your element");
        int element = scanner.nextInt();
        int position = searchElement(spiralAnti , element);

        System.out.println(position);

    }
    private static int[] antiClockFromMatrix(int[][] matrix) {
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

    private static int searchElement(int[] spiral, int element) {
        for (int i = 0; i < spiral.length; i++) {
            if (spiral[i] == element){
                return i;
            }
        }
        return -1;
    }

    private static int[] spiralFromMatrix(int[][] matrix) {
        int count = matrix.length * matrix[0].length;

        int minR = 0;
        int minC = 0;

        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;

        int [] spiral = new int[count];

        int index = 0;

        while(index < count) {
            //right
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
            for (int j = maxC; j >= minC ; j--) {
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

    private static void inputMatrix(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

    }

    private static void printMatrix(int [][] matrix) {
        System.out.println("----------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("----------------");
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
