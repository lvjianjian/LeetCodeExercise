import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by zhongjianlv on 18-1-19.
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Minimum_Window_Substring_76 {


    //神奇
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ls = ss.length;
        int lt = tt.length;
        int[] a = new int[128];
        for(int i = 0; i < lt; ++i){
            int _t = tt[i];
            ++a[_t];
        }

        int start = 0;
        int min = Integer.MAX_VALUE;
        int start_index = -1;
        int end_index = -1;
        for(int i = 0;i < ls; ++i){
            int _t = ss[i];
            if(a[_t]-- > 0) --lt;
            while(lt == 0){
                if(i - start < min){
                    min = i - start;
                    start_index = start;
                    end_index = i;
                }
                if(a[ss[start++]]++ == 0) ++lt;
            }
        }

        if(min < Integer.MAX_VALUE){
            return s.substring(start_index,end_index+1);
        }else return "";

    }

    public String minWindow2(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ls = ss.length;
        int lt = tt.length;
        PriorityQueue<Integer> current = null;
        int start_index = -1;
        int end_index = -1;
        int min = Integer.MAX_VALUE;
        Map<Character, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < lt; ++i){
            current = map.getOrDefault(tt[i],new PriorityQueue<Integer>());
            current.add(-1);
            if(!map.containsKey(tt[i]))
                map.put(tt[i],current);
        }

        for(int i = 0; i < ls; ++i){
            char temp = ss[i];
            if(map.containsKey(temp)){
                current = map.get(temp);
                int _t = current.poll();
                if(_t == -1)
                    --lt;
                current.add(i);
                if(lt == 0){
                    int _min = Integer.MAX_VALUE;
                    for(PriorityQueue<Integer> _c: map.values()){
                        int _ttt = _c.peek();
                        if(_ttt < _min)
                            _min = _ttt;
                    }
                    if((i - _min) < min){
                        min = i - _min;
                        start_index = _min;
                        end_index = i;
                    }
                }
            }
        }
        if(lt != 0)
            return "";
        else return s.substring(start_index, end_index + 1);

    }

    public static void main(String[] args) {
        Minimum_Window_Substring_76 minimum_window_substring_76 = new Minimum_Window_Substring_76();
        System.out.println(minimum_window_substring_76.minWindow("abacadaeafag","aa"));
    }
}
