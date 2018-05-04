/**
 * Created by zhongjianlv on 18-3-13.
 * <p>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Integer_Break_343 {

    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int r = 1;
        while (n > 4) {
            r *= 3;
            n -= 3;
        }
        return r *= n;
    }
}
