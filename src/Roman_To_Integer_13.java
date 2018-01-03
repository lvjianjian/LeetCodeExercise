import java.util.HashMap;

/**
 * Created by zhongjianlv on 17-4-6.
 *
 * leetcode algorithm 13
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class Roman_To_Integer_13 {
    public static HashMap<Character,Integer> map = new HashMap<>();

    static {
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }



    public int romanToInt(String s) {
        int r = 0;
        if(s == null || s.length() == 0)
            return r;
        int now = map.get(s.charAt(0));
        int next = 0;
        for (int i = 1; i < s.length(); i++) {
            next = map.get(s.charAt(i));
            if(now < next){
                r += (next - now);
                if(++i < s.length()) {
                    now = map.get(s.charAt(i));
                }else {
                    now = 0;
                }
            }else {
                r += now;
                now = next;
            }
        }
        r += now;
        return r;
    }

    public static void main(String[] args) {
        Roman_To_Integer_13 romanToInteger13 = new Roman_To_Integer_13();
        System.out.println(romanToInteger13.romanToInt("CIX"));
    }
}
