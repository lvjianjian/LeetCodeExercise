/**
 * Created by zhongjianlv on 17-12-27.
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class Longest_Palindromic_Substring_5 {

    public String longestPalindrome(String s) {
        int max = 1;
        int start_index = 0;
        int end_index = 1;

        //中心为1个
        for (int i = 1; i < s.length() - 1; i++) {
            int l = i - 1;
            int h = i + 1;
            int _temp = 1;
            while (l > -1 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                _temp += 2;
                --l;
                ++h;
            }
            if (_temp > max) {
                max = _temp;
                start_index = l + 1;
                end_index = h;
            }
        }


        //中心为2个
        if (max != s.length()) {
            int _t = (max - 1) / 2;
            for (int i = _t; i < s.length() - _t; i++) {
                int l = i;
                int h = i + 1;
                int _temp = 0;
                while (l > -1 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                    _temp += 2;
                    --l;
                    ++h;
                }
                if (_temp > max) {
                    max = _temp;
                    start_index = l + 1;
                    end_index = h;
                }
            }


        }


        return s.substring(start_index, end_index);

    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring_5 longest_palindromic_substring_5 = new Longest_Palindromic_Substring_5();
        long start = System.currentTimeMillis();
        longest_palindromic_substring_5.longestPalindrome("aaaaaaabsafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(System.currentTimeMillis() - start);
    }
}
