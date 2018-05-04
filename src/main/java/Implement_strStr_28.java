/**
 * Created by zhongjianlv on 18-1-5.
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class Implement_strStr_28 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        else if (needle.length() == haystack.length()) // 不加这个很坑
            return needle.equals(haystack) ? 0 : -1;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        char first = chars2[0];
        int length1 = chars1.length;
        int length2 = chars2.length;
        int i1 = 0;
        int i2 = 0;
        int index;
        int next = length2;
        while (i1 < length1 - length2 + 1) {

            while (i1 < length1 && i2 < length2 && chars1[i1] != chars2[i2]) {
                ++i1;
            }
            index = i1;
            while (i1 < length1 && i2 < length2 && chars1[i1] == chars2[i2]) {
                if (next == length2 && i2 != 0 && chars2[i2] == first)
                    next = i2;
                ++i1;
                ++i2;
            }
            if (i2 == length2)
                return index;
            if ((i1 - index) >= next)
                i1 = index + next;
            i2 = 0;
        }
        if (i2 == length2)
            return i2;
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int i1 = 0;
        int i2 = 0;
        int index;
        while (i1 < length1) {
            index = i1;
            while (i1 < length1 && i2 < length2 && chars1[i1] == chars2[i2]) {
                ++i1;
                ++i2;
            }
            if (i2 == length2)
                return index;
            i1 = index + 1;
            i2 = 0;
        }
        if (i2 == length2)
            return i2;
        return -1;
    }

    public static void main(String[] args) {
        Implement_strStr_28 implement_strStr_28 = new Implement_strStr_28();
        System.out.println(implement_strStr_28.strStr("mississippi", "issis"));
    }
}
