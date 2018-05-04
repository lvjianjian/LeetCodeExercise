/**
 * Created by zhongjianlv on 18-1-14.
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 */
public class Sudoku_Solver_37 {
    public void solveSudoku(char[][] board) {
        int[][] r_valid = new int[9][9];
        int[][] c_valid = new int[9][9];
        int[][] g_valid = new int[9][9];

        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                if (board[i][j] != '.') {
                    r_valid[i][board[i][j] - '1'] = 1;
                    c_valid[j][board[i][j] - '1'] = 1;
                    g_valid[i / 3 * 3 + j / 3][board[i][j] - '1'] = 1;
                }
        boolean[] finish = new boolean[1];
        helper(board, r_valid, c_valid, g_valid, 0, 0, finish);
    }


    private void helper(char[][] board, int[][] r_valid, int[][] c_valid, int[][] g_valid, int i, int j, boolean[] finish) {
        if (i == 9)
            finish[0] = true;
        if (finish[0] == true)
            return;

        int r = i;
        int c = j;
        int g = i / 3 * 3 + j / 3;

        if (board[i][j] != '.')
            helper(board, r_valid, c_valid, g_valid, i + (j + 1) / 9, (j + 1) % 9, finish);
        else
            for (int v = 1; v <= 9; ++v) {
                if (r_valid[r][v - 1] != 1 && c_valid[c][v - 1] != 1 && g_valid[g][v - 1] != 1) {
                    board[i][j] = (char) (v + '0');
                    int old_r = r_valid[r][v - 1];
                    int old_c = c_valid[c][v - 1];
                    int old_g = g_valid[g][v - 1];
                    r_valid[r][v - 1] = 1;
                    g_valid[g][v - 1] = 1;
                    c_valid[c][v - 1] = 1;
                    helper(board, r_valid, c_valid, g_valid, i + (j + 1) / 9, (j + 1) % 9, finish);

                    if (finish[0] == true)
                        return;
                    r_valid[r][v - 1] = old_r;
                    g_valid[g][v - 1] = old_g;
                    c_valid[c][v - 1] = old_c;
                    board[i][j] = '.';
                }
            }

    }


}
