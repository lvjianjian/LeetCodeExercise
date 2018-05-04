import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> nodes = new ArrayList<>();
        boolean flag = true;
        int current = 0;
        int all = 0;
        nodes.add(root);
        TreeNode temp = null;
        while(current != nodes.size()){
            List<Integer> r = new ArrayList<>();
            all = nodes.size();
            for(int i = all - 1; i >= current; --i){
                temp = nodes.get(i);
                if(temp == null) continue;
                r.add(temp.val);
                if(flag){
                    nodes.add(temp.left);
                    nodes.add(temp.right);
                }else{
                    nodes.add(temp.right);
                    nodes.add(temp.left);
                }
            }
            flag = !flag;
            if(r.size() != 0)
                result.add(r);
            current = all;
        }
        return result;
    }
}
