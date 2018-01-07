/**
 * Created by zhongjianlv on 18-1-7.
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * Example:
 * <p>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class Island_Perimeter_463 {
    public int islandPerimeter(int[][] grid) { //只需要判断上面+左面,
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        r += 2;
                    if (j == 0 || grid[i][j - 1] == 0)
                        r += 2;
                }
            }
        }
        return r;
    }

    public int islandPerimeter3(int[][] grid) {
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        ++r;
                    if (i == grid.length - 1 || grid[i + 1][j] == 0)
                        ++r;
                    if (j == 0 || grid[i][j - 1] == 0)
                        ++r;
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0)
                        ++r;
                }
            }
        }
        return r;
    }

    public int islandPerimeter2(int[][] grid) {
        int[] r = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j, r);
                    return r[0];
                }
            }
        }
        return r[0];
    }


    private void helper(int[][] grid, int i, int j, int[] result) {
        if (grid[i][j] != 1)
            return;
        if (i - 1 < 0 || grid[i - 1][j] == 0)
            ++result[0];
        if (i + 1 >= grid.length || grid[i + 1][j] == 0)
            ++result[0];
        if (j - 1 < 0 || grid[i][j - 1] == 0)
            ++result[0];
        if (j + 1 >= grid[0].length || grid[i][j + 1] == 0)
            ++result[0];
        grid[i][j] = -1;
        if (i - 1 >= 0)
            helper(grid, i - 1, j, result);
        if (i + 1 < grid.length)
            helper(grid, i + 1, j, result);
        if (j - 1 >= 0)
            helper(grid, i, j - 1, result);
        if (j + 1 < grid[0].length)
            helper(grid, i, j + 1, result);
    }

    public static void main(String[] args) {

    }

}
