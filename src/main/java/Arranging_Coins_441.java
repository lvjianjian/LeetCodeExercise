/**
 * Created by zhongjianlv on 18-3-30.
 * <p>
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
public class Arranging_Coins_441 {
    public int arrangeCoins(int n) {
        int k = (int) Math.sqrt(n);
        int c = (1 + k) * k / 2;
        while (c + (k + 1) > 0 && c + (k + 1) <= n) {//注意溢出
            k += 1;
            c += k;
        }
        return k;
    }

    public static void main(String[] args) {
        Arranging_Coins_441 arranging_coins_441 = new Arranging_Coins_441();
        System.out.println(arranging_coins_441.arrangeCoins(Integer.MAX_VALUE));
    }
}
