/**
 * Created by zhongjianlv on 18-1-11.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Climbing_Stairs_70 {

    public int climbStairs(int n) {// time limited
        if(n <=2)
            return n;
        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] =2;
        for (int i = 2; i < n; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[n-1];
    }


    public int climbStairs2(int n) {// time limited
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else return climbStairs2(n-1) + climbStairs2(n-2);
    }
}
