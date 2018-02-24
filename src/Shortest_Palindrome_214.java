import java.util.Arrays;

/**
 * Created by zhongjianlv on 2018/2/23
 */
public class Shortest_Palindrome_214 {


    // KMP-based !!
    public String shortestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int[] next = new int[ss.length];
        int k = 0;
        for (int i = 1; i < ss.length; ++i) {
            while (k > 0 && ss[k] != ss[i]) {
                k = next[k] - 1;
            }
            if(k == -1)
                k = 0;
            if (ss[k] == ss[i]) {
                k += 1;
            }
            next[i] = k;
        }
        int i = 0, end = ss.length - 1;
        k = ss.length - 1;
        while(i < k){
            if(ss[i] == ss[k]){
                ++i;
                --k;
            }else{
                if(i == 0 || next[i-1] == 0){
                    i = 0;
                    if(end == k)
                        k = k - 1;
                    end = k;
                }else{
                    end = k + next[i-1];
                    i = next[i-1];
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int j = ss.length - 1; j > end; --j){
            stringBuilder.append(ss[j]);
        }
        stringBuilder.append(ss);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Shortest_Palindrome_214 shortest_palindrome_214 = new Shortest_Palindrome_214();
        System.out.println(shortest_palindrome_214.shortestPalindrome("babbbabbaba"));//"ababbabbbabbaba"
    }
}
