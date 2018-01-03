import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-1-3.
 * <p>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Letter_Combinations_of_a_Phone_Number_17 {

    private static final HashMap<Character, String> map = new HashMap();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits == null || digits.length() == 0)
            return result;
        char[] now = new char[digits.length()];
        helper(0, digits, now, result);
        return result;
    }

    private void helper(int k, String digits, char[] now, List<String> result) {
        if (k == digits.length()) {
            result.add(new String(now));
            return;
        }

        char c = digits.charAt(k);
        String s = map.get(c);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            now[k] = chars[i];
            helper(k + 1, digits, now, result);
        }

    }

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number_17 letter_combinations_of_a_phone_number_17 = new Letter_Combinations_of_a_Phone_Number_17();
        System.out.println(letter_combinations_of_a_phone_number_17.letterCombinations("23"));

    }
}
