/**
 * Created by zhongjianlv on 2018/2/21
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0, inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode helper(int[] inorder,int ins,int ine, int[] postorder,int posts, int poste){
        if(ine < ins) return null;
        TreeNode temp = new TreeNode(postorder[poste]);
        int s = ins;
        while(s <= ine){
            if(inorder[s] == temp.val)
                break;
            ++s;
        }
        temp.left = helper(inorder,ins,s-1,postorder,posts,posts+s-ins - 1);
        temp.right = helper(inorder,s+1,ine,postorder,posts+s-ins,poste-1);
        return temp;
    }
}
