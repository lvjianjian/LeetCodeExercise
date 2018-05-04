import java.util.*;

/**
 * Created by zhongjianlv on 18-1-7.
 * <p>
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class Combination_Sum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int min = candidates[0];
        int num = target / min + 1;
        int[] ints = new int[num];
        List<List<Integer>> result = new LinkedList<>();
        helper(candidates, target, 0, ints, 0, result);
        return result;
    }

    private void helper(int[] candidates, int target, int start, int[] result, int k, List<List<Integer>> results) {
        if(start >= candidates.length) return;
        target -= candidates[start];
        if (target == 0) {
            result[k] = candidates[start];
            LinkedList<Integer> ints = new LinkedList<>();
            for (int i = 0; i <= k; i++) {
                ints.add(result[i]);
            }
            results.add(ints);
            return;
        } else if (target < 0) {
            return;
        } else {
            result[k] = candidates[start];
            helper(candidates, target, start, result, k + 1, results);

            target += candidates[start];
            helper(candidates, target, start + 1, result, k, results);

        }
    }

    public static void main(String[] args) {

        Combination_Sum_39 combination_sum_39 = new Combination_Sum_39();
        List<List<Integer>> lists = combination_sum_39.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            System.out.println(list);
        }
    }
}
