/**
 * Created by zhongjianlv on 2018/2/23
 * <p>
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Rotate_Image_48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            for (int k = 0; k < n; ++k) {
                matrix[k][i] ^= matrix[k][j];
                matrix[k][j] ^= matrix[k][i];
                matrix[k][i] ^= matrix[k][j];
            }
            ++i;
            --j;
        }

        for (i = 0; i < n - 1; ++i) {
            for (j = 0; j < n - i - 1; ++j) {
                matrix[i][j] ^= matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[n - j - 1][n - i - 1];
            }
        }
    }
}
