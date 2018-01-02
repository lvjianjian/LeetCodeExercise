import java.util.*;

/**
 * Created by zhongjianlv on 18-1-2.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute_recursive(nums, 0, result);
        return result;
    }

    public void permute_recursive(int[] nums, int k, List<List<Integer>> result) {
        if (k == nums.length - 1) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            if (i == k)
                permute_recursive(nums, k + 1, result);
            else {
                nums[k] = nums[k] ^ nums[i];
                nums[i] = nums[k] ^ nums[i];
                nums[k] = nums[i] ^ nums[k];
                permute_recursive(nums, k + 1, result);
                nums[k] = nums[k] ^ nums[i];
                nums[i] = nums[k] ^ nums[i];
                nums[k] = nums[i] ^ nums[k];
            }
        }
    }

    public static void main(String[] args) {
        Permutations_46 permutations_46 = new Permutations_46();
        System.out.println(permutations_46.permute(new int[]{1, 2, 3, 4}));

    }
}
