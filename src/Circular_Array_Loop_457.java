/**
 * Created by zhongjianlv on 18-3-15.
 * <p>
 * You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.
 * <p>
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
 * <p>
 * Example 2: Given the array [-1, 2], there is no loop.
 * <p>
 * Note: The given array is guaranteed to contain no element "0".
 * <p>
 * Can you do it in O(n) time complexity and O(1) space complexity?
 */
public class Circular_Array_Loop_457 {

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (hasCircular(nums, i)) return true;
            }
        }

        return false;
    }

    private boolean hasCircular(int[] nums, int i) {
        int prei = i;
        int positive = nums[i] > 0 ? 1 : -1;
        int change = 0;
        while (nums[i] != 0) {
            if (positive * nums[i] < 0) return false;
            prei = i;
            i = (i + nums[i] + nums.length) % nums.length;
            nums[prei] = 0;
            ++change;
        }
        if (prei == i || change < 2) return false;
        else return true;
    }


    public static void main(String[] args) {
        Circular_Array_Loop_457 circular_array_loop_457 = new Circular_Array_Loop_457();
        System.out.println(circular_array_loop_457.circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));//
    }
}
