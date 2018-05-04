/**
 * Created by zhongjianlv on 18-4-20.
 * <p>
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example:
 * Given "bcabc"
 * Return "abc"
 * <p>
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class Remove_Duplicate_Letters_316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        char[] ss = s.toCharArray();
        int diff = 0;
        for (int i = 0; i < ss.length; i++) {
            count[ss[i] - 'a']++;
            if (count[ss[i] - 'a'] == 1) diff++;
        }
        StringBuilder res = new StringBuilder();
        helper(ss, 0, count, res, diff);
        return res.toString();
    }

    private void helper(char[] ss, int i, int[] count, StringBuilder res, int n) {
        if (res.length() == n)
            return;
        for (int j = 0; j < count.length; j++) {
            if (count[j] > 0) {
                for (int k = i; k < ss.length; k++) {
                    if (j == ss[k] - 'a') {//遇到j+'a'
                        res.append((char) (j + 'a'));
                        int old = count[j];
                        count[j] = 0;
                        helper(ss, k + 1, count, res, n);
                        if (res.length() == n) return;
                        count[j] = old;
                        res.deleteCharAt(res.length() - 1);
                        break;
                    } else {
                        count[ss[k] - 'a']--;
                        if (count[ss[k] - 'a'] == 0) {//回朔
                            for (int l = i; l <= k; l++) {
                                count[ss[l] - 'a']++;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Remove_Duplicate_Letters_316 remove_duplicate_letters_316 = new Remove_Duplicate_Letters_316();
//        assert remove_duplicate_letters_316.removeDuplicateLetters("cbaddabaa").equals("cadb");
//        assert remove_duplicate_letters_316.removeDuplicateLetters("bcabc").equals("abc");
//        assert remove_duplicate_letters_316.removeDuplicateLetters("cbacdcbc").equals("acdb");
        System.out.println(remove_duplicate_letters_316.removeDuplicateLetters("caccabad"));
    }
}
