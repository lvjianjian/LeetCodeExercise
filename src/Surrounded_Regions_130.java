/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Surrounded_Regions_130 {
    public void solve(char[][] board) {
        if(board == null) return;
        int r = board.length;
        if(r == 0) return;
        int c = board[0].length;
        if(c == 0) return;
        boolean[][] z = new boolean[r][c];
        for(int i = 0; i < r; ++i){
            if(board[i][0] == 'O' && z[i][0] == false)
                helper(board,z,i,0);
            if(board[i][c-1] == 'O' && z[i][c-1] == false)
                helper(board,z,i,c-1);
        }

        for(int i = 0; i < c; ++i){
            if(board[0][i] == 'O' && z[0][i] == false)
                helper(board,z,0,i);
            if(board[r-1][i] == 'O' && z[r-1][i] == false)
                helper(board,z,r-1,i);
        }

        for(int i = 0; i < r; ++i)
            for(int j = 0; j < c; ++j){
                if(!z[i][j])
                    board[i][j] = 'X';
                else
                    board[i][j] = 'O';
            }
    }

    private void helper(char[][] b, boolean[][] z, int i, int j){
        z[i][j] = true;
        b[i][j] = 'X';
        if(i - 1 >=0 && b[i-1][j] == 'O')
            helper(b,z,i-1,j);
        if(i + 1 < b.length && b[i+1][j] == 'O')
            helper(b,z,i+1,j);
        if(j - 1 >=0 && b[i][j-1] == 'O')
            helper(b,z,i,j-1);
        if(j + 1 <b[0].length && b[i][j+1] == 'O')
            helper(b,z,i,j+1);

    }
}
