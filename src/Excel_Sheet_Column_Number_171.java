/**
 * Created by zhongjianlv on 2018/2/13
 * <p>
 * Related to question Excel Sheet Column Title
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class Excel_Sheet_Column_Number_171 {
    public int titleToNumber(String s) {
        int r = 0;
        char[] ss = s.toCharArray();
        for (char c : ss) {
            r *= 26;
            r += (c - 'A' + 1);
        }
        return r;
    }
}
