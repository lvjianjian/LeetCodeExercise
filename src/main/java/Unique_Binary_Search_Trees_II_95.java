import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-5.
 * <p>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Unique_Binary_Search_Trees_II_95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        List<TreeNode>[][] lists = new List[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                List<TreeNode> temp = new ArrayList<>();
                for (int k = j; k <= j + i; ++k) {
                    if (k - 1 < j) {
                        if (k + 1 > j + i) {
                            TreeNode t = new TreeNode(k + 1);
                            temp.add(t);
                        } else {
                            List<TreeNode> list = lists[k + 1][j + i];
                            for (int m = 0; m < list.size(); ++m) {
                                TreeNode t = new TreeNode(k + 1);
                                t.right = list.get(m);
                                temp.add(t);
                            }
                        }
                    } else if (k + 1 > j + i) {
                        if (k - 1 < j) {
                            TreeNode t = new TreeNode(k);
                            temp.add(t);
                        } else {
                            List<TreeNode> list = lists[j][k - 1];
                            for (int m = 0; m < list.size(); ++m) {
                                TreeNode t = new TreeNode(k + 1);
                                t.left = list.get(m);
                                temp.add(t);
                            }
                        }
                    } else {
                        List<TreeNode> list1 = lists[j][k - 1];
                        List<TreeNode> list2 = lists[k + 1][j + i];
                        for (int m = 0; m < list1.size(); ++m) {
                            for (int p = 0; p < list2.size(); ++p) {
                                TreeNode t = new TreeNode(k + 1);
                                t.left = list1.get(m);
                                t.right = list2.get(p);
                                temp.add(t);
                            }
                        }
                    }
                }
                lists[j][j + i] = temp;
            }
        }
        return lists[0][n - 1];
    }


    public static void main(String[] args) {
        Unique_Binary_Search_Trees_II_95 unique_binary_search_trees_ii_95 = new Unique_Binary_Search_Trees_II_95();
        unique_binary_search_trees_ii_95.generateTrees(0);
    }
}
