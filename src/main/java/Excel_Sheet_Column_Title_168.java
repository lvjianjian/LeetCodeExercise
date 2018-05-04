import java.util.Stack;

/**
 * Created by zhongjianlv on 2018/2/13
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class Excel_Sheet_Column_Title_168 {

    public String convertToTitle(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            n -= 1;
            stack.push(n % 26);
            n /= 26;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) ('A' + stack.pop()));
        }
        return sb.toString();
    }
}
