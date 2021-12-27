public class MoveNegativeOneSide {
    public static void main(String[] args) {
        int[] array = {1, 2, -3, 4, -5, -7, -8, 9, 7};
        printArray(array);

        array = moveNegative(array);

        printArray(array);
    }

    private static int[] moveNegative(int[] array) {
        // 0nly negative
        int[] b = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                b[index++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                b[index++] = array[i];
            }
        }

        return b;

        //find space efficient solution for this
//        int index = 0;
//
//        for (int i = 1; i < array.length; i++) {
//            if(array[i] < 0) {
//                int temp = array[index];
//                array[index] = array[i];
//                array[i] = temp;
//                index++;
//            }
//        }
//
//        return array;

    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------");
    }
}


