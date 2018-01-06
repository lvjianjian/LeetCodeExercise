import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-6.
 * <p>
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2:
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */
public class String_Compression_443 {

    public int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;
        int index = 0;
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == 0 || i == chars.length || chars[i] != chars[i - 1]) {
                int num = i - start;
                if (num > 1) {
                    String s = String.valueOf(num);
                    for (int j = 0; j < s.length(); j++) {
                        char c = s.charAt(j);
                        chars[index++] = c;
                    }
                }
                if(i != chars.length)
                    chars[index++] = chars[i];
                start = i;
            }
        }
        return index;
    }


    public int compress2(char[] chars) {
        if (chars.length <= 1)
            return chars.length;
        int index = 0;
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == 0 || i == chars.length || chars[i] != chars[i - 1]) {
                int num = i - start;
                if (num > 1) {
                    String s = String.valueOf(num);
                    for (int j = 0; j < s.length(); j++) {
                        char c = s.charAt(j);
                        chars[++index] = c;
                    }
                    if (i != chars.length)
                        chars[++index] = chars[i];
                    else ++index;
                } else if (i != 0 && i != chars.length) {
                    chars[++index] = chars[i];
                } else if (i == chars.length)
                    ++index;
                start = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String_Compression_443 string_compression_443 = new String_Compression_443();
        char[] chars = new char[]{'a', 'a' , 'a','b','b','b','a','b','c'};
        System.out.println(string_compression_443.compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
