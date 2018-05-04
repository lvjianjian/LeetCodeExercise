/**
 * Created by zhongjianlv on 18-4-1.
 * <p>
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * <p>
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * <p>
 * 示例 1:
 * <p>
 * 输入: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出: True
 * 解释:
 * 1234
 * 5123
 * 9512
 * <p>
 * 在上面这个矩阵中, 对角线分别是 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", 各条对角线上的所有元素都相同, 因此答案是True。
 * 示例 2:
 * <p>
 * 输入: matrix = [[1,2],[2,2]]
 * 输出: False
 * 解释:
 * 对角线, 比如: "[1, 2]" 上有不同的元素。
 * 注意:
 * <p>
 * matrix (矩阵)是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 */
public class Toeplitz_Matrix_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        if (r == 1 || c == 1) return true;
        int n = r + c - 1;
        int s = r - 1;
        int i, j;
        while (n-- > 0) {
            i = s;
            j = 0;
            while (j < c) {
                if (j >= 1 && i >= 1 && i < r)
                    if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
                ++i;
                ++j;
            }
            --s;
        }
        return true;
    }
}
