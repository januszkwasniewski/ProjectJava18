package pl.coderstrust.maximum;

public class FindMaximum {

    public int find(int[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException();
        }

        int max = 0;
        for (int i : input) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
