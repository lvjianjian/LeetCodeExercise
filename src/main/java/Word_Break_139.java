import java.util.*;

/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Word_Break_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
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
        return r[s.length()-1];
    }




    class TrieNode{
        boolean flag;
        TrieNode[] next;

        public TrieNode(){
            flag = false;
            next = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public boolean wordBreak2(String s, List<String> wordDict) {
        for(String word:wordDict){
            char[] cs = word.toCharArray();
            TrieNode current = root;
            for(char c:cs){
                if(current.next[c-'a'] == null){
                    current.next[c-'a'] = new TrieNode();
                }
                current = current.next[c-'a'];
            }
            current.flag = true;
        }
        return helper(s.toCharArray(),0,root);
    }


    private boolean helper(char[] s,int i, TrieNode c){
        if(i == s.length){
            if(c.flag) return true;
            else return false;
        }
        char n = s[i];
        TrieNode next = c.next[n-'a'];
        if(next == null) return false;
        if(next.flag){
            if(helper(s,i+1,root)) return true;
        }
        if(helper(s,i+1,next)) return true;
        return false;

    }


    private boolean helper2(int i, int end, Map<Integer, List<Integer>> map){
        if(i == end) return true;
        if(!map.containsKey(i)) return false;
        List<Integer> temp = map.get(i);
        for(int j : temp){
            if(helper2(j,end,map)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Word_Break_139 word_break_139 = new Word_Break_139();
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(word_break_139.wordBreak("aaaaaaa", wordDict));
    }
}
