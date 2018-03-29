import java.util.*;

/**
 * Created by zhongjianlv on 18-3-29.
 * <p>
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * <p>
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * <p>
 * Output: "45"
 */
public class Reconstruct_Original_Digits_from_English_423 {


    public String originalDigits2(String s) {
        int[] count=new int[10];
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            switch(c)
            {
                case 'z':count[0]++;break;
                case 'w':count[2]++;break;
                case 'u':count[4]++;break;
                case 'x':count[6]++;break;
                case 'g':count[8]++;break;
                case 'o':count[1]++;break;
                case 't':count[3]++;break;
                case 'f':count[5]++;break;
                case 'v':count[7]++;break;
                case 'i':count[9]++;break;
                default:break;
            }
        }
        count[1]=count[1]-count[0]-count[2]-count[4];
        count[3]=count[3]-count[2]-count[8];
        count[5]=count[5]-count[4];
        count[7]=count[7]-count[5];
        count[9]=count[9]-count[6]-count[8]-count[5];
        StringBuffer res=new StringBuffer();
        for(int i=0;i<count.length;i++)
            for(int j=0;j<count[i];j++)
                res.append(i);
        return res.toString();
    }

    static String[][] sequence;

    static {
        sequence();
    }

    private static void sequence() {
        sequence = new String[10][3];

        Set<String> hasAdded = new HashSet<>();

        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Integer> englishToInteger = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            englishToInteger.put(strings[i], i);
        }
        Map<Character, Set<String>> map = new HashMap<>();
        for (String string : strings) {
            for (char c : string.toCharArray()) {
                if (!map.containsKey(c))
                    map.put(c, new HashSet<>());
                map.get(c).add(string);
            }
        }


        Set<String> remove = new HashSet<>();
        do {
            Iterator<Character> iterator = map.keySet().iterator();
            if (!remove.isEmpty()) {
                for (String s : remove) {
                    for (char c : s.toCharArray()) {
                        if (map.get(c).contains(s)) {
                            map.get(c).remove(s);
                        }
                    }
                }
            }
            remove.clear();

            while (iterator.hasNext()) {
                Character next = iterator.next();
                Set<String> item = map.get(next);
                if (item.size() == 1) {
                    String only = item.iterator().next();
                    if (!hasAdded.contains(only)) {
//                        System.out.println(next + ":" + only);
                        sequence[hasAdded.size()][0] = "" + next;
                        sequence[hasAdded.size()][1] = only;
                        sequence[hasAdded.size()][2] = englishToInteger.get(only) + "";
                        hasAdded.add(only);
                        remove.add(only);
                    }
                }
            }
        } while (remove.size() != 0);
    }


    public String originalDigits(String s) {
        List<Integer> r = new ArrayList<>();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        for (int i = 0; i < sequence.length; i++) {
            int index = sequence[i][0].charAt(0) - 'a';
            String english = sequence[i][1];
            int num = Integer.valueOf(sequence[i][2]);
            int c = count[index];
            if (c == 0) continue;
            for (int k = 0; k < c; k++) {
                r.add(num);
            }
            for (char re_c : english.toCharArray()) {
                count[re_c - 'a'] -= c;
            }
        }
        Collections.sort(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.size(); i++) {
            sb.append(r.get(i));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Reconstruct_Original_Digits_from_English_423 reconstruct_original_digits_from_english_423 = new Reconstruct_Original_Digits_from_English_423();
        System.out.println(reconstruct_original_digits_from_english_423.originalDigits("fviefuro"));
    }
}
