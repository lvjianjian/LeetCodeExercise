/**
 * Created by zhongjianlv on 18-1-19.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Search_a_2D_Matrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0) return false;
        int c = matrix[0].length;
        if(c == 0) return false;
        int i = 0;
        int j = r-1;
        int mid = 0;
        while(i <= j){
            mid = (i+j)/2;
            if(matrix[mid][0] == target)
                return true;
            else if(matrix[mid][0] < target)
                i = mid +1;
            else
                j = mid -1;
        }
        if(matrix[mid][0] > target && mid > 0)
            --mid;

        i = 0;
        j = c-1;
        while(i <= j){
            int mid2 = (i+j)/2;
            if(matrix[mid][mid2] == target)
                return true;
            else if(matrix[mid][mid2] < target)
                i = mid2 + 1;
            else
                j = mid2 - 1;
        }
        return false;
    }

}
