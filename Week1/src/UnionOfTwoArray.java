import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArray {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 7, 9};
        int[] b = {2, 4, 6, 7, 8, 10};

        //union = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        //intersection = {4, 7}

        Object[] union = unionOfArrays(a, b);
        Object[] intersection = intersectionOfArrays(a, b);

        printArray(union);
        printArray(intersection);
    }

    private static void printArray(Object[] array) {
        System.out.println("------------------");
        for (Object element : array) {
            System.out.print(element + "  ");
        }
        System.out.println();
        System.out.println("------------------");
    }

    private static Object[] unionOfArrays(int[] a, int[] b) {

        Set<Integer> set = new HashSet<>();

        for (int element : a) {
            set.add(element);
        }

        for (int element : b) {
            set.add(element);
        }

        return set.toArray();
    }

    private static Object[] intersectionOfArrays(int[] a, int[] b) {
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
}
