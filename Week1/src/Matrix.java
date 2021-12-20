import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your row");
        int row = scanner.nextInt();

        System.out.println("Enter you column");
        int column = scanner.nextInt();

        int[][] a = new int[row][column];
        inputMatrix(a);

        System.out.println("Enter Your row");
        row = scanner.nextInt();

        System.out.println("Enter Your column");
        column = scanner.nextInt();

        int[][] b = new int[row][column];
        inputMatrix(b);

        displayMatrix(a);
        displayMatrix(b);

        int[][] c = multiply(a, b);
        displayMatrix(c);

    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int rowA = a.length;
        int columnA = a[0].length;
        int rowB = b.length;
        int columnB = b[0].length;
        if (columnA != rowB) {
            System.out.println("can't multiply");
            return null;
        } else {
            int[][] c = new int[rowA][columnB];

            for (int i = 0; i < rowA; ++i) {
                for (int j = 0; j < columnB; ++j) {
                    c[i][j] = 0;

                    for (int k = 0; k < columnA; ++k) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            return c;
        }
    }

    private static void displayMatrix(int[][] a) {
        int row = a.length;
        int column = a[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                System.out.print(a[i][j] + ", ");
            }

            System.out.println();
        }
    }

    private static void inputMatrix(int[][] a) {
        System.out.println("Enter elements of matrix: ");
        Scanner scanner = new Scanner(System.in);
        int row = a.length;
        int coloum = a[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < coloum; ++j) {
                a[i][j] = scanner.nextInt();
            }
        }
    }
}
