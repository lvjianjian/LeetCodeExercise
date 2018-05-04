/**
 * Created by zhongjianlv on 2018/2/16
 * <p>
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * <p>
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class Number_of_Digit_One_233 {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        long r = 0;
        long k = 1;
        long old = 0;
        do{
            old = k;
            k *= 10;
            r += (n / k * old);
            r += Math.max(0,Math.min(old, n % k - old + 1));
        }while(n / k != 0);
        return (int)r;
    }

    public static void main(String[] args) {
        Number_of_Digit_One_233 number_of_digit_one_233 = new Number_of_Digit_One_233();
        System.out.println(number_of_digit_one_233.countDigitOne(100));
    }
}
