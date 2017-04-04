
/**
 * Created by zhongjian on 2017/4/1.
 *
 * leet code algorithm 3
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        int repeatIndex = -1;//在字串中重复字母的位置
        out:
        while (endIndex < s.length()){
            while (endIndex < s.length()){
                if((repeatIndex = s.substring(startIndex,endIndex).indexOf(s.charAt(endIndex))) == -1){
                    maxLength = Math.max(maxLength,endIndex - startIndex + 1);
                    endIndex++;
                }else {
                    startIndex = startIndex + repeatIndex + 1;
                    continue out;
                }

            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 longestSubstringWithoutRepeatingCharacters3 = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(longestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("abcabcbb".substring(1,3).indexOf("abcabcbb".charAt(1)));
    }
}
