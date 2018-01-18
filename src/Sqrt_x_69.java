/**
 * Created by zhongjianlv on 18-1-17.
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 */
public class Sqrt_x_69 {

    public int mySqrt(int x) {
        if(x==0) return 0;
        double start = 1;
        double end = Integer.MAX_VALUE;
        int mid = 1;
        while(start <= end){
            mid = (int)(start + (end - start) / 2);
            if((double)x / mid < mid){
                end = mid - 1 ;
            }else{
                if((double)x / mid < mid + 2 + (double)1 / mid) break;
                start = mid + 1;
            }
        }
        return mid;
    }

    public int mySqrt2(int x) {//牛顿法
        if(x == 0)
            return 0;
        double result = x;
        double eps = 0.00001;
        while(true){
            double last_value = result;
            result = result / 2 + x / result / 2;
            if(Math.abs(result - last_value) < eps) break;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Sqrt_x_69 sqrt_x_69 = new Sqrt_x_69();
        int x = 9;
        System.out.println(sqrt_x_69.mySqrt(x));
        System.out.println(sqrt_x_69.mySqrt2(x));
    }
}
