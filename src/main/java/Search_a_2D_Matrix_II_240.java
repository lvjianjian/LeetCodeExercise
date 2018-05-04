/**
 * Created by zhongjianlv on 18-3-11.
 * <p>
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class Search_a_2D_Matrix_II_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0) return false;
        int c = matrix[0].length;
        if(c == 0) return false;
        int i = 0;
        int j = c - 1;
        while(i < r && j >=0){
            if(matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) --j;
            else ++i;
        }
        return false;
    }

}
