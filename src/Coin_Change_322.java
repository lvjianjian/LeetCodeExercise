import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-4-9.
 * <p>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Coin_Change_322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] res = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            int temp = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if ((i - coins[j]) == 0 || res[i - coins[j]] > 0)
                        if (temp == -1)
                            temp = res[i - coins[j]];
                        else
                            temp = Math.min(temp, res[i - coins[j]]);
                }
            }
            res[i] = temp + 1;
        }
        if (res[amount] == 0) return -1;
        return res[amount];
    }
}
