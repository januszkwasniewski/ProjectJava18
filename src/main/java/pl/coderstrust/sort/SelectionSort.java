package pl.coderstrust.sort;


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


    public static int[] sort(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int maximumIndex = findMaximumIndex(array, i);

            int maxValue = array[maximumIndex];

            sortedArray[i] = maxValue;

            int currentValue = array[i];
            array[i] = maxValue;
            array[maximumIndex] = currentValue;
        }
        return sortedArray;
    }

    public static int findMaximumIndex(int[] array, int current) {
        int indexOfCurrentMaximumValue = current;

        for (int i = current; i < array.length; i++) {
            if (array[i] > array[indexOfCurrentMaximumValue]) {
                indexOfCurrentMaximumValue = i;
            }
        }
        return indexOfCurrentMaximumValue;
    }


}
