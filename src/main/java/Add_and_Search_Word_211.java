/**
 * Created by zhongjianlv on 2018/2/18
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * For example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class Add_and_Search_Word_211 {

    class TrieNode{
        TrieNode[] next;
        String word;

        TrieNode(){
            next = new TrieNode[26];
            word = null;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Add_and_Search_Word_211() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] cc = word.toCharArray();
        TrieNode current = root;
        for(int i = 0;i < cc.length; ++i){
            int index = cc[i] - 'a';
            if(current.next[index] == null)
                current.next[index] = new TrieNode();
            current = current.next[index];
        }
        current.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] c = word.toCharArray();
        return helper(c,0, root);
    }

    private boolean helper(char[] c, int i,TrieNode current){
        if(i == c.length){
            if(current.word != null)
                return true;
            else return false;
        }
        char temp = c[i];
        if(temp == '.'){
            for(int j = 0; j < 26; ++j){
                if(current.next[j]!=null)
                    if(helper(c,i+1,current.next[j])) return true;
            }
            return false;
        }else{
            int index = temp - 'a';
            if(current.next[index] == null) return false;
            return helper(c,i+1,current.next[index]);
        }
    }
}
