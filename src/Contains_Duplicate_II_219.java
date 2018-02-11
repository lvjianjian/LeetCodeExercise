import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 2018/2/11
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class Contains_Duplicate_II_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length < 2 || k == 0) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i){
            int num = nums[i];
            if(map.containsKey(num)){
                if(i - map.get(num) <= k) return true;
            }
            map.put(num,i);
        }
        return false;
    }
}
