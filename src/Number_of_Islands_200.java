/**
 * Created by zhongjianlv on 2018/2/12
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * <p>
 * Example 2:
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class Number_of_Islands_200 {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int r = grid.length;
        if(r == 0) return 0;
        int c = grid[0].length;
        if(c == 0) return 0;
        int count = 0;
        for(int i=0; i < r; ++i)
            for(int j = 0; j < c; ++j){
                if(grid[i][j] == '1'){
                    ++count;
                    fill(grid,i,j);
                }
            }
        return count;
    }

    private void fill(char[][] grid, int i, int j){
        if(i< 0 || j <0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            fill(grid,i+1,j);
            fill(grid,i-1,j);
            fill(grid,i,j+1);
            fill(grid,i,j-1);
        }
    }
}
