import java.util.Scanner;

public class TicTacToe {

    static String[] matrix = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static void main(String[] args) {
        int turn = 0; //turn {0 - first player, 1 - second player}
        int playAgain = -1;
        while (playAgain == -1) {
            printMatrix();
            turn = play(turn);

            playAgain = gameEnds();
        }

        printMatrix();

        if (playAgain == 0) {
            System.out.println("player 1 (O) is winner");
        } else if (playAgain == 1) {
            System.out.println("player 2 (X) is winner");
        } else {
            System.out.println("Draw!");
        }
    }

    private static int gameEnds() {
        //O wins
        if (checkMatrixWinner("O") == 0) {
            return 0;
        }

        //X wins
        if (checkMatrixWinner("X") == 1) {
            return 1;
        }

        //Draw
        if (MatrixDraw()) {
            return 2;
        }

        //none
        return -1;
    }

    private static boolean MatrixDraw() {
        for (int i = 0; i < 9; i++) {
            if (matrix[i].equals(String.valueOf(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static int checkMatrixWinner(String symbol) {
        System.out.println(symbol + " is checking.");
        boolean wins = false;

        //vertical cases
        if (matrix[0].equals(symbol) && matrix[0].equals(matrix[3]) && matrix[3].equals(matrix[6])) {
            wins = true;
        } else if (matrix[1].equals(symbol) && matrix[1].equals(matrix[4]) && matrix[4].equals(matrix[7])) {
            wins = true;
        } else if (matrix[2].equals(symbol) && matrix[2].equals(matrix[5]) && matrix[5].equals(matrix[8])) {
            wins = true;
        }

        //horizontal cases
        if (matrix[0].equals(symbol) && matrix[0].equals(matrix[1]) && matrix[1].equals(matrix[2])) {
            wins = true;
        } else if (matrix[3].equals(symbol) && matrix[3].equals(matrix[4]) && matrix[4].equals(matrix[5])) {
            wins = true;
        } else if (matrix[6].equals(symbol) && matrix[6].equals(matrix[7]) && matrix[7].equals(matrix[8])) {
            wins = true;
        }

        //diagonal cases
        if (matrix[0].equals(symbol) && matrix[0].equals(matrix[4]) && matrix[4].equals(matrix[8])) {
            wins = true;
        } else if (matrix[2].equals(symbol) && matrix[2].equals(matrix[4]) && matrix[4].equals(matrix[6])) {
            wins = true;
        }

        if (wins) {
            if (symbol.equals("O")) {
                System.out.println("here");
                return 0;
            } else {
                return 1;
            }
        }

        return -1;
    }

    private static int play(int turn) {
        String symbol;
        if (turn == 0) {
            symbol = "O";
        } else {
            symbol = "X";
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the position player (" + turn + ") where you want to put " + symbol);
        int position = scanner.nextInt();

        while (!validPosition(position)) {
            System.out.println("invalid position please enter correctly:");
            System.out.println("enter the position player (" + turn + ") where you want to put " + symbol);
            position = scanner.nextInt();
        }

        matrix[position - 1] = symbol;

        // TODO: game logic

        if (turn == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean validPosition(int position) {
        if (position < 0 || position > matrix.length) {
            return false;
        }

        if (matrix[position - 1].equals("O") || matrix[position - 1].equals("X")) {
            return false;
        }

        return true;
    }

    private static void printMatrix() {
        System.out.println("-----------");
        System.out.println("-----------");
        System.out.println(" " + matrix[0] + " | " + matrix[1] + " | " + matrix[2]);
        System.out.println("-----------");
        System.out.println(" " + matrix[3] + " | " + matrix[4] + " | " + matrix[5]);
        System.out.println("-----------");
        System.out.println(" " + matrix[6] + " | " + matrix[7] + " | " + matrix[8]);
        System.out.println("-----------");
        System.out.println("-----------");
    }
}
