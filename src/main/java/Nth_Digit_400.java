/**
 * Created by zhongjianlv on 2018/5/14
 * <p>
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * Example 2:
 * <p>
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class Nth_Digit_400 {
    public int findNthDigit(int n) {
        int weishu = 1;
        long start = 1, end, num;
        int res = 0;
        while (true) {
            end = start * 10;
            num = end - start;
            if (n <= num * weishu) {
                int k = n / weishu;
                n -= k * weishu;
                num = start + k - 1;
                if (n != 0)
                    num += 1;
                else
                    n = weishu;
                res = (int) (num / ((long) Math.pow(10, weishu - n)) % 10);
                break;
            } else {
                n -= num * weishu;
                start = end;
                weishu++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Nth_Digit_400 nth_digit_400 = new Nth_Digit_400();
        System.out.println(nth_digit_400.findNthDigit(1));
        System.out.println(nth_digit_400.findNthDigit(10));
        System.out.println(nth_digit_400.findNthDigit(11));
        System.out.println(nth_digit_400.findNthDigit(500));
        System.out.println(nth_digit_400.findNthDigit(1000000000));
        System.out.println(nth_digit_400.findNthDigit(999999999));
    }
}
