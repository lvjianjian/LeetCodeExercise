import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhongjianlv on 17-12-22.
 * <p>
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 */
public class Longest_Univalue_Path_687 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int len = 0;

    /**
     *
     * 返回与父节点值相同时的最长路径
     *
     * @param node 当前节点
     * @param val 父节点的值
     * @return
     */
    public int getLen(TreeNode node, int val){
        if(node ==null)
            return 0;

        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);

        len = Math.max(len, left + right);
        if(node.val == val) return Math.max(left,right) + 1;
        else return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        if(root ==null)
            return 0;
        getLen(root, root.val);
        return len;
    }


}
