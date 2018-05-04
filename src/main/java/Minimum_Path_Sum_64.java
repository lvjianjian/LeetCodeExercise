/**
 * Created by zhongjianlv on 18-1-17.
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Minimum_Path_Sum_64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] r = new int[m][n];
        r[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i)
            r[i][0] = grid[i][0] + r[i - 1][0];
        for (int i = 1; i < n; ++i)
            r[0][i] = grid[0][i] + r[0][i - 1];

        for (int i = 1; i <= m + n - 3; ++i) {
            int x = 1;
            int y = i;
            while (x < m && y > 0) {
                if (y < n) {
                    r[x][y] = Math.min(r[x - 1][y], r[x][y - 1]) + grid[x][y];
                }
                ++x;
                --y;
            }
        }

        return r[m - 1][n - 1];
    }
}
