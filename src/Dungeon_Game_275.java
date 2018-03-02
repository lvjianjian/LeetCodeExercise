/**
 * Created by zhongjianlv on 18-3-2.
 * <p>
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 * <p>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * Notes:
 * <p>
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class Dungeon_Game_275 {

    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] min = new int[r][c];
        min[r - 1][c - 1] = Math.max(1, 1 - dungeon[r - 1][c - 1]);
        for (int i = r - 2; i >= 0; --i) {
            min[i][c-1] = Math.max(min[i + 1][c - 1] - dungeon[i][c - 1], 1);
        }

        for (int i = c - 2; i >= 0; --i) {
            min[r-1][i] = Math.max(min[r - 1][i + 1] - dungeon[r - 1][i], 1);
        }

        for (int i = r - 2; i >= 0; --i)
            for (int j = c - 2; j >= 0; --j) {
                min[i][j] = Math.max(Math.min(min[i + 1][j], min[i][j + 1]) - dungeon[i][j], 1);
            }

        return min[0][0];

    }

    public static void main(String[] args) {
        Dungeon_Game_275 dungeon_game_275 = new Dungeon_Game_275();
        System.out.println(dungeon_game_275.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-2, -3, 3},
                {-2, -3, 3},
        }));
    }
}
