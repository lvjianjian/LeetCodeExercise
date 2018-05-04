/**
 * Created by zhongjianlv on 18-1-7.
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class Count_and_Say_38 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                char k = sb.charAt(j);
                int start = j;
                while (++j < sb.length() && sb.charAt(j) == k);
                result.append("" + (j-start) + k);
                --j;
            }
            sb = result;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Count_and_Say_38 count_and_say_38 = new Count_and_Say_38();
        System.out.println(count_and_say_38.countAndSay(5));
    }
}
