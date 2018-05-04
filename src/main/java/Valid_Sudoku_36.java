import java.util.*;

/**
 * Created by zhongjianlv on 18-1-12.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Valid_Sudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9)
            return false;

        int[][] c_valid = new int[9][9];
        int[][] r_valid = new int[9][9];
        int[][] g_valid = new int[9][9];
        for(int i = 0;i < 9; ++i)
            for(int j =0;j <9;++j)
            {
                char temp = board[i][j];
                if(temp == '.') continue;
                int g = i/3 * 3 + j/3;
                if(!helper(r_valid,i,temp))
                    return false;
                if(!helper(c_valid,j,temp))
                    return false;
                if(!helper(g_valid,g,temp))
                    return false;
            }

        return true;
    }

    private boolean helper( int[][] valid, int key, char temp){
        int j = temp - '0' - 1;
        if(valid[key][j] == 1)
            return false;
        else
            ++valid[key][j];
        return true;
    }



    public boolean isValidSudoku2(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9)
            return false;

        Map<Integer,Set<Character>> map = new HashMap<>();
        for(int i = 0;i < 9; ++i)
            for(int j =0;j <9;++j)
            {
                char temp = board[i][j];
                if(temp == '.') continue;
                int r = 10 + i;
                int c = 20 + j;
                int g = i/3 * 3 + j/3;
                if(!helper2(map,r,temp))
                    return false;
                if(!helper2(map,c,temp))
                    return false;
                if(!helper2(map,g,temp))
                    return false;
            }

        return true;
    }

    private boolean helper2( Map<Integer,Set<Character>> map, int key, char temp){
        if(!map.containsKey(key)){
            map.put(key, new HashSet<>());
        }

        if(map.get(key).contains(temp))
            return false;
        map.get(key).add(temp);
        return true;

    }
}
