/**
 * Created by zhongjianlv on 2018/2/8
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Remove_K_Digits_402 {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        if (k == 0) return String.valueOf(num);
        char[] nn = num.toCharArray();
        int i = 0;
        int j = 1;
        int[] remove = new int[nn.length];
        while (k != 0 && j < nn.length) {
            while (k != 0 && i >= 0) {
                if (remove[i] == 1) {
                    --i;
                    continue;
                }
                if (nn[i] > nn[j]) {
                    remove[i] = 1;
                    --k;
                    --i;
                } else {
                    break;
                }
            }
            i = j;
            j = i + 1;
        }
        for (i = nn.length - 1; i >= 0; --i) {
            if (k == 0) break;
            if (remove[i] == 0) {
                remove[i] = 1;
                --k;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (i = 0; i < nn.length; ++i) {
            if (remove[i] == 0)
                if (flag || nn[i] != '0') {
                    flag = true;
                    sb.append(nn[i]);
                }
        }
        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }

}
