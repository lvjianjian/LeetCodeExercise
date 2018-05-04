/**
 * Created by zhongjianlv on 18-1-1.
 * <p>
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class Count_Binary_Substrings_696 {

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int zeros = 0;
        int ones = 0;
        char pre = '~';
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (c == pre) {
                if (c == '0')
                    ++zeros;
                else
                    ++ones;
            } else {
                pre = c;
                --i;
                if (ones != 0 && zeros != 0) {
                    result += Math.min(zeros, ones);
                    if (c == '0')
                        zeros = 0;
                    else
                        ones = 0;
                }
            }
        }
        result += Math.min(zeros, ones);
        return result;
    }

    public static void main(String[] args) {
        Count_Binary_Substrings_696 count_binary_substrings_696 = new Count_Binary_Substrings_696();
        System.out.println(count_binary_substrings_696.countBinarySubstrings("10101"));
    }

}
