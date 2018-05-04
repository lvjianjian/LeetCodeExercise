import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-3.
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] now = new char[n * 2];
        helper(n, 0, 0, now, result);
        return result;
    }

    private void helper(int n, int m, int k, char[] now, List<String> result) {
        if (n == 0 && m == 0) {
            result.add(new String(now));
        }

        if (n > 0) {
            now[k] = '(';
            helper(n - 1, m + 1, k + 1, now, result);
        }

        if (m > 0) {
            now[k] = ')';
            helper(n, m - 1, k + 1, now, result);
        }
    }

    public static void main(String[] args) {
        Generate_Parentheses_22 generate_parentheses_22 = new Generate_Parentheses_22();
        System.out.println(generate_parentheses_22.generateParenthesis(5).size());
    }
}
