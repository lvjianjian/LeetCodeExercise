import java.util.*;

/**
 * Created by zhongjianlv on 18-4-2.
 * <p>
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class Maximum_Product_of_Three_Numbers_628 {
    public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i > max) {
                max3 = max2;
                max2 = max;
                max = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
            if (i < min) {
                min2 = min;
                min = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(max * max2 * max3, max * min * min2);
    }

    public int maximumProduct3(int[] nums) {
        PriorityQueue<Integer> big = new PriorityQueue<>(3);
        PriorityQueue<Integer> small = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (big.size() < 3) {
                big.add(nums[i]);
            } else {
                int poll = nums[i];
                if(big.peek() < nums[i]){
                    poll = big.poll();
                    big.add(nums[i]);

                }
                if(small.size() < 2)
                    small.add(poll);
                else{
                    if(small.peek() > poll){
                        small.poll();
                        small.add(poll);
                    }

                }
            }
        }


        List<Integer> l = new ArrayList<>();
        while (big.size() != 0) {
            l.add(big.poll());
        }
        while (small.size() != 0) {
            l.add(0, small.poll());
        }
        int size = l.size();
        int max = l.get(0) * l.get(1) * l.get(size - 1);
        int max2 = l.get(size - 1) * l.get(size - 2) * l.get(size - 3);

        return Math.max(max, max2);
    }

    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
