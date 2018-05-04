/**
 * Created by zhongjianlv on 2018/2/17
 * <p>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Valid_Anagram_242 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] check = new int[26];
        for(int i = 0; i < ss.length; ++i){
            ++check[ss[i] - 'a'];
        }
        for(int i = 0;i < tt.length; ++i){
            int index = tt[i] - 'a';
            --check[index];
            if(check[index] < 0) return false;
        }
        return true;
    }

}
