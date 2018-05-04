import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhongjianlv on 18-2-27.
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Word_Pattern_290 {

    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        if(p.length == 0 && str.length() == 0) return true;
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int j = 0;
        while(j < str.length() && str.charAt(j) == ' ')
            ++j;

        for(int i = 0; i < p.length; ++i){
            char temp = p[i];
            int start = j;
            while(j < str.length() && str.charAt(j) != ' ')
                ++j;
            String temp2 = str.substring(start,j);
            if(temp2.equals("")) return false;
            while(j < str.length() && str.charAt(j) == ' ')
                ++j;
            if(map.containsKey(temp)){
                if(!map.get(temp).equals(temp2))
                    return false;
            }else{
                if(set.contains(temp2))
                    return false;
                set.add(temp2);
                map.put(temp,temp2);
            }
        }
        if(j < str.length())
            return false;
        else
            return true;
    }
}
