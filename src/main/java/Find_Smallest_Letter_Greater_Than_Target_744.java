/**
 * Created by zhongjianlv on 18-2-8.
 * <p>
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class Find_Smallest_Letter_Greater_Than_Target_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0;
        int j = letters.length - 1;
        char r = 'A';
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (letters[mid] > target) {
                r = letters[mid];
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (r == 'A')
            return letters[0];
        else return r;
    }
}
