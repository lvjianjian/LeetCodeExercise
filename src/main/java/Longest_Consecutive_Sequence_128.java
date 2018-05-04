import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongjianlv on 18-2-28.
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
public class Longest_Consecutive_Sequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i <nums.length; ++i){
            set.add(nums[i]);
        }

        int l = 0;
        for(int i = 0; i< nums.length; ++i){
            if(set.contains(nums[i])){
                l = 1;
                set.remove(nums[i]);
                int k = nums[i] + 1;
                while(set.contains(k)){
                    ++l;
                    set.remove(k);
                    ++k;
                }
                k = nums[i]-1;
                while(set.contains(k)){
                    ++l;
                    set.remove(k);
                    --k;
                }
                if(l > max)
                    max = l;
            }
        }
        return max;
    }
}
