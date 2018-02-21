import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 2018/2/21
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Path_Sum_II_113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        helper(root,sum,r,result);
        return result;
    }

    private void helper(TreeNode n, int c, List<Integer> r, List<List<Integer>> result){
        if(n == null) return;
        r.add(n.val);
        c -= n.val;
        if(n.left ==null && n.right==null && c == 0){
            List<Integer> l = new LinkedList<>(r);
            result.add(l);
        }else{
            helper(n.left,c,r,result);
            helper(n.right,c,r,result);
        }
        c+= n.val;
        r.remove(r.size() - 1);
    }
}
