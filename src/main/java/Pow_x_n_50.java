/**
 * Created by zhongjianlv on 18-1-11.
 * <p>
 * Implement pow(x, n).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 */
public class Pow_x_n_50 {

    public double myPow3(double x, int n) {
        if (x == 0) {
            return 0D;
        }

        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (n > 0) {
                    result *= x;
                } else {
                    result /= x;
                }
            }
            x *= x;
            n /= 2;
        }

        return result;
    }

    public int max_pow = 5;

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (x == 1) return 1;


        double[] doubles = new double[max_pow];
        boolean flag = false;
        if (n < 0) {
            if( n == Integer.MIN_VALUE){
                flag = true;
                n = Integer.MAX_VALUE;
            }else {
                flag = true;
                n = -n;
            }
        }
        double r = 1.0;
        for (int i = 0; i < max_pow; i++) {
            doubles[i] = r * x;
            r = doubles[i];
        }

        if (flag)
            if(n == Integer.MAX_VALUE)
                return 1 / helper(x,n,doubles) / x;
            else
                return 1 / helper(x, n, doubles);
        else
            return helper(x, n, doubles);
    }

    private double helper(double x, int n, double[] values) {
        if (n <= max_pow)
            return values[n - 1];
        else {
            int temp = n / 2;
            int temp2 = n % 2;
            double r = helper(x, temp, values);
            if (temp2 == 1)
                r = r * r * x;
            else
                r = r * r;
            return r;
        }
    }

    public double myPow2(double x, int n) {//超时
        double r = 1.0;
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        for (int i = 0; i < n; ++i)
            r *= x;
        if (flag)
            r = 1 / r;
        return r;
    }

    public static void main(String[] args) {
        Pow_x_n_50 pow_x_n_50 = new Pow_x_n_50();
        System.out.println(pow_x_n_50.myPow(2, -2147483648));

        for (int n = -10; n < 10; n++) {
            System.out.println((n%2) == (n&1));
        }


    }
}
