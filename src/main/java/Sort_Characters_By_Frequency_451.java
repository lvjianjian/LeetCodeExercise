import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by zhongjianlv on 18-3-19.
 * <p>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class Sort_Characters_By_Frequency_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > max)
                max = map.get(c);
        }
        StringBuilder[] sbs = new StringBuilder[max + 1];
        map.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                if (sbs[integer] == null)
                    sbs[integer] = new StringBuilder();
                for (int i = 0; i < integer; i++) {
                    sbs[integer].append(character);
                }
            }
        });
        if (sbs[max] == null)
            sbs[max] = new StringBuilder();
        for (int i = max - 1; i > 0; --i) {
            if (sbs[i] != null)
                sbs[max].append(sbs[i]);
        }
        return sbs[max].toString();
    }

    public static void main(String[] args) {
        Sort_Characters_By_Frequency_451 sort_characters_by_frequency_451 = new Sort_Characters_By_Frequency_451();
        System.out.println(sort_characters_by_frequency_451.frequencySort("tree"));
    }
}
