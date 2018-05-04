import java.util.*;

/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * <p>
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class Keyboard_Row_500 {
    private static String[] strings = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    private static Map<Character, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map.put(chars[j], i);
                map.put(Character.toUpperCase(chars[j]), i);
            }
        }
    }

    public String[] findWords(String[] words) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int num = map.get(chars[0]);
            int j;
            for (j = 1; j < chars.length; j++) {
                if (map.get(chars[j]) != num)
                    j = chars.length;
            }
            if (j == chars.length){
                ints.add(i);
            }
        }
        String[] strings = new String[ints.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = words[ints.get(i)];
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(Character.toLowerCase('a'));
    }
}
