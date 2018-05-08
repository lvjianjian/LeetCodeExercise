/**
 * Created by zhongjianlv on 18-5-8.
 * <p>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Ransom_Note_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int length = magazine.length();
        for (int i = 0; i < length; i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        length = ransomNote.length();
        int index;
        for (int i = 0; i < length; i++) {
            index = ransomNote.charAt(i) - 'a';
            count[index]--;
            if (count[index] < 0) return false;
        }
        return true;
    }
}
