import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-17.
 * <p>
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
public class Text_Justification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length; ++i) {
            int k = i;
            int sum = -1;
            while (k < words.length && words[k].length() + sum + 1 <= maxWidth)
                sum += (1 + words[k++].length());
            StringBuilder sb = new StringBuilder();
            int num = k - i;
            sum -= (num - 1);
            int empty = maxWidth - sum;
            if (num == 1) {
                sb.append(words[i]);
                while (empty != 0) {
                    sb.append(' ');
                    --empty;
                }
            } else {
                if (k == words.length) {
                    for (int j = 0; j < num; ++j) {
                        sb.append(words[i + j]);
                        if (empty != 0) {
                            sb.append(' ');
                            --empty;
                        }
                    }
                    while (empty != 0) {
                        sb.append(' ');
                        --empty;
                    }
                } else {
                    int each = empty / (num - 1);
                    int extra = empty % (num - 1);
                    for (int j = 0; j < num; ++j) {
                        sb.append(words[i + j]);
                        if (j != num - 1) {
                            for (int m = 0; m < each; ++m)
                                sb.append(' ');
                            if (j < extra)
                                sb.append(' ');
                        }
                    }
                }
                i = k - 1;
            }
            result.add(sb.toString());
        }
        return result;
    }
}
