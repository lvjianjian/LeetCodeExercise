/**
 * Created by zhongjianlv on 18-1-17.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 */
public class Unique_Paths_62 {
    public int uniquePaths(int m, int n) {
        int[][] r = new int[m][n];
        for (int i = 0; i < n; ++i) r[0][i] = 1;
        for (int i = 0; i < m; ++i) r[i][0] = 1;
        int i = 1;
        while (r[m - 1][n - 1] == 0) {
            int x = 1;
            int y = i;
            while (x < m && y > 0) {
                if (y < n) r[x][y] = r[x - 1][y] + r[x][y - 1];
                ++x;
                --y;
            }
            ++i;
        }
        return r[m - 1][n - 1];
    }

}
