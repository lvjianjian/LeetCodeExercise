/**
 * Created by zhongjianlv on 18-1-11.
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
public class Jump_Game_II_45 {

    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int current = 0;
        int step = 1;
        int start = 1;
        int max = 0;
        int length = nums.length;
        while (true) {
            int end = current + nums[current];
            if (end >= length - 1)
                return step;
            int index = 0;
            for (int i = start; i <= end && i < length; i++) {
                if (i + nums[i] > max) {
                    index = i;
                    max = i + nums[i];
                }
            }
            start = end + 1;
            current = index;
            ++step;
        }
    }

    public static void main(String[] args) {
        Jump_Game_II_45 jump_game_ii_45 = new Jump_Game_II_45();
        System.out.println(jump_game_ii_45.jump(new int[]{1,2,3,4,5,1,1,1,1,10}));
    }
}
