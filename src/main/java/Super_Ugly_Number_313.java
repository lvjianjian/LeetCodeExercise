import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by zhongjianlv on 18-5-8.
 * <p>
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * <p>
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 10e6, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class Super_Ugly_Number_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int length = primes.length;
        int[] idx = new int[length];
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }

            for (int j = 0; j < length; j++) {
                if (ugly[i] >= primes[j] * ugly[idx[j]]) idx[j]++;
            }
        }
        return ugly[n - 1];
    }

}
