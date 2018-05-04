/**
 * Created by zhongjianlv on 18-4-28.
 * <p>
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */
public class Image_Smoother_661 {

    public int[][] imageSmoother(int[][] M) {
        //边界判断
        if (M == null) return M;
        int r = M.length;
        if (r == 0) return M;
        int c = M[0].length;
        if (c == 0) return M;

        //初始化
        int[][] temp = new int[r][c];
        int[][] num = new int[r][c];
        //横向3值求和
        for (int i = 0; i < r; i++) {
            temp[i][0] = M[i][0];
            num[i][0] = 1;
            if (c > 1) {
                temp[i][0] += M[i][1];
                num[i][0] += 1;
            }
            for (int j = 1; j < c; j++) {
                temp[i][j] = temp[i][j - 1];
                num[i][j] = num[i][j - 1];
                if (j + 1 < c) {
                    temp[i][j] += M[i][j + 1];
                    num[i][j] += 1;
                }
                if (j - 2 >= 0) {
                    temp[i][j] -= M[i][j - 2];
                    num[i][j] -= 1;
                }
            }
        }


        //竖向3值求和，并求平均
        int n = 0;
        for (int i = 0; i < c; i++) {
            n = num[0][i];
            M[0][i] = temp[0][i];
            if (r > 1) {
                M[0][i] += temp[1][i];
                n += num[1][i];
            }
            M[0][i] /= n;
            for (int j = 1; j < r; j++) {
                n = num[j][i] + num[j - 1][i];
                M[j][i] = temp[j - 1][i] + temp[j][i];
                if (j + 1 < r) {
                    M[j][i] += temp[j + 1][i];
                    n += num[j + 1][i];
                }
                M[j][i] /= n;
            }
        }
        return M;
    }

    public static void main(String[] args) {
        Image_Smoother_661 image_smoother_661 = new Image_Smoother_661();
        System.out.println(image_smoother_661.imageSmoother(new int[][]{{2, 2, 3}, {4, 5, 6}, {11, 12, 103}}));
    }
}
