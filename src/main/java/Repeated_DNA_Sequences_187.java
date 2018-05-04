import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-2.
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * For example,
 * <p>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class Repeated_DNA_Sequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> r = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - 9; ++i){
            String temp = s.substring(i,i+10);
            int count = map.getOrDefault(temp,0);
            ++count;
            if(count == 2) r.add(temp);
            map.put(temp,count);
        }
        return r;
    }
}
