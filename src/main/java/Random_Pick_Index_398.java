import java.util.*;

/**
 * Created by zhongjianlv on 18-3-14.
 * <p>
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class Random_Pick_Index_398 {

    private Map<Integer, List<Integer>> map;
    private Random random;
    private int[] nums;
    public Random_Pick_Index_398(int[] nums) {
        this.nums = nums;
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            }
        }
    }

    //对于第i个target, 选择它进行替换的概率是1/i,
    // 假设对于前面时刻的选择概率都是1/(i-1),
    // 不替换掉前面的某个的概率是(i-1)/i
    // 因此当前时刻选择前面的选择概率为1/(i-1) * (i-1)/i = 1/i
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (random.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }

    public int pick2(int target) {
        List<Integer> list = map.get(target);
        int size = list.size();
        return list.get(random.nextInt(size));
    }
}
