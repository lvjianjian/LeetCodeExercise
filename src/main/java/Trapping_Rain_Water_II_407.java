import java.util.*;

/**
 * Created by zhongjianlv on 18-1-5.
 * <p>
 * 给定一个m x n的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * 说明:
 * <p>
 * m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。
 * <p>
 * 示例：
 * <p>
 * 给出如下 3x6 的高度图:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * 返回 4。
 */
public class Trapping_Rain_Water_II_407 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] ranges = new int[m][2];
        for (int i = 0; i < m; i++) {
            ranges[i][0] = scanner.nextInt();
            ranges[i][1] = scanner.nextInt();
        }
        HashMap[] maps = new HashMap[m];
        for (int i = 0; i < m; i++) {
            maps[i] = new HashMap();
        }
        System.out.println(helper(ranges, n, m - 1, maps));
    }

    private static int helper(int[][] ranges, int n, int max_range, HashMap[] map) {
        if (max_range == 1) {
            int max = n - ranges[1][0];
            int min = n - ranges[1][1];
            min = Math.max(min, ranges[0][0]);
            max = Math.min(max, ranges[0][1]);
            int l = max - min + 1;
            l = l > 0 ? l : 0;
            map[1].put(n, l);
            return l;
        }

        int sum = 0;
        for (int i = ranges[max_range][0]; i <= ranges[max_range][1]; i++) {
            if (map[max_range - 1].containsKey(n - i))
                sum += (int) map[max_range - 1].get(n - i);
            else sum += helper(ranges, n - i, max_range - 1, map);
        }
        return sum;
    }

}
