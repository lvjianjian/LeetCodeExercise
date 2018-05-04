/**
 * Created by zhongjianlv on 18-1-12.
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class Length_of_Last_Word_58 {

    public int lengthOfLastWord(String s) {
        char[] ss = s.toCharArray();
        int i = ss.length - 1;
        while (i >= 0 && ss[i] == ' ') --i;
        int last = i;
        for (; i >= 0; --i) {
            if (ss[i] == ' ') break;
        }
        return last - i;
    }
}
