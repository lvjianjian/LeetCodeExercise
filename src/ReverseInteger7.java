import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by zhongjian on 2017/4/5.
 * <p>
 * leetcode algorithm 7
 * <p>
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * <p>
 * Example2: x = -123, return -321
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer.
 * Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger7 {

    /**
     * 通过字符串反转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean negetive = false;
        if (x < 0)
            negetive = true;
        int r = 0;
        try {
            r = Integer.valueOf(new StringBuffer(String.valueOf(Math.abs(x))).reverse().toString());
        } catch (Exception e) {
            r = 0;
        }
        if (negetive)
            r = -r;
        return r;
    }


    /**
     * 通过取余再乘
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        int r = 0;
        List<Integer> yushu = new LinkedList<>();
        while (x != 0) {
            yushu.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < yushu.size(); i++) {
            int digit = yushu.get(i);
            //判断是否会超出int最大值范围
            if (r > Integer.MAX_VALUE / 10 || r < Integer.MIN_VALUE / 10
                    || (r == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)
                    || (r == Integer.MIN_VALUE/10 && digit < Integer.MIN_VALUE % 10)){
                return 0;
            }
            r = r * 10 + digit;
        }
        return r;
    }


    public static void main(String[] args) {
        ReverseInteger7 reverseInteger7 = new ReverseInteger7();
        System.out.println(reverseInteger7.reverse2(-12321));
    }


}
