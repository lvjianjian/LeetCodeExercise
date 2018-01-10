import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Multiply_Strings_43 {

    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n]; //先确定数组长度

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply(String num1, String num2) {
        Map<Character, char[]> map = new HashMap<>();
        char[] chars2 = num2.toCharArray();
        char[] chars1 = num1.toCharArray();


        char temp_c = chars2[chars2.length - 1];
        char[] v = helper_mul(chars1, temp_c);
        String r = new String(v);
        map.put(temp_c, v);
        for (int i = chars2.length - 2; i >= 0; --i) {
            temp_c = chars2[i];

            if (map.containsKey(temp_c))
                v = map.get(temp_c);
            else {
                v = helper_mul(chars1, temp_c);
                map.put(temp_c, v);
            }

            r = helper_add(v, r, chars2.length - i);
        }

        int i = 0;
        while (i < r.length() - 1 && r.charAt(i) == '0') {++i;}

        return r.substring(i);
    }


    private char[] helper_mul(char[] chars, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        int jinwei = 0;
        int item = c - '0';
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            int temp = (aChar - '0') * item + jinwei;
            jinwei = temp / 10;
            stringBuilder.append(temp % 10);
        }
        while (jinwei != 0) {
            stringBuilder.append(jinwei % 10);
            jinwei = jinwei / 10;
        }
        return stringBuilder.reverse().toString().toCharArray();
    }


    private String helper_add(char[] v, String r, int jump) {
        StringBuilder sb = new StringBuilder();
        char[] r_chars = r.toCharArray();
        int i = r.length() - 1;
        int j = v.length - 1;
        while (i > r.length() - jump) {
            sb.append(r_chars[i--]);
        }
        int jinwei = 0;
        while (i >= 0 && j >= 0) {
            int temp = (r_chars[i--] - '0') + (v[j--] - '0') + jinwei;
            sb.append(temp % 10);
            jinwei = temp / 10;
        }

        while (i >= 0) {
            int temp = (r_chars[i--] - '0') + jinwei;
            sb.append(temp % 10);
            jinwei = temp / 10;
        }

        while (j >= 0) {
            int temp = (v[j--] - '0') + jinwei;
            sb.append(temp % 10);
            jinwei = temp / 10;
        }

        while (jinwei != 0) {
            sb.append(jinwei % 10);
            jinwei /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply_Strings_43 multiply_strings_43 = new Multiply_Strings_43();
        System.out.println(multiply_strings_43.multiply("122131","0"));
    }

}
