import java.util.HashSet;

/**
 * Created by zhongjianlv on 18-5-6.
 * <p>
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class Friend_Circles_547 {


    //无向图检测圈个数，使用并查集
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    parents[parentWithPathCompress(i, parents)] = parentWithPathCompress(j, parents);
                }
            }
        }
        HashSet<Integer> ps = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            ps.add(parent(i, parents));// 即使路径压缩也要再次访问节点时候才会执行，因此这里还是需要用parent函数而不能直接用parents
        }
        return ps.size();
    }


    private int parent(int i, int[] p) {
        while (p[i] != i) {
            i = p[i];
        }
        return i;
    }

    private int parentWithPathCompress(int i, int[] p) {
        int root = i;
        while (p[root] != root) {
            root = p[root];
        }
        //路径压缩
        while (p[i] != i) {
            p[i] = root;
            i = p[i];
        }
        return root;
    }

}
