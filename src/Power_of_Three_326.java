/**
 * Created by zhongjianlv on 18-3-7.
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class Power_of_Three_326 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && (Math.pow(3, Math.ceil(Math.log(0x7fffffff) / Math.log(3))) % n == 0);
    }

    public boolean isPowerOfThree2(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n == 2) return false;
        long k = 3;
        while(k < n){
            k *= 3;
        }
        if(k == n) return true;
        return false;
    }
}
