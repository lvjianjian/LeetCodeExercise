/**
 * Created by zhongjianlv on 18-1-3.
 * <p>
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class Max_Area_of_Island_695 {


    // 向4个方向深度优先遍历，为1的话继续遍历
    //为1的访问过后设置为0,表示访问过了，so 巧妙
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] != 0) {
                    int num = helper(grid, i, j);
                    if (num > max)
                        max = num;
                }
            }
        }
        return max;
    }


    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length)
            return 0;
        if (j < 0 || j >= grid[0].length)
            return 0;
        if(grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return 1 + helper(grid, i - 1, j) + helper(grid, i + 1, j) +
                helper(grid, i, j - 1) + helper(grid, i, j + 1);

    }

}
