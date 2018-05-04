import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-3-7.
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Palindrome_Partitioning_131 {

    private boolean[][] myGetP(String s) {
        int n = s.length();
        boolean[][] isP = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            int st = i, e = i;
            while (st >= 0 && e < n) {
                if (s.charAt(st) == s.charAt(e))
                    isP[st][e] = true;
                else {
                    break;
                }
                --st;
                ++e;
            }
            st = i;
            e = i + 1;
            while (st >= 0 && e < n) {
                if (s.charAt(st) == s.charAt(e))
                    isP[st][e] = true;
                else {
                    break;
                }
                --st;
                ++e;
            }
        }
        return isP;
    }

    private boolean[][] dbGetP(String s) {
        int n = s.length();
        boolean[][] isP = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                if (i == 0) {
                    isP[j][j + i] = true;
                } else if (i == 1) {
                    isP[j][j + i] = (s.charAt(j) == s.charAt(j + i));
                } else {
                    isP[j][j + i] = (isP[j + 1][j + i - 1] && (s.charAt(j) == s.charAt(j + i)));
                }
            }
        }
        return isP;
    }


    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isP = dbGetP(s);

        List<String> r = new ArrayList<>();
        List<List<String>> result = new LinkedList<>();
        helper2(isP, 0, r, result, s);

        return result;
    }


    private void helper2(boolean[][] p, int index, List<String> r, List<List<String>> result, String s) {
        if (index == p.length) {
            result.add(new LinkedList(r));
            return;
        }

        for (int i = index; i < p.length; ++i) {
            if (p[index][i]) {
                r.add(s.substring(index, i + 1));
                helper2(p, i + 1, r, result, s);
                r.remove(r.size() - 1);
            }
        }
    }


    private void helper(boolean[][] p, int start, int split_num, List<String> r, List<List<String>> result, String s) {
        if (split_num == 0) {
            if (p[start][p.length - 1]) {
                r.add(s.substring(start, p.length));
                result.add(new LinkedList(r));
                r.remove(r.size() - 1);
            }
            return;
        }

        for (int i = start; i < p.length - split_num; ++i) {
            if (p[start][i]) {
                r.add(s.substring(start, i + 1));
                helper(p, i + 1, split_num - 1, r, result, s);
                r.remove(r.size() - 1);
            }
        }

    }

}
