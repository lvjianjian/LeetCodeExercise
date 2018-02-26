
/**
 * Created by zhongjianlv on 18-1-10.
 */
public class Regular_Expression_Matching_10 {

    //DP
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] r = new boolean[ss.length+1][pp.length+1];
        r[0][0] = true;
        for(int i = 0; i < pp.length; ++i){
            if(pp[i] == '*' && r[0][i-1])
                r[0][i+1] = true;
        }

        for(int i = 0; i < ss.length; ++i){
            for(int j = 0;j < pp.length; ++j){
                if(ss[i] == pp[j] || pp[j] == '.')
                    r[i+1][j+1] = r[i][j];
                else if(pp[j] == '*'){
                    if(pp[j-1] == '.' || pp[j-1] == ss[i]){
                        r[i+1][j+1] = (r[i+1][j-1] || r[i][j-1] || r[i][j+1]);
                    }else{
                        r[i+1][j+1] = r[i+1][j-1];
                    }
                }else
                    r[i+1][j+1] = false;

            }
        }
        return r[ss.length][pp.length];
    }

    public boolean isMatch2(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        return helper(ss, 0, pp, 0);
    }

    private boolean helper(char[] s, int i, char[] p, int j) {
        if (j == p.length && i == s.length) return true;
        else if (j == p.length) return false;
        else if (i == s.length) {
            for (int k = j + 1; k < p.length; k += 2) {
                if (p[k] != '*') return false;
            }
            if (p[p.length - 1] != '*') return false;
            return true;
        }
        char k = p[j];
        if (j + 1 < p.length && p[j + 1] == '*') {//匹配0个或多个
            if (k == '.') {
                for (int z = i; z <= s.length; ++z) {
                    if (helper(s, z, p, j + 2))
                        return true;
                }
                return false;
            } else {
                for (int z = i; z <= s.length; ++z) {
                    if (z == i) {
                        if (helper(s, z, p, j + 2))
                            return true;
                    } else {
                        if (k == s[z - 1]) {
                            if (helper(s, z, p, j + 2))
                                return true;
                        } else return false;

                    }
                }
                return false;
            }
        } else {//匹配1个
            if (k == '.')
                return helper(s, i + 1, p, j + 1);
            else {
                if (k == s[i])
                    return helper(s, i + 1, p, j + 1);
                else return false;
            }
        }
    }


    public static void main(String[] args) {
        Regular_Expression_Matching_10 regular_expression_matching_10 = new Regular_Expression_Matching_10();
        System.out.println(regular_expression_matching_10.isMatch("bbab", "b*a*"));
    }
}
