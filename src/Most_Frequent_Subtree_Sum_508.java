import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-30.
 * <p>
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * Examples 1
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class Most_Frequent_Subtree_Sum_508 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> sum_count = new HashMap<>();
        helper(root, sum_count);
        int max = 0;
        int size = 0;

        for (Integer count : sum_count.values()) {
            if (count == max) ++size;
            else if (count > max) {
                max = count;
                size = 1;
            }
        }

        int[] ints = new int[size];
        int k = 0;
        for (Integer sum : sum_count.keySet()) {
            if (sum_count.get(sum) == max) {
                ints[k++] = sum;
            }
        }
        return ints;
    }

    private int helper(TreeNode r, Map<Integer, Integer> sum_count) {
        if (r == null) return 0;
        int l_sum = helper(r.left, sum_count);
        int r_sum = helper(r.right, sum_count);
        int sum = l_sum + r_sum + r.val;
        sum_count.put(sum, sum_count.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public static void main(String[] args) {



        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        long start = System.nanoTime();
        int[] vs = new int[1];
        map.forEach((k, v) -> {
            if (v % 2 == 0)
                ++vs[0];
        });
        System.out.println(System.nanoTime() - start);


        start = System.nanoTime();
        int[] v3 = {0};
        map.keySet().forEach((k) -> {
            if (map.get(k) % 2 == 0)
                ++v3[0];
        });
        System.out.println(System.nanoTime() - start);


        start = System.nanoTime();
        int[] v2 = {0};
        for (Integer k : map.keySet()) {
            if (map.get(k) % 2 == 0)
                ++v2[0];
        }
        System.out.println(System.nanoTime() - start);


    }
}
