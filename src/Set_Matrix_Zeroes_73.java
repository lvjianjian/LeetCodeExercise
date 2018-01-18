import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongjianlv on 18-1-18.
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Set_Matrix_Zeroes_73 {


    // 可以将记录放在第一行和第一列上，不过先要判断第一行和第一列是否为0行/列
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0;i<r;++i)
            for(int j =0; j < c ;++j)
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }

        for(int i: rows)
            for(int j =0;j<c;++j)
                matrix[i][j] = 0;

        for(int j: cols)
            for(int i =0;i<r;++i)
                matrix[i][j] = 0;
    }
}
