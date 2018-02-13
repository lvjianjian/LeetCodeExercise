/**
 * Created by zhongjianlv on 2018/2/14
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class Isomorphic_Strings_205 {

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        char[] replace = new char[128];
        char[] replace2 = new char[128];
        char sss,ttt;
        for(int i = 0;i < ss.length; ++i){
            sss = ss[i];
            ttt = tt[i];
            if(replace[sss] == 0){
                replace[sss] = ttt;
                if(replace2[ttt] != 0)
                    return false;
                replace2[ttt] = sss;
            }
            else if(replace[sss] != ttt)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] chars = new char[5];
        System.out.println(chars[0] == 0);
    }
}
