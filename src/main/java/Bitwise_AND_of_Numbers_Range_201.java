/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * For example, given the range [5, 7], you should return 4.
 */
public class Bitwise_AND_of_Numbers_Range_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int r = 0;
        while(m != 0){
            int base = 1;
            while(base <= m && base != Integer.MIN_VALUE){
                base <<= 1;
            }
            if(base != Integer.MIN_VALUE){
                if(n >= base) break;
            }
            base >>>= 1;
            r += base;
            m -= base;
            n -= base;
        }
        return r;
    }
}
