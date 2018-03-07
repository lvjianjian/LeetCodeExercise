/**
 * Created by zhongjianlv on 18-3-7.
 * <p>
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * <p>
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * <p>
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 */
public class Nim_Game_292 {
    public boolean canWinNim(int n) {
        return (n % 4) == 0 ? false : true;
    }


    //slow
    public boolean canWinNim2(int n) {
        if (n <= 3) return true;
        boolean r = false;
        boolean pre1, pre2, pre3;
        pre1 = pre2 = pre3 = true;
        for (int i = 3; i < n; ++i) {
            r = !pre1 || !pre2 || !pre3;
            pre1 = pre2;
            pre2 = pre3;
            pre3 = r;
        }
        return r;
    }
}

