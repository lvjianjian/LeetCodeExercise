/**
 * Created by zhongjianlv on 2018/5/9
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 * <p>
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */
public class Binary_Number_with_Alternating_Bits_693 {

    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        int now;
        while (n > 0) {
            n /= 2;
            now = n & 1;
            if(pre == now) return false;
            pre = now;
        }
        return true;
    }
}
