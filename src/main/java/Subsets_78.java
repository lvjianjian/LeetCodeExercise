import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-22.
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int[] r = new int[nums.length];
        for(int i = 0;i <= nums.length; ++i)
            helper(nums,i,0,0,result,r);
        return result;
    }


    private void helper(int[] nums, int all, int k, int c, List<List<Integer>> result, int[] r){
        if(k == all){
            List<Integer> temp = new LinkedList<>();
            for(int i =0 ; i < all; ++i)
                temp.add(r[i]);
            result.add(temp);
            return;
        }

        for(int i = c; i < nums.length; ++i){
            r[k] = nums[i];
            helper(nums,all,k+1,i+1,result,r);
        }
    }

    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        subsets_78.subsets(new int[]{1,2,3});
    }
}
