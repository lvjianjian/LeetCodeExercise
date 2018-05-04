import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-8.
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class Reverse_Words_in_a_String_III_557 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                int end = i - 1;
                swap(chars,start,end);
                start = i + 1;
            }
        }
        swap(chars,start,chars.length-1);
        return new String(chars);
    }

    private void swap(char[] chars, int start, int end){
        while (start < end){
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start++] ^= chars[end--];
        }
    }


    public static void main(String[] args) {
        Reverse_Words_in_a_String_III_557 reverse_words_in_a_string_iii_557 = new Reverse_Words_in_a_String_III_557();
        System.out.println(reverse_words_in_a_string_iii_557.reverseWords("hello baby"));
    }
}
