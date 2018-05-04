/**
 * Created by zhongjianlv on 18-3-29.
 * <p>
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class Range_Sum_Query_2D_Immutable_304 {

    private int[][] sum;
    private boolean valid = false;
    private boolean byRow = true;

    public Range_Sum_Query_2D_Immutable_304(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) return;
        int c = matrix[0].length;
        if (c == 0) return;
        if (r <= c) {
            sum = new int[r][c + 1];
            for (int i = 0; i < r; i++) {
                for (int j = c - 1; j >= 0; j--) {
                    sum[i][j] = sum[i][j + 1] + matrix[i][j];
                }
            }
            byRow = true;
        } else {
            sum = new int[c][r + 1];
            for (int i = 0; i < c; i++) {
                for (int j = r - 1; j >= 0; j--) {
                    sum[i][j] = sum[i][j + 1] + matrix[j][i];
                }
            }
            byRow = false;
        }
        valid = true;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (!valid) return 0;
        int sum = 0;
        if (byRow) {
            for (int i = row1; i <= row2; i++) {
                sum += (this.sum[i][col1] - this.sum[i][col2 + 1]);
            }
        } else {
            for (int i = col1; i <= col2; i++) {
                sum += (this.sum[i][row1] - this.sum[i][row2 + 1]);
            }
        }
        return sum;
    }
}

//public class Range_Sum_Query_2D_Immutable_304 {
//
//    private int[][] sum;
//    private boolean valid = false;
//    public Range_Sum_Query_2D_Immutable_304(int[][] matrix) {
//        int r = matrix.length;
//        if(r == 0) return;
//        int c = matrix[0].length;
//        if(c == 0) return;
//        sum = new int[r][c + 1];
//        for (int i = 0; i < r; i++) {
//            for (int j = c - 1; j >= 0; j--) {
//                sum[i][j] = sum[i][j + 1] + matrix[i][j];
//            }
//        }
//        valid = true;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if(!valid) return 0;
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            sum += (sum[i][col1] - sum[i][col2 + 1]);
//        }
//        return sum;
//    }
//}
