/**
 * Created by zhongjianlv on 18-1-3.
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Reverse_String_344 {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int l = 0, h = chars.length - 1;
        while (l<h){
            chars[l] = (char)(chars[l] ^ chars[h]);
            chars[h] = (char)(chars[l] ^ chars[h]);
            chars[l] = (char)(chars[h] ^ chars[l]);
            ++l;
            --h;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Reverse_String_344 reverse_string_344 = new Reverse_String_344();
        System.out.println(reverse_string_344.reverseString("abc"));
    }
}
