import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-15.
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class N_Queens_51 {
    public List<List<String>> solveNQueens(int n) {
        int[] c_valid = new int[n];
        int[] rt_valid = new int[2 * n - 1];
        int[] lt_valid = new int[2 * n - 1];
        List<List<String>> result = new LinkedList<>();
        List<String> r = new ArrayList<>();
        helper(c_valid, rt_valid, lt_valid, 0, result, r);
        return result;
    }

    private void helper(int[] c_valid, int[] rt_valid, int[] lt_valid, int i, List<List<String>> result,List<String> r) {
        if (i == c_valid.length) {
            List<String> one = new LinkedList<>(r);
            result.add(one);
            return;
        }

        for (int j = 0; j < c_valid.length; ++j) {
            int c = j;
            int rt = i + j;
            int lt = i - j + c_valid.length - 1;
            if (c_valid[c] == 0 && rt_valid[rt] == 0 && lt_valid[lt] == 0) {
                int old_c = c_valid[c];
                int old_rt = rt_valid[rt];
                int old_lt = lt_valid[lt];
                StringBuilder sb = new StringBuilder();
                for(int k = 0;k < c;++k)
                    sb.append(".");
                sb.append("Q");
                for(int k = c+1; k < c_valid.length;++k)
                    sb.append(".");
                r.add(sb.toString());
                c_valid[c] = 1;
                rt_valid[rt] = 1;
                lt_valid[lt] = 1;
                helper(c_valid, rt_valid, lt_valid, i + 1, result,r);
                c_valid[c] = old_c;
                rt_valid[rt] = old_rt;
                lt_valid[lt] = old_lt;
                r.remove(r.size() - 1);
            }
        }
    }
}
