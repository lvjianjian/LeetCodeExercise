import java.util.Stack;

/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class Interleaving_String_97 {


    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();
        if(ss1.length + ss2.length != ss3.length) return false;
        int[][] a = new int[ss1.length+1][ss2.length+1];
        a[0][0] = 1;
        for(int i = 1;i <= ss3.length; ++i){
            int ls1 = i;
            int ls2 = 0;
            while(ls2 <= ss2.length){
                if(ls1 - 1 >=0 && ls1 <= ss1.length && a[ls1-1][ls2] == 1 && ss1[ls1-1] == ss3[ls1 + ls2 - 1])
                    a[ls1][ls2] = 1;
                if(ls1 < 0) break;
                if(ls2 - 1 >= 0 && ls1 <= ss1.length && a[ls1][ls2-1] == 1 && ss2[ls2-1] == ss3[ls1 + ls2 - 1])
                    a[ls1][ls2] = 1;
                --ls1;
                ++ls2;
            }

        }

        return a[ss1.length][ss2.length]==1? true:false;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {//有重复
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();
        if(ss1.length + ss2.length != ss3.length) return false;
        Stack<int[]> a = new Stack<>();
        a.push(new int[]{0, 0, 0});
        while (!a.isEmpty()) {
            int[] temp = a.pop();
            if (temp[2] == ss3.length)
                return true;
            if (temp[0] < ss1.length && ss1[temp[0]] == ss3[temp[2]])
                a.push(new int[]{temp[0] + 1, temp[1], temp[2] + 1});
            if (temp[1] < ss2.length && ss2[temp[1]] == ss3[temp[2]])
                a.push(new int[]{temp[0], temp[1] + 1, temp[2] + 1});
        }
        return false;
    }

    public static void main(String[] args) {
        Interleaving_String_97 interleaving_string_97 = new Interleaving_String_97();
        System.out.println(interleaving_string_97.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
