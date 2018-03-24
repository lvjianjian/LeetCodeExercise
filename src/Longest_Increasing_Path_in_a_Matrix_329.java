/**
 * Created by zhongjianlv on 18-3-24.
 * <p>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2:
 * <p>
 * nums = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Longest_Increasing_Path_in_a_Matrix_329 {

    // DP，在某一点开始得到从该点出发的最长升序序列，递归找
    // 递归过程中，如果四面有比当前值大的，且已经找过的直接用数组中的值，如果没有找过，则继续递归
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
        if (c == 0) return 0;
        int[][] longest = new int[r][c];
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (longest[i][j] == 0)
                    helper(matrix, longest, i, j, r, c);
                if (longest[i][j] > max)
                    max = longest[i][j];
            }
        }
        return max;
    }

    private void helper(int[][] matrix, int[][] longest, int i, int j, int r, int c) {
        int max = 0;
        int c_value = matrix[i][j];
        int temp = helper2(matrix, longest, i - 1, j, r, c, c_value);
        if (temp > max)
            max = temp;
        temp = helper2(matrix, longest, i, j - 1, r, c, c_value);
        if (temp > max)
            max = temp;
        temp = helper2(matrix, longest, i + 1, j, r, c, c_value);
        if (temp > max)
            max = temp;
        temp = helper2(matrix, longest, i, j + 1, r, c, c_value);
        if (temp > max)
            max = temp;
        longest[i][j] = max + 1;
    }

    private int helper2(int[][] matrix, int[][] longest, int tempi, int tempj, int r, int c, int c_value) {
        if (tempi >= 0 && tempi < r && tempj >= 0 && tempj < c && matrix[tempi][tempj] > c_value) {
            if (longest[tempi][tempj] == 0)
                helper(matrix, longest, tempi, tempj, r, c);
            return longest[tempi][tempj];
        } else return 0;
    }


}