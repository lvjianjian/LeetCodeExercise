import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-16.
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Spiral_Matrix_54 {

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix.length == 0 || matrix[0].length==0)
            return result;
        int[] index = new int[]{0,1,1,0,0,-1,-1,0};
        int[] border = new int[]{0,matrix.length + 1, -1, matrix[0].length};
        helper(matrix,index,border,0,0,0,result);
        return result;
    }


    private void helper(int[][] matrix, int[] index,int[] border, int current,int i,int j, List<Integer> result){
        if(result.size() == matrix.length * matrix[0].length)
            return;
        if(i >= border[0] && j >= border[2] && i < border[1] && j < border[3]){
            result.add(matrix[i][j]);
            helper(matrix,index,border,current,i+index[current*2],j+index[current*2+1],result);
        }else{
            int newi = i-index[current*2] + index[(current+1) % 4 * 2];
            int newj = j-index[current*2+1] + index[(current+1) % 4 * 2 + 1];
            int newcurrent = (current + 1) % 4;
            int temp = (3 - newcurrent) / 2 + 1;
            border[0] += (index[temp * 2] * (newcurrent % 2));
            border[1] += (index[temp * 2 + 1] * (newcurrent % 2));
            border[2] += (index[temp * 2] * ((newcurrent +1) % 2));
            border[3] += (index[temp * 2 + 1] * ((1+newcurrent) % 2));
            helper(matrix,index,border,newcurrent,newi,newj,result);
        }

    }
}
