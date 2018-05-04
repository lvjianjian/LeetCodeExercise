/**
 * Created by zhongjianlv on 2018/5/2
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * <p>
 * Example:
 * <p>
 * n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked.
 * <p>
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * <p>
 * 3->2
 * 4->4
 * 5->6
 * 6->8
 * 10->16
 */
public class Guess_Number_Higher_or_Lower_II_375 {

    //DP dp[i][j] = min(dp[i][j], max(k+dp[i][k-1],k+dp[k+1][j]))
    public int getMoneyAmount(int n) {
        int[][] res = new int[n + 1][n + 1];
        for (int i = 1; i <= n - 1; i++) {
            res[i][i + 1] = i;
        }
        int min;
        int end;
        for (int diff = 2; diff < n; diff++) {
            for (int i = 1; i <= n - diff; i++) {
                min = Integer.MAX_VALUE;
                end = i + diff;
                for (int j = i; j < end; j++) {
                    min = Math.min(min, Math.max(j + res[i][j - 1], j + res[j + 1][end]));
                }
                res[i][end] = min;
            }
        }
        return res[1][n];
    }

    public static void main(String[] args) {
        Guess_Number_Higher_or_Lower_II_375 guess_number_higher_or_lower_ii_375 = new Guess_Number_Higher_or_Lower_II_375();
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(2));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(3));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(4));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(5));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(6));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(8));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(10));
        System.out.println(guess_number_higher_or_lower_ii_375.getMoneyAmount(11));


    }
}
