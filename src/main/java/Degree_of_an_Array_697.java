import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 2018/4/18
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class Degree_of_an_Array_697 {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer,int[]> freqAndStart = new HashMap<>();
        int max = 0;
        int minLength = 0;
        int[] temp = null;
        for(int i = 0; i < nums.length; ++i){
            if(freqAndStart.containsKey(nums[i])){
                temp = freqAndStart.get(nums[i]);
                ++temp[0];
                if(temp[0] > max){
                    max = temp[0];
                    minLength = i - temp[1] + 1;
                }else if(temp[0] == max) minLength = Math.min(minLength, i - temp[1] + 1);
            }else{
                freqAndStart.put(nums[i],new int[]{1,i});
                if(max < 1){
                    max = 1;
                    minLength = 1;
                }
            }
        }
        return minLength;
    }
}
