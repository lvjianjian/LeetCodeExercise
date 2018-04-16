import tool.LowercaseWordTrieNode;

/**
 * Created by zhongjianlv on 18-4-16.
 * <p>
 * Implement a magic directory with buildDict, and search methods.
 * <p>
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 * <p>
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.
 * <p>
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * Note:
 * You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class Implement_Magic_Dictionary_676 {

    LowercaseWordTrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Implement_Magic_Dictionary_676() {
        root = null;
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        root = LowercaseWordTrieNode.buildRoot(dict);
    }


    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return dfs(word.toCharArray(), root, 0, false);
    }

    private boolean dfs(char[] ws, LowercaseWordTrieNode c, int i, boolean replace) {
        if (i == ws.length) {
            if (replace && c.word != null)
                return true;
            else return false;
        }
        int index = ws[i] - 'a';
        LowercaseWordTrieNode next = c.next[index];
        if (!replace)
            for (int j = 0; j < 26; j++) {
                if (j == index) continue;
                if (c.next[j] != null)
                    if (dfs(ws, c.next[j], i + 1, !replace)) return true;
            }
        if (next != null && dfs(ws, next, i + 1, replace)) return true;
        return false;
    }

    public static void main(String[] args) {
        Implement_Magic_Dictionary_676 implement_magic_dictionary_676 = new Implement_Magic_Dictionary_676();
        implement_magic_dictionary_676.buildDict(new String[]{"hello", "leetcode", "ab", "d"});
        System.out.println(implement_magic_dictionary_676.search("hella"));
        System.out.println(implement_magic_dictionary_676.search("hhllo"));
        System.out.println(implement_magic_dictionary_676.search("aello"));
        System.out.println(implement_magic_dictionary_676.search("hell"));
        System.out.println(implement_magic_dictionary_676.search("b"));
        System.out.println(implement_magic_dictionary_676.search("ad"));
    }


}
