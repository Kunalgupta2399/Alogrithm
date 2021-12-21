public class MinMaxArray {

    static class Node {
        int min;
        int max;
    }

    public static void main(String[] args) {
        int [] a = {12, 3, -45, 66, 677, 87};

        printArray(a);

//        int min = minFromArray(a);
//        int max = maxFromArray(a);

        Node node = minMaxArray(a);

        System.out.println("min = " + node.min);
        System.out.println("max = " + node.max);
    }

    private static Node minMaxArray(int[] a) {
        Node node = new Node();
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            }
            if(min > a[i]) {
                min = a[i];
            }
        }

        node.max = max;
        node.min = min;

        return node;
    }

    private static int maxFromArray(int[] a) {
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }

        return max;
    }

    private static int minFromArray(int[] a) {
        int min = a[0];

        for (int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
            }
        }

        return min;
    }

    private static void printArray(int[] a) {

        for (int element : a) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}
