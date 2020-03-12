package pl.coderstrust.odd;

public class Numbers {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }


    public static int printTable(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("You cannot use negative number");
        }
        return 0;
    }
}
