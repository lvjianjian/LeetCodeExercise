import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Word_Break_II_140 {


    //先判断再找
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<Integer> wordLength = new HashSet<>();
        Set<String> words = new HashSet<>();
        for(String word: wordDict){
            words.add(word);
            wordLength.add(word.length());
        }
        boolean[] r = new boolean[s.length()];
        for(int i = 0; i < s.length(); ++i){
            if(words.contains(s.substring(0,i+1))){
                r[i] = true;
                continue;
            }
            for(int length: wordLength){
                if(i + 1 - length > 0){
                    if(r[i-length] && words.contains(s.substring(i+1-length, i+1))){
                        r[i] = true;
                        break;
                    }
                }
            }
        }
        if(!r[s.length()-1]) return new ArrayList<String>();
        List<String>[] rs = new List[s.length()];
        for(int i = 0; i < s.length(); ++i){
            String temp = s.substring(0,i+1);
            if(words.contains(temp)){
                rs[i] = new ArrayList<>();
                if(i != s.length()-1)
                    rs[i].add(temp+" ");
                else rs[i].add(temp);
            }
            for(int length: wordLength){
                if(i + 1 - length > 0){
                    temp = s.substring(i+1-length, i+1);
                    if(rs[i-length] != null && words.contains(temp)){
                        if(rs[i] == null)
                            rs[i] = new ArrayList<>();
                        for(String prefix:rs[i-length])
                            if(i!=s.length()-1)
                                rs[i].add(prefix + temp + " ");
                            else rs[i].add(prefix + temp);
                    }
                }
            }
        }
        return rs[s.length()-1];
    }
}
