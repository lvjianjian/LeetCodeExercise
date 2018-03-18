import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tool.LowercaseWordTrieNode;

/**
 * Created by zhongjianlv on 2018/2/9
 * <p>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * <p>
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Word_Search_II_212 {


    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int r = board.length;
        if (r == 0) return result;
        int c = board[0].length;
        if (c == 0) return result;
        LowercaseWordTrieNode root = LowercaseWordTrieNode.buildRoot(words);
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                help(board, root, i, j, result);
            }
        }
        return result;
    }

    private void help(char[][] board, LowercaseWordTrieNode node, int i, int j, List<String> result) {
        if (node == null) return;
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == ' ') return;
        int index = c - 'a';

        if (node.next[index] != null) {
            board[i][j] = ' ';
            help(board, node.next[index], i + 1, j, result);
            help(board, node.next[index], i - 1, j, result);
            help(board, node.next[index], i, j + 1, result);
            help(board, node.next[index], i, j - 1, result);
            board[i][j] = c;
        }
    }

    //依靠word search
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; ++i)
            if (!set.contains(words[i])) {
                set.add(words[i]);
                if (exist(board, words[i]))
                    result.add(words[i]);
            }
        return result;
    }


    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        if (r == 0) return false;
        int c = board[0].length;
        if (c == 0) return false;
        char[] words = word.toCharArray();
        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j) {
                flag = false;
                helper(board, i, j, words, 0);
                if (flag) return true;
            }
        return false;

    }


    private void helper(char[][] board, int i, int j, char[] words, int k) {
        if (flag == true) return;
        if (k == words.length) {
            flag = true;
            return;
        }
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
            if (words[k] == board[i][j]) {
                char old = board[i][j];
                board[i][j] = ' ';
                helper(board, i - 1, j, words, k + 1);
                helper(board, i, j - 1, words, k + 1);
                helper(board, i + 1, j, words, k + 1);
                helper(board, i, j + 1, words, k + 1);
                board[i][j] = old;
            }
    }
}
