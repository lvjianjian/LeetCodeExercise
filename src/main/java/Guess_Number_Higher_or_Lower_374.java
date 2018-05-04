/**
 * Created by zhongjianlv on 18-3-30.
 * 我们正在玩猜数游戏。 游戏如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个号码。
 * 每次你猜错了，我会告诉你这个数字是高还是低。
 * 你调用一个预定义的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较低
 * 1 : 我的数字比较高
 * 0 : 恭喜！你猜对了！
 * 案例:
 * <p>
 * n = 10, 我选择 6.
 * <p>
 * 返回 6.
 */
public class Guess_Number_Higher_or_Lower_374 {
    public int guessNumber(int n) {
        int l = 1, h = n, mid, guess;
        while (l <= h) {
            mid = l + ((h - l) >> 2);
            guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess == -1) h = mid - 1;
            else l = mid + 1;
        }
        return 0;
    }

    private int guess(int mid) {
        return 0;
    }
}
