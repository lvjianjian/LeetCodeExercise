/**
 * Created by zhongjianlv on 18-1-22.
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Word_Search_79 {
    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        if(r == 0) return false;
        int c = board[0].length;
        if(c == 0) return false;
        char[] words = word.toCharArray();
        for(int i =0; i < r;++i)
            for(int j=0;j<c;++j){
                flag = false;
                helper(board, i,j, words, 0);
                if(flag) return true;
            }
        return false;

    }


    private void helper(char[][] board, int i, int j, char[] words, int k){
        if(flag == true) return;
        if(k == words.length) {
            flag = true;
            return;
        }
        if(i>=0 && i < board.length && j >=0 && j < board[0].length)
            if(words[k] == board[i][j]){
                char old = board[i][j];
                board[i][j] = ' ';
                helper(board,i-1,j,words,k+1);
                helper(board,i,j-1,words,k+1);
                helper(board,i+1,j,words,k+1);
                helper(board,i,j+1,words,k+1);
                board[i][j] = old;
            }
    }
}
