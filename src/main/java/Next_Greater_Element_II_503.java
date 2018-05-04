import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
public class Next_Greater_Element_II_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] r = new int[nums.length];
        if (r.length == 0)
            return r;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        priorityQueue.add(new int[]{nums[0], 0});
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int item = nums[i];
            if (item > max)
                max = item;
            if (item > min) {
                while (!priorityQueue.isEmpty()) {
                    int[] poll = priorityQueue.peek();
                    if (poll[0] < item) {
                        r[poll[1]] = item;
                        priorityQueue.poll();
                    } else {
                        min = item;
                        break;
                    }
                }
            } else {
                min = item;
            }
            priorityQueue.add(new int[]{nums[i], i});
        }

        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (poll[0] == max) {
                r[poll[1]] = -1;
            } else {
                int index = 0;
                while (nums[index] <= poll[0]) ++index;
                r[poll[1]] = nums[index];
            }
        }
        System.out.println(Arrays.toString(r));
        return r;
    }

    public static void main(String[] args) {
        Next_Greater_Element_II_503 next_greater_element_ii_503 = new Next_Greater_Element_II_503();
        next_greater_element_ii_503.nextGreaterElements(new int[]{3, 4, 5, 10, 1, 3});
        next_greater_element_ii_503.nextGreaterElements(new int[]{10, 9, 8, 10});
        next_greater_element_ii_503.nextGreaterElements(new int[]{10});
        next_greater_element_ii_503.nextGreaterElements(new int[]{});
        next_greater_element_ii_503.nextGreaterElements(new int[]{2,5,3,10,3,1,-2,0,5,4,10,2});
    }
}
