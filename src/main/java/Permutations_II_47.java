import java.util.*;

/**
 * Created by zhongjianlv on 18-1-2.
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class Permutations_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length != 0) {
            permuteUnique_recursive(nums, 0, result);
        }
        return result;
    }

    public void permuteUnique_recursive(int[] nums, int k, List<List<Integer>> result) {
        if (k == nums.length - 1) {
            LinkedList<Integer> ints = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                ints.add(nums[i]);
            }
            result.add(ints);
            return;
        }

        for (int i = k; i < nums.length; i++) {
            if (i == k)
                permuteUnique_recursive(nums, k + 1, result);
            else {
                if (nums[i] > nums[i - 1]) {
                    moveInOrder(nums, i, k);
                    permuteUnique_recursive(nums, k + 1, result);
                    reduceInOrder(nums, i, k);
                }
            }
        }
    }


    private void moveInOrder(int[] nums, int src, int dest) {
        if (src == dest + 1) {
            change(nums, src, dest);
        } else {
            int temp = nums[src];
            while (src != dest) {
                change(nums, src, src - 1);
                --src;
            }
            nums[dest] = temp;
        }
    }

    private void reduceInOrder(int[] nums, int src, int dest) {
        if (src == dest + 1) {
            change(nums, src, dest);
        } else {
            int temp = nums[dest];
            while (src != dest) {
                change(nums, dest, dest + 1);
                ++dest;
            }
            nums[src] = temp;
        }
    }

    private void change(int[] nums, int i, int k) {
        nums[i] = nums[i] ^ nums[k];
        nums[k] = nums[i] ^ nums[k];
        nums[i] = nums[k] ^ nums[i];
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<String> unique = new HashSet<>();
        if (nums.length != 0) {
            permuteUnique_recursive2(nums, 0, result, unique);
        }
        return result;
    }


    public void permuteUnique_recursive2(int[] nums, int k, List<List<Integer>> result, Set<String> unique) {
        if (k == nums.length - 1) {
            LinkedList<Integer> ints = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                ints.add(nums[i]);
                sb.append(nums[i] + ",");
            }
            if (!unique.contains(sb.toString())) {
                result.add(ints);
                unique.add(sb.toString());
            }
            return;
        }

        for (int i = k; i < nums.length; i++) {
            if (i == k)
                permuteUnique_recursive2(nums, k + 1, result, unique);
            else {
                change(nums, i, k);
                permuteUnique_recursive2(nums, k + 1, result, unique);
                change(nums, i, k);
            }
        }
    }

    public static void main(String[] args) {
        Permutations_II_47 permutations_ii_47 = new Permutations_II_47();
        int[] ints = {1, 2, 3};
        System.out.println(permutations_ii_47.permuteUnique(ints));

    }
}
