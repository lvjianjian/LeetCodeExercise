/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Implement_Trie_Prefix_Tree_208 {
    class TrieNode {
        TrieNode[] next;
        String word;

        public TrieNode() {
            next = new TrieNode[26];
            word = null;
        }


    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Implement_Trie_Prefix_Tree_208() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null)
                p.next[index] = new TrieNode();
            p = p.next[index];
        }
        p.word = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null)
                return false;
            p = p.next[index];
        }
        if (p.word != null) return true;
        else return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null)
                return false;
            p = p.next[index];
        }
        return helper(p);
    }

    private boolean helper(TrieNode p) {
        if (p == null) return false;
        if (p.word != null) return true;
        for (int i = 0; i < 26; ++i) {
            if (helper(p.next[i])) return true;
        }
        return false;
    }
}
