/**
 * Created by zhongjianlv on 18-2-1.
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
public class Decode_Ways_91 {

    public int numDecodings(String s) {//DP
        int pre = 1;
        int now = 1;
        int prepre = 1;
        char[] ss = s.toCharArray();
        if(ss.length ==  0 || ss[0] == '0') return 0;

        for(int i = 1; i < ss.length; ++i){
            if(ss[i] == '0'){
                if(ss[i-1] == '1' || ss[i-1] == '2'){
                    now = prepre;
                }else{
                    return 0;
                }
            }else{
                if(ss[i-1] == '0')
                    now = pre;
                else{
                    if(Integer.valueOf("" +ss[i-1] + ss[i]) > 26)
                        now = pre;
                    else
                        now = pre + prepre;
                }
            }
            prepre = pre;
            pre = now;
        }
        return now;
    }
}
