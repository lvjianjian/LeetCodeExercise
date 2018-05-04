import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhongjianlv on 18-4-20.
 * <p>
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * Example 2:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 */
public class Two_Sum_IV_Input_is_a_BST_653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> l = new HashSet<>(100);
        return helper2(root, l, k);
    }

    private boolean helper2(TreeNode root, Set<Integer> l, int k) {
        if (root == null) return false;
        if(helper2(root.left, l, k)) return true;
        if(l.contains(k - root.val)) return true;
        l.add(root.val);
        if(helper2(root.right, l, k)) return true;
        return false;
    }


    //slow
    private boolean helper(TreeNode small, TreeNode large, int k) {
        if (small == null || large == null) return false;
        int sum = small.val + large.val;
        if (sum == k) {
            if (small != large) return true;
            if (helper(small.left, large.right, k)) return true;
            if (helper(small.right, large.left, k)) return true;
        } else if (sum < k) {
            if (helper(small.right, large, k)) return true;
            if (helper(small, large.right, k)) return true;
        } else {
            if (helper(small.left, large, k)) return true;
            if (helper(small, large.left, k)) return true;
        }
        return false;
    }
}
