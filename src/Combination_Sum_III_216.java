import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * <p>
 * [[1,2,4]]
 * <p>
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * <p>
 * [[1,2,6], [1,3,5], [2,3,4]]
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class Combination_Sum_III_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] ints = new int[9];
        List<List<Integer>> results = new LinkedList<>();
        if(k == 0)
            return results;
        else if(k==1){
            if(n > 0 && n < 10) {
                LinkedList<Integer> e = new LinkedList<>();
                e.add(n);
                results.add(e);
            }
        }else {
            helper(n, k, 1, ints, 0, results);
        }
        return results;
    }


    private void helper(int target, int num, int start, int[] result, int k, List<List<Integer>> results) {
        if(k == num - 2){
            for (int j = start; j <= 9; j++) {
                if(target > j && target - j > j && target -j <=9) {
                    result[k] = j;
                    result[k+1] = target - j;
                    LinkedList<Integer> ints = new LinkedList<>();
                    for (int i = 0; i <= k + 1; i++) {
                        ints.add(result[i]);
                    }
                    results.add(ints);
                }
            }
        }

        for (int i = start; i <= 9; i++) {
            if(target >= i){
                result[k] = i;
                helper(target-i,num,i+1,result,k+1,results);
            }
        }
    }

    public static void main(String[] args) {
        Combination_Sum_III_216 combination_sum_iii_216 = new Combination_Sum_III_216();
        List<List<Integer>> lists = combination_sum_iii_216.combinationSum3(3, 9);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
