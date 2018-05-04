/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode helper(int[] preorder, int i1, int j1, int[] inorder, int i2, int j2){
        if(j1 < i1) return null;
        TreeNode temp = new TreeNode(preorder[i1]);
        int k = i2;
        while(k <= j2){
            if(inorder[k] == preorder[i1]) break;
            ++k;
        }
        temp.left = helper(preorder,i1+1,i1 + (k - i2),inorder,i2,k-1);
        temp.right = helper(preorder,i1 + (k - i2) + 1,j1,inorder,k+1,j2);
        return temp;
    }

}
