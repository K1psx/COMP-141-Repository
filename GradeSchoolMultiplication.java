import java.util.Arrays;

public class GradeSchoolMultiplication {
    private static final int DEFAULT_BASE = 10;

    //* main sets the arrays for x and y as well as the Default_Base,
    //* and also the product using the multiply method.
    //
    //* It also prints the result as a string modeled in the form of the array.
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};
        int[] y = {5, 6, 7, 8};
        int base = 10;
        int[] product = multiply(x, y, base);
        System.out.println(Arrays.toString(product));
    }
    //* multiplty begins by taking the length for x and y using .length and then creating
    //* a new array named result, and then uses the length of x and y added together to make
    //* the array the same length.
    //
    //* In the new array all values are automaticly set to 0: result = {0, 0, 0, 0, 0, 0, 0}
    //
    //* 
    public static int[] multiply(final int[] x, final int[] y, final int base) {
        int xLength = x.length;
        int yLength = y.length;
        int[] result = new int[xLength + yLength];

        for (int i = xLength - 1; i >= 0; i--) {
            for (int j = yLength - 1; j >= 0; j--) {

            }
        } // method multiply

        public static int[] multiply ( final int[] x, final int[] y){
            return multiply(x, y, DEFAULT_BASE);
        } // method multiply
    }
}