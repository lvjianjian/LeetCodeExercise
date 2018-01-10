import java.util.Stack;

/**
 * Created by zhongjianlv on 18-1-10.
 */
public class Wildcard_Matching_44 {


    public boolean isMatch2(String s, String p) {
        int i = 0, j = 0, startIdx = -1, match = 0;
        while (i < s.length()) {
            if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (j < p.length() && p.charAt(j) == '*') {
                startIdx = j;
                match = i;
                j++;
            } else if (startIdx != -1) {
                i = ++match;
                j = startIdx + 1;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int i = 0;
        int j = 0;
        Stack<Integer> stack_s = new Stack<>();
        Stack<Integer> stack_p = new Stack<>();
        boolean back_star = false;
        boolean back = false;

        while (i <= s.length() && j <= p.length()) {
            if (i == s.length() && j == p.length()) return true;
            if (j == p.length() || back) {
                if (stack_p.isEmpty()) {
                    return false;
                } else {
                    j = stack_p.pop();
                    i = stack_s.pop();
                    back_star = true;
                }
                back = false;
            } else if (i == s.length()) {
                if (pp[j] != '*') return false;
            }

            char c = pp[j];
            if (c == '*' || back_star) {
                int wenhao = 0;
                if (!back_star) {
                    ++j;
                    while (j < p.length() && (pp[j] == '*' || pp[j] == '?')) {
                        if (pp[j] == '?')
                            ++wenhao;
                        ++j;
                    }
                    if (j >= p.length() && wenhao == 0) {
                        return true;
                    }
                } else {
                    ++i;
                }

                if(j == p.length()){
                    if(i + wenhao > s.length())  return false;
                    return true;
                }

                c = pp[j];
                i += wenhao;
                while (i < s.length() && ss[i] != c) ++i;
                if (i < s.length()) {
                    stack_p.push(j);
                    stack_s.push(i);
                    ++i;
                    ++j;
                } else {
                    i = s.length();
                }
                back_star = false;
            } else if (c == '?') {
                ++i;
                ++j;
            } else {
                if (i < s.length() && c == ss[i]) {
                    ++i;
                    ++j;
                } else {//不同 往前退回
                    back = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Wildcard_Matching_44 wildcard_matching_44 = new Wildcard_Matching_44();
        System.out.println(wildcard_matching_44.isMatch("aaaa","***a") + " T");
        System.out.println(wildcard_matching_44.isMatch("","") + " T");
        System.out.println(wildcard_matching_44.isMatch("a","") + " F");
        System.out.println(wildcard_matching_44.isMatch("","b") + " F");
        System.out.println(wildcard_matching_44.isMatch("a","b") + " F");
        System.out.println(wildcard_matching_44.isMatch("a","a") + " T");
        System.out.println(wildcard_matching_44.isMatch("a","?") + " T");
        System.out.println(wildcard_matching_44.isMatch("","?") + " F");
        System.out.println(wildcard_matching_44.isMatch("","*") + " T");
        System.out.println(wildcard_matching_44.isMatch("abc","*") + " T");
        System.out.println(wildcard_matching_44.isMatch("abcacd","a*c*d") + " T");
        System.out.println(wildcard_matching_44.isMatch("abcac","a*c*d") + " F");
        System.out.println("==============");
        System.out.println(wildcard_matching_44.isMatch("abefcdgiescdfimde","ab*cd?i*de") + " T");

        System.out.println(wildcard_matching_44.isMatch("b", "?*?") + " F");


        System.out.println(wildcard_matching_44.isMatch("hi","*?" )+ " T");
        System.out.println(wildcard_matching_44.isMatch("hi","*??" )+ " T");
        System.out.println(wildcard_matching_44.isMatch("hi","*???" )+ " F");
    }


}
