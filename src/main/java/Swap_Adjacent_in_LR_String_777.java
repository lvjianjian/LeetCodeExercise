/**
 * Created by zhongjianlv on 18-2-7.
 * <p>
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 * <p>
 * Example:
 * <p>
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Note:
 * <p>
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class Swap_Adjacent_in_LR_String_777 {

    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        int i = 0;
        int j = 0;
        int N = s.length;
        while(i < N){
            if(s[i] == e[j]){
                ++i;
                ++j;
                continue;
            }

            if(s[i] == 'R'){
                if(e[j] == 'L')
                    return false;
                else{
                    int t = 1;
                    ++i;
                    ++j;
                    while(i < N && t != 0){
                        if(s[i] == 'L' || e[j] == 'L') return false;
                        if(s[i] == 'R') ++t;
                        if(e[j] == 'R') --t;
                        ++i;
                        ++j;
                    }
                    if(t!=0) return false;
                }
                continue;
            }

            if(s[i] == 'L' && (e[j] == 'R' || e[j] == 'X'))
                return false;

            if(s[i] == 'X'){
                if(e[j] == 'R')
                    return false;
                else{
                    int t = 1;
                    ++i;
                    ++j;
                    while(i < N && t != 0){
                        if(s[i] == 'R' || e[j] == 'R') return false;
                        if(s[i] == 'L') --t;
                        if(e[j] == 'L') ++t;
                        ++i;
                        ++j;
                    }
                    if(t!=0) return false;
                }
            }

        }
        return true;
    }
}
