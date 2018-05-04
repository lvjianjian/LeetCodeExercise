import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by zhongjianlv on 18-3-16.
 * <p>
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class Minimum_Time_Difference_539 {

    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> integers = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            String[] split = s.split(":");
            int time = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
            if (integers.contains(time))
                return 0;
            int i1, i2;
            Integer ceiling = integers.ceiling(time + 1);
            if (ceiling == null)
                i1 = Integer.MAX_VALUE;
            else i1 = ceiling - time;
            Integer floor = integers.floor(time - 1);
            if (floor == null)
                i2 = Integer.MAX_VALUE;
            else i2 = time - floor;
            min = Math.min(min, Math.min(i1, i2));
            integers.add(time);
        }
        min = Math.min(integers.first() + 24 * 60 - integers.last(), min);
        return min;
    }

    public static void main(String[] args) {
        Minimum_Time_Difference_539 minimum_time_difference_539 = new Minimum_Time_Difference_539();
        LinkedList<String> timePoints = new LinkedList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(minimum_time_difference_539.findMinDifference(timePoints));
    }
}
