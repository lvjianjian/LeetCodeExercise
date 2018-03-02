import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhongjianlv on 18-3-2.
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Largest_Number_179 {



    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]);
        }

        int i = 0;
        while(i < sb.length() && sb.charAt(i)=='0') ++i;
        if(i == sb.length()) return "0";
        return sb.substring(i);
    }

}
