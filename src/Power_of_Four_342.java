/**
 * Created by zhongjianlv on 18-3-8.
 * <p>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class Power_of_Four_342 {
    public boolean isPowerOfFour(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
