import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhongjianlv on 18-4-13.
 * <p>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * <p>
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 */
public class Sliding_Window_Median_480 {


    public double[] medianSlidingWindow(int[] nums, int k) {
        int res_length = nums.length - k + 1;
        if (res_length < 0) return null;
        double[] res = new double[res_length];
        if (res_length == 0) return res;

        boolean odd = (k & 1) != 0;
        int initialCapacity = k / 2 + 1;
        PriorityQueue<Integer> min = new PriorityQueue<>(initialCapacity);
        PriorityQueue<Integer> max = new PriorityQueue<>(initialCapacity, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); //这里不能写o2 - o1 ,存在越界问题
            }
        });
        //be sure min.size() >= max.size && |min.size - max.size| <= 1
        int diff = 1;
        if (odd)
            diff = 2;
        //init
        for (int i = 0; i < k - 1; i++) {
            add(nums[i], min, max, diff);
        }


        for (int i = k - 1; i < nums.length; i++) {
            if (i > k - 1) {
                if (max.peek() != null && nums[i - k] <= max.peek()) {
                    max.remove(nums[i - k]);
                } else {
                    min.remove(nums[i - k]);
                    if (max.peek() != null)//注意空指针检查
                        min.add(max.poll());
                }
            }

            add(nums[i], min, max, diff);

            if (odd) {
                res[i - k + 1] = min.peek();
            } else {
                res[i - k + 1] = ((double) min.peek() + max.peek()) / 2D;
            }

        }

        return res;
    }

    private void add(int num, PriorityQueue<Integer> min, PriorityQueue<Integer> max, int diff) {
        min.add(num);
        if (min.size() - max.size() > diff) {
            max.add(min.poll());
        }
        //这里要注意可能min的最小值会比max的最大值小, 应当保证min的最小值要大于等于max的最大值
        while (min.peek() != null && max.peek() != null && min.peek() < max.peek()) {
            min.add(max.poll());
            max.add(min.poll());
        }
    }

    public static void main(String[] args) {
        Sliding_Window_Median_480 sliding_window_median_480 = new Sliding_Window_Median_480();
        int[] nums = {-2147483648, -2147483648, 2147483647, -2147483648, 1, 3, -2147483648, -100, 8, 17, 22, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
        System.out.println(Arrays.toString(sliding_window_median_480.medianSlidingWindow(nums, 6)));
    }
}
