import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhongjianlv on 18-4-21.
 * <p>
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * <p>
 * Example:
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 * <p>
 * Note:
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */
public class Brick_Wall_554 {

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) return 0;
        int n = wall.size();
        if (n == 0 || wall.get(0).size() == 0) return 0;
        if (n == 1 && wall.get(0).size() == 1) return 1;
        int sum = 0;
        for (Integer integer : wall.get(0)) {
            sum += integer;
        }
        Map<Integer, Integer> ints = new HashMap<>();
        for (List<Integer> list : wall) {
            int s = 0;
            for (Integer integer : list) {
                s += integer;
                ints.put(s, ints.getOrDefault(s, 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;

        for (Integer split_index : ints.keySet()) {
            if (split_index != sum) {
                min = Math.min(min, n - ints.get(split_index));
            }
        }
        return min == Integer.MAX_VALUE ? n : min;
    }
}
