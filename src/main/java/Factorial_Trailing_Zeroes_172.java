/**
 * Created by zhongjianlv on 2018/2/14
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 */
public class Factorial_Trailing_Zeroes_172 {
    public int trailingZeroes(int n) {
        int r = 0;
        while(n!=0){
            n /= 5;
            r += n;
        }
        return r;
    }
}
