import java.util.*;

/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class Contains_Duplicate_III_220 {

    //bucket O(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){
            long mapnum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = mapnum / ((long)t + 1);
            if(map.containsKey(bucket) ||
                    (map.containsKey(bucket-1) && (mapnum - map.get(bucket - 1)) <= t)
                    || (map.containsKey(bucket+1) && (map.get(bucket+1) - mapnum) <= t))
                return true;
            map.put(bucket,mapnum);
            if(i >= k){
                map.remove(((long)nums[i-k] - Integer.MIN_VALUE)/((long)t + 1));
            }
        }
        return false;
    }

    //TreeSet O(n*logk)
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Long floor = set.floor((long) nums[i] + t);
            if (floor != null && floor + t >= nums[i])
                return true;
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_Duplicate_III_220 contains_duplicate_iii_220 = new Contains_Duplicate_III_220();
        System.out.println(contains_duplicate_iii_220.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
    }
}
