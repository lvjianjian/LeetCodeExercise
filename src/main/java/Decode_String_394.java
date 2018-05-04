/**
 * Created by zhongjianlv on 18-3-28.
 * <p>
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Decode_String_394 {
    private int index = 0;

    public String decodeString(String s) {
        index = 0;
        StringBuilder sb = new StringBuilder();
        s = "[" + s + "]";
        return helper(s);
    }

    private String helper(String s) {
        ++index;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int num = nextInt(s);
                String subs = helper(s);
                for (int i = 0; i < num; i++) {
                    sb.append(subs);
                }
            } else if (s.charAt(index) == ']') {
                index++;
                return sb.toString();
            } else {
                sb.append(s.charAt(index++));
            }
        }
        return sb.toString();
    }


    private int nextInt(String s) {
        int i = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            i = i * 10 + (s.charAt(index++) - '0');
        }
        return i;
    }

    public static void main(String[] args) {
        Decode_String_394 decode_string_394 = new Decode_String_394();
        System.out.println(decode_string_394.decodeString("3[a]2[bc]"));
        System.out.println(decode_string_394.decodeString("3[a2[c]]"));
        System.out.println(decode_string_394.decodeString("2[abc]3[cd]ef"));
    }
}
