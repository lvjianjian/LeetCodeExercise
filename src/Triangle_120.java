import java.util.List;

/**
 * Created by zhongjianlv on 2018/2/23
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] r = new int[n];
        r[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == i) {
                    r[j] = r[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    r[j] = r[j] + triangle.get(i).get(j);
                } else {
                    r[j] = Math.min(r[j], r[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = r[0];
        for (int i = 1; i < n; ++i) {
            if (r[i] < min)
                min = r[i];
        }
        return min;
    }

}
