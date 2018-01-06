/**
 * Created by zhongjianlv on 18-1-6.
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Add_Binary_67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int jinwei = 0;
        int i = a.length() - 1, j = b.length() - 1;
        for (; i >= 0 && j >= 0; --i, --j) {
            int ca = a.charAt(i) - '0';
            int cb = b.charAt(j) - '0';
            int sum = ca + cb + jinwei;
            sb.append(sum % 2);
            jinwei = sum >= 2 ? 1 : 0;
        }

        while (i >= 0) {
            int cb = a.charAt(i) - '0';
            int sum = cb + jinwei;
            sb.append(sum % 2);
            jinwei = sum >= 2 ? 1 : 0;
            --i;
        }

        while (j >= 0) {
            int cb = b.charAt(j) - '0';
            int sum = cb + jinwei;
            sb.append(sum % 2);
            jinwei = sum >= 2 ? 1 : 0;
            --j;
        }
        if(jinwei == 1)
            sb.append("1");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        Add_Binary_67 add_binary_67 = new Add_Binary_67();
        System.out.println(add_binary_67.addBinary("111","1"));
    }

}
