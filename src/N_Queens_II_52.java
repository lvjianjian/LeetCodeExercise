/**
 * Created by zhongjianlv on 18-1-15.
 * Follow up for N-Queens problem.
 * <p>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class N_Queens_II_52 {

    public int totalNQueens(int n) {
        int[] c_valid = new int[n];
        int[] rt_valid = new int[2 * n - 1];
        int[] lt_valid = new int[2 * n - 1];
        int[] result = new int[1];
        helper(c_valid, rt_valid, lt_valid, 0, result);
        return result[0];
    }

    private void helper(int[] c_valid, int[] rt_valid, int[] lt_valid, int i, int[] result) {
        if (i == c_valid.length) {
            ++result[0];
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
                c_valid[c] = 1;
                rt_valid[rt] = 1;
                lt_valid[lt] = 1;
                helper(c_valid, rt_valid, lt_valid, i + 1, result);
                c_valid[c] = old_c;
                rt_valid[rt] = old_rt;
                lt_valid[lt] = old_lt;
            }
        }
    }
}
