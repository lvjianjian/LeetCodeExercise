import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 2018/2/8
 * <p>
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p>
 * Example:
 * <p>
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */
public class Binary_Watch_401 {

    public static int[] minutes = new int[]{1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if(num >= 0 && num <= 10){
            helper(num,0,0,0,0,result);
        }
        return result;
    }

    private void helper(int k, int hour, int h, int minute, int m, List<String> result){
        if(hour > 11 || minute > 59) return;
        if(k == 0){
            String r = hour + ":";
            if(minute < 10)
                r += ("0" + minute);
            else
                r += minute;
            result.add(r);
            return;
        }

        if(minute == 0)
            for(int i = h; i < 4; ++i)
                helper(k-1,hour+minutes[i],i + 1,minute,m,result);
        for(int j = m; j < 6; ++j)
            helper(k-1,hour,h,minute+minutes[j],j+1,result);

    }

    public static void main(String[] args) {
        Binary_Watch_401 binary_watch_401 = new Binary_Watch_401();
        System.out.println(binary_watch_401.readBinaryWatch(2));
    }
}
