/**
 * Created by zhongjianlv on 17-12-27.
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 */
public class Arithmetic_Slices_413 {


    public int numberOfArithmeticSlices(int[] A) {
        int num = 0;
        int[] ints = new int[A.length];
        int start = 0;
        int i;
        for (i = 0; i < A.length - 2; ++i) {
            if ((A[i] - A[i + 1]) == (A[i + 1] - A[i + 2])) {
                ints[i] = 1;
                ++num;
            } else {
                int n = i - start;
                for (int j = 0; j < n; ++j)
                    num += j;
                start = i + 1;
            }
        }
        int n = i - start;
        for (int j = 0; j < n; ++j)
            num += j;
        return num;
    }
}
