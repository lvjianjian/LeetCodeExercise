/**
 * Created by zhongjianlv on 18-1-16.
 * <p>
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Spiral_Matrix_II_59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int current = 1;
        int row_start = 0;
        int row_end = n-1;
        int col_start = 0;
        int col_end = n-1;
        while(row_start <= row_end){
            for(int i = col_start; i <= col_end; ++i){
                result[row_start][i] = current++;
            }
            ++row_start;

            for(int i = row_start;i <= row_end;++i)
                result[i][col_end] = current++;
            --col_end;

            for(int i = col_end; i >= col_start; --i)
                result[row_end][i] = current++;
            --row_end;

            for(int i = row_end; i >= row_start; --i)
                result[i][col_start] = current++;
            ++col_start;
        }
        return result;
    }
}
