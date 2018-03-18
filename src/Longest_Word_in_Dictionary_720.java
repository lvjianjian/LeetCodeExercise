import tool.LowercaseWordTrieNode;

/**
 * Created by zhongjianlv on 18-3-18.
 */
public class Longest_Word_in_Dictionary_720 {
    String r = "";

    public String longestWord(String[] words) {
        LowercaseWordTrieNode root = LowercaseWordTrieNode.buildRoot(words);
        LowercaseWordTrieNode c = root;
        helper(root);
        return r;
    }


    private void helper(LowercaseWordTrieNode current) {
        for (int i = 0; i < current.next.length; i++) {
            LowercaseWordTrieNode next = current.next[i];
            if (next == null) continue;
            if (next.count != 0) {
                if (next.word.length() > r.length()) {
                    r = next.word;
                }
                helper(next);
            }
        }
    }

}
