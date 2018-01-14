import java.util.*;

/**
 * Created by zhongjianlv on 18-1-14.
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        for(String s: strs){
            char[] cc = s.toCharArray();
            Arrays.sort(cc);
            String ss = new String(cc);
            if(map.containsKey(ss)){
                map.get(ss).add(s);
            }else{
                List<String> l = new LinkedList<>();
                l.add(s);
                result.add(l);
                map.put(ss,l);
            }
        }
        return result;
    }
}
