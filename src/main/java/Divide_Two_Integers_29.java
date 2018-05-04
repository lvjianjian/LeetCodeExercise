/**
 * Created by zhongjianlv on 18-1-22.
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class Divide_Two_Integers_29 {
    public int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;

        if(dividend == Integer.MIN_VALUE)
            if(divisor == -1)
                return Integer.MAX_VALUE;
            else if(divisor == Integer.MIN_VALUE)
                return 1;

        if(divisor == Integer.MIN_VALUE)
            return 0;

        boolean negetive = false;
        boolean yichu = false;
        if(dividend < 0){
            negetive = !negetive;
            if(dividend == Integer.MIN_VALUE){
                dividend = Integer.MAX_VALUE;
                yichu = true;
            }else
                dividend = -dividend;
        }
        if(divisor < 0){
            negetive = !negetive;
            divisor = -divisor;
        }
        if(dividend < divisor) return 0;
        int origin = divisor;
        int current = 1;
        while(dividend - divisor >= divisor){
            divisor = divisor + divisor;
            current = current + current;

        }
        int num = current;
        dividend = dividend - divisor;
        if(yichu)
            dividend +=1;
        if(dividend == divisor)
            num += num;
        else {
            current >>= 1;
            divisor >>= 1;
            while (dividend > 0 && divisor >= origin) {
                if (dividend - divisor >= 0) {
                    dividend -= divisor;
                    num += current;
                }
                current >>= 1;
                divisor >>= 1;

            }
        }
        if(negetive)
            num = -num;
        return num;
    }

    public static void main(String[] args) {
        Divide_Two_Integers_29 divide_two_integers_29 = new Divide_Two_Integers_29();
        System.out.println(divide_two_integers_29.divide(Integer.MIN_VALUE,2));
        System.out.println(Integer.MAX_VALUE);
    }
}
