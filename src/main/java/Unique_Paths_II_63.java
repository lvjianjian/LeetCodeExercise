/**
 * Created by zhongjianlv on 18-1-17.
 * <p>
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class Unique_Paths_II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] r = new int[m][n];
        for(int i = 0;i < m;++i)
            if(obstacleGrid[i][0] == 1){
                r[i++][0] = 0;
                while(i < m)
                    r[i++][0] = 0;
            }
            else
                r[i][0] = 1;

        for(int i=0;i<n;++i)
            if(obstacleGrid[0][i] == 1){
                r[0][i++] = 0;
                while(i < n) r[0][i++] = 0;
            }
            else
                r[0][i] = 1;

        for(int i = 1; i <= m + n - 3; ++i){
            int x = 1;
            int y = i;
            while(x < m && y > 0){
                if(y < n){
                    if(obstacleGrid[x][y] == 1)
                        r[x][y] = 0;
                    else
                        r[x][y] = r[x-1][y] + r[x][y-1];
                }
                ++x;
                --y;
            }
        }
        return r[m-1][n-1];

    }
}
