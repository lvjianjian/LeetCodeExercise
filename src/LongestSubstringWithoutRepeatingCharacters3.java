
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
        out:
        while (endIndex < s.length()){
            endIndex = startIndex+1;
            maxLength = 0;
            while (endIndex < s.length()){
                if(s.substring(startIndex,endIndex).indexOf(s.charAt(endIndex)) == -1){
                    endIndex++;
                }else {//有重复
                    maxLength = Math.max(maxLength,endIndex - startIndex - 1);
                    startIndex = s.substring(startIndex,endIndex).indexOf(s.charAt(endIndex)) + 1;
                    continue out;
                }

            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 longestSubstringWithoutRepeatingCharacters3 = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(longestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring("abcabcbb"));
    }
}
