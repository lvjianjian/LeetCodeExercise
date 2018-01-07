import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-7.
 * <p>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Combination_Sum_II_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new LinkedList<>();
        int[] result = new int[candidates.length];
        helper(candidates, target, 0, result, 0, results);
        return results;
    }


    private void helper(int[] candidates, int target, int start, int[] result, int k, List<List<Integer>> results) {
        int pre = 0;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] == pre)
                continue;
            pre = candidates[i];
            int t = target - candidates[i];
            result[k] = candidates[i];
            if (t < 0) return;
            else if (t == 0) {
                LinkedList<Integer> temp = new LinkedList<>();
                for (int j = 0; j <= k; j++) {
                    temp.add(result[j]);
                }
                results.add(temp);
                return;
            } else {
                helper(candidates, t, i + 1, result, k + 1, results);
            }
        }
    }

    public static void main(String[] args) {
        Combination_Sum_II_40 combination_sum_ii_40 = new Combination_Sum_II_40();
        List<List<Integer>> lists = combination_sum_ii_40.combinationSum2(new int[]{10, 1, 1, 2, 7, 6, 1, 5}, 8);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            System.out.println(list);
        }
    }


}
