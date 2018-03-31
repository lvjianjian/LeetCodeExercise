/**
 * Created by zhongjianlv on 18-3-30.
 * <p>
 * There is a strange printer with the following two special requirements:
 * <p>
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
 * Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.
 * <p>
 * Example 1:
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * Example 2:
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 * Hint: Length of the given string will not exceed 100.
 */
public class Strange_Printer_664 {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int length = s.length();
        char[] temp = new char[length];
        int size = 0;
        char preChar = ' ';
        for (int i = 0; i < length; i++) {
            if (chars[i] != preChar) {
                temp[size++] = chars[i];
                preChar = chars[i];
            }
        }
        int[][] r = new int[size][size];
        for (int i = 0; i < r.length; i++) {
            r[i][i] = 1;
        }
        int min, end;
        for (int len = 1; len < size; len++) {
            for (int i = 0; i + len < size; i++) {
                min = Integer.MAX_VALUE;
                end = i + len;
                if (temp[i] == temp[end])
                    min = r[i + 1][end];
                else {
                    for (int j = i; j < end; j++) {
                        if (r[i][j] + r[j + 1][end] < min)
                            min = r[i][j] + r[j + 1][end];
                    }
                }
                r[i][i + len] = min;
            }
        }
        return r[0][size - 1];
    }

    public static void main(String[] args) {
        Strange_Printer_664 strange_printer_664 = new Strange_Printer_664();
        System.out.println(strange_printer_664.strangePrinter("abcabc"));
    }
}
