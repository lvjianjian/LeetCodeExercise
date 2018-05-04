import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhongjianlv on 18-3-11.
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p>
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class Sliding_Window_Maximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0) return new int[0];
        int n = nums.length;
        int rl = n - k + 1;
        int[] r = new int[rl];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        while(i < k){
            helper(nums, deque, i);
            ++i;
        }
        while (i <= n){
            Integer index = deque.peekFirst();
            r[i - k] = nums[index];
            if(index <= i - k) deque.pollFirst();
            if(i < n){
                helper(nums, deque, i);
            }
            ++i;
        }
        return r;
    }

    private void helper(int[] nums, Deque<Integer> deque, int i) {
        int size = deque.size();
        while (size > 0){
            if(nums[deque.peekLast()] > nums[i]) break;
            deque.pollLast();
            --size;
        }
        deque.add(i);
    }

    public static void main(String[] args) {
        Sliding_Window_Maximum_239 sliding_window_maximum_239 = new Sliding_Window_Maximum_239();
        System.out.println(Arrays.toString(sliding_window_maximum_239.maxSlidingWindow(new int[]{1,3,1,2,0,5},3)));
    }
}
