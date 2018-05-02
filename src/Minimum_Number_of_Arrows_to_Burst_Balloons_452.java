import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhongjianlv on 2018/5/2
 * <p>
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * <p>
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Example:
 * <p>
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting
 */
public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {

    //greedy 对气球末尾从小到大排序，按照末尾射击，射击后将后面气球起始位置小于等于该射击点的都射爆
    // 这里不需要在意后面气球的起始位置是由于如果较早碰到不能射穿的气球，那么射击此气球的末端任然可以保证接下来的起始位置小于等于此气球甚至是前一气球末端位置的都可以射穿
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 1;
        int shot = points[0][1];
        int index = 1;
        while (index < points.length) {
            while (index < points.length && points[index][0] <= shot) index++;
            if (index == points.length) break;
            res += 1;
            shot = points[index][1];
        }
        return res;
    }
}
