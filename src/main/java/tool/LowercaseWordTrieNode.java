package tool;

/**
 * Created by zhongjianlv on 18-3-18.
 */
public class LowercaseWordTrieNode {

    public LowercaseWordTrieNode[] next;
    public String word;
    public int count;

    public LowercaseWordTrieNode() {
        next = new LowercaseWordTrieNode[26];
        word = null;
    }

    public static LowercaseWordTrieNode buildRoot(String[] words) {
        LowercaseWordTrieNode root = new LowercaseWordTrieNode();
        LowercaseWordTrieNode p;
        for (String word : words) {
            p = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new LowercaseWordTrieNode();
                }
                p = p.next[index];
            }
            p.word = word;
            p.count += 1;
        }
        return root;
    }
}
