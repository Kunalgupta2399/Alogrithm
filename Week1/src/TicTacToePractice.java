import java.util.Scanner;

public class TicTacToePractice {

    static String[] matrix = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static void main(String[] args) {
        int turn = 0;
        int playAgain = -1;
        while (playAgain == -1) {
            printMatrix();
            turn = play(turn);

            playAgain = gamesEnd();
        }

        printMatrix();

        if (playAgain == 0) {
            System.out.println("Player 1(0) is winner");
        } else if (playAgain == 1) {
            System.out.println("Player 2(X) is winner");
        } else {
            System.out.println("Draw!");
        }
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


    private static int play(int turn) {
        String symbol;
        if (turn == 0) {
            symbol = "O";
        } else {
            symbol = "X";
        }
        Scanner scanner = new Scanner(System.in);
        int position;
        do {
            System.out.println("enter the position player (" + turn + ") where you want to put " + symbol);
            position = scanner.nextInt();
            if (!validPosition(position)){
                System.out.println("invalid position please enter correctly:");
            }
        } while (!validPosition(position));


//        System.out.println("Enter the position of player" + "(" + turn + ")" + "where you want to put the" + symbol);
//        int position = scanner.nextInt();
//        while (!validPosition(position)) {
//            System.out.println("invalid position please enter correctly:");
//            System.out.println("enter the position player (" + turn + ") where you want to put " + symbol);
//            position = scanner.nextInt();
//        }
        matrix[position - 1] = symbol;

        //TODO : Game Logic
        if (turn == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean validPosition(int position) {
        if (position <= 0 || position > matrix.length) {
            return false;
        }
        if (matrix[position - 1].equals("O") || matrix[position - 1].equals("X")) {
            return false;
        }
        return true;
    }

    private static int gamesEnd() {
        //0 Winner
        if (checkMatrixWinner("O")) {
            return 0;
        }
        // X Winner
        if (checkMatrixWinner("X")) {
            return 1;
        }
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

    private static boolean checkMatrixWinner(String symbol) {
        //Vertical case

        if (matrix[0].equals(symbol) && matrix[0].equals(matrix[3]) && matrix[3].equals(matrix[6])) {
            return true;
        } else if (matrix[1].equals(symbol) && matrix[1].equals(matrix[4]) && matrix[4].equals(matrix[7])) {
            return true;
        } else if (matrix[2].equals(symbol) && matrix[2].equals(matrix[5]) && matrix[5].equals(matrix[8])) {
            return true;
        }

        //horizontal cases
        if (matrix[0].equals(symbol) && matrix[0].equals(matrix[1]) && matrix[1].equals(matrix[2])) {
            return true;
        } else if (matrix[3].equals(symbol) && matrix[3].equals(matrix[4]) && matrix[4].equals(matrix[5])) {
            return true;
        } else if (matrix[6].equals(symbol) && matrix[6].equals(matrix[7]) && matrix[7].equals(matrix[8])) {
            return true;
        }

        //diagonal cases
        if (matrix[0].equals(symbol) && matrix[0].equals(matrix[4]) && matrix[4].equals(matrix[8])) {
            return true;
        } else if (matrix[2].equals(symbol) && matrix[2].equals(matrix[4]) && matrix[4].equals(matrix[6])) {
            return true;
        }


        return false;
    }
}

