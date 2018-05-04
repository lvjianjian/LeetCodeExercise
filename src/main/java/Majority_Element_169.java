import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 2018/2/13
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Majority_Element_169 {


    public int majorityElement(int[] nums) {
        int count = 0;
        Integer num = null;
        for (int n : nums
                ) {
            if (count==0){
                num=n;
                count = 1;
            }else {
                count+=(n==num)?1:-1;
            }
        }
        return num;
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length;
        int c = n / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int k : nums){
            int temp = map.getOrDefault(k,0);
            if(temp + 1 > c){
                return k;
            }
            map.put(k,temp+1);
        }
        return 0;
    }
}

