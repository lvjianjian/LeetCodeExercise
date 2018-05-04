import java.util.*;

/**
 * Created by zhongjianlv on 2018/2/9
 * <p>
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Pattern132_456 {


    //从后往前找231
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >=0; --i){
            if(nums[i] < min) return true;
            if(stack.isEmpty() || stack.peek() > nums[i]){
                stack.push(nums[i]);
            }else if(stack.peek() < nums[i]){
                while(!stack.isEmpty() && stack.peek() < nums[i]){
                    int temp = stack.pop();
                    if(temp > min) min = temp;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }


    //slow
    public boolean find132pattern3(int[] nums) {
        List<int[]> minmax = new LinkedList<>();
        Set<Integer> ints = new HashSet<>();
        if(nums == null || nums.length <= 2) return false;
        int small = nums[0];
        int large = small;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] < small){
                if(large > small + 1){
                    if(large - small > 100){
                        minmax.add(new int[]{small,large});
                    }else{
                        for(int k = small+1; k < large; ++k)
                            ints.add(k);
                    }
                }

                large = small = nums[i];
            }
            if(nums[i] > large)
                large = nums[i];

            if(nums[i] > small && nums[i] < large) return true;
            if(ints.contains(nums[i])) return true;
            for(int[] temp:minmax){
                if(nums[i] > temp[0] && nums[i] < temp[1]) return true;
            }
        }
        return false;
    }

    // slow
    public boolean find132pattern2(int[] nums) {
        if(nums == null || nums.length <= 2) return false;
        for(int i = 0; i < nums.length -2; ++i){
            int small = nums[i];
            int large = small;
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] > large){
                    large = nums[j];
                    continue;
                }
                if(nums[j] > small && nums[j] < large) return true;

            }
        }
        return false;
    }
}
