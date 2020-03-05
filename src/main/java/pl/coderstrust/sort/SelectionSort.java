package pl.coderstrust.sort;


import java.util.Arrays;

/**
 * Posortować tablicę (malejąco): (14, 123, 54, 65, 46, 1, 26) -> (123, 65, 54, 46, 26, 14, 1)
 * <p>
 * <p>
 * <p>
 * input = (14, 123, 54, 65, 46, 1, 26)
 * sortedOutput = ()
 * <p>
 * for (each element in input) {
 * maximum = findMaximumValue(input)
 * <p>
 * sortedOutput.add(maximum)
 * <p>
 * input.delete(maximum)
 * }
 */
public class SelectionSort {


    public static void main(String[] args) {
        int[] array = {14, 123, 54, 65, 46, 1, 26};

        System.out.println(Arrays.toString(array));

        int[] result = sort(array);

        System.out.println(Arrays.toString(result));


    }


    public static int[] sort(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int maximumIndex = findMaximumIndex(array);

            sortedArray[i] = array[maximumIndex];

            array[maximumIndex] = 0;

        }


        return sortedArray;
    }

    public static int findMaximumIndex(int[] array) {
        int indexOfCurrentMaximumValue = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[indexOfCurrentMaximumValue]) {
                indexOfCurrentMaximumValue = i;
            }
        }
        return indexOfCurrentMaximumValue;
    }
}
