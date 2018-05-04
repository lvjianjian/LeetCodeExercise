import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class Contains_Duplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
