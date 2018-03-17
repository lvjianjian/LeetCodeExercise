/**
 * Created by zhongjianlv on 18-3-16.
 * <p>
 * Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * <p>
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Follow up:
 * How would you handle overflow for very large input integers?
 */
public class Additive_Number_306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                if (helper(num, 0, i, j)) return true;
            }
        }
        return false;
    }


    private boolean helper(String num, int s, int i, int j) {
        if (j == num.length()) return true;
        if (j - i > 1 && num.charAt(i) == '0') return false;
        String sum = sum(num.substring(s, i), num.substring(i, j));
        for (int k = j; k < j + sum.length(); k++) {
            if (k >= num.length() || num.charAt(k) != sum.charAt(k - j))
                return false;
        }
        return helper(num, i, j, j + sum.length());
    }

    private String sum(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;
        int jinwei = 0;
        int v;
        while (n1 >= 0 && n2 >= 0) {
            v = s1.charAt(n1--) - '0' + s2.charAt(n2--) - '0' + jinwei;
            sb.append(v % 10);
            jinwei = v / 10;
        }

        while (n1 >= 0) {
            v = s1.charAt(n1--) - '0' + jinwei;
            sb.append(v % 10);
            jinwei = v / 10;
        }

        while (n2 >= 0) {
            v = s2.charAt(n2--) - '0' + jinwei;
            sb.append(v % 10);
            jinwei = v / 10;
        }
        if (jinwei > 0)
            sb.append(jinwei);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        Additive_Number_306 additive_number_306 = new Additive_Number_306();
        System.out.println(additive_number_306.isAdditiveNumber("101"));
    }
}
