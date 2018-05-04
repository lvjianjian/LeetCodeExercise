/**
 * Created by zhongjianlv on 18-4-11.
 * <p>
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 * <p>
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 * 示例 2:
 * <p>
 * 输入: n = 3, k = 1
 * 输出: 2
 * 解释:
 * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 * 说明:
 * <p>
 * n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。
 */
public class K_Inverse_Pairs_Array_629 {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if (k == 0) return 1;
        int k_max = n * (n - 1) / 2;
        if (k > k_max) return 0;
        if (k == k_max) return 1;
        int[][] temp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            temp[i][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < i) {
                    temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
                } else {
                    temp[i][j] = temp[i][j - 1] - temp[i - 1][j - i] + temp[i - 1][j];
                }
                if (temp[i][j] < 0) temp[i][j] += mod;
                else temp[i][j] %= mod;
            }
        }
        return temp[n][k];
    }


    public static void main(String[] args) {
        K_Inverse_Pairs_Array_629 k_inverse_pairs_array_629 = new K_Inverse_Pairs_Array_629();
        System.out.println(k_inverse_pairs_array_629.kInversePairs(20, 39));
    }
}
