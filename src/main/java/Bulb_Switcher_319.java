/**
 * Created by zhongjianlv on 18-5-10.
 * <p>
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * <p>
 * Example:
 * <p>
 * Given n = 3.
 * <p>
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 * <p>
 * So you should return 1, because there is only one bulb is on.
 */
public class Bulb_Switcher_319 {
    //对于任意一个数字n，如果i*j = n (i!=j)则仍然为关，若i*i=n,才能使n开
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    //TL
    public int bulbSwitch2(int n) {
        boolean[] flag = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                flag[j] = !flag[j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (flag[i + 1])
                res += 1;
        }
        return res;
    }
}
