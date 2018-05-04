import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-30.
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Subsets_II_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        for(int i = 0; i <= nums.length; ++i){
            helper(nums,0,i,r,result);
        }
        return result;
    }


    private void helper(int[] nums, int k, int n, List<Integer> r, List<List<Integer>> result){
        if(r.size() == n){
            result.add(new ArrayList<>(r));
            return;
        }

        for(int i =k;i < nums.length;++i){
            r.add(nums[i]);
            helper(nums,i+1,n,r,result);
            r.remove(r.size()-1);
            while(i+1 <nums.length && nums[i] == nums[i+1]) ++i;
        }
    }

}
