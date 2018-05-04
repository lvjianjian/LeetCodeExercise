/**
 * Created by zhongjianlv on 18-3-19.
 * <p>
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 * <p>
 * Example:
 * <p>
 * Input:
 * s = "abcd"
 * t = "abcde"
 * <p>
 * Output:
 * e
 * <p>
 * Explanation:
 * 'e' is the letter that was added.
 */
public class Find_the_Difference_389 {
    public char findTheDifference(String s, String t) {
        int r = 0;
        for (char c : s.toCharArray()) {
            r += (int) c;
        }
        for (char c : t.toCharArray()) {
            r -= (int) c;
        }

        return (char) -r;
    }
}
