/**
 * Created by zhongjianlv on 18-3-2.
 * <p>
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering:
 * <p>
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class Compare_Version_Numbers_165 {

    public int compareVersion(String version1, String version2) {
        int i1 = 0, i2 = 0;
        int e1, e2;
        int k1, k2;
        while (i1 != version1.length() || i2 != version2.length()) {

            e1 = getNext(version1, i1);
            e2 = getNext(version2, i2);
            if (e1 == i1 && e2 == i2) return 0;
            else if (e1 == i1) {
                k1 = 0;
                k2 = Integer.valueOf(version2.substring(i2, e2));
            } else if (e2 == i2) {
                k1 = Integer.valueOf(version1.substring(i1, e1));
                k2 = 0;
            } else {
                k1 = Integer.valueOf(version1.substring(i1, e1));
                k2 = Integer.valueOf(version2.substring(i2, e2));
            }
            if (k1 > k2) return 1;
            if (k1 < k2) return -1;
            i1 = e1 + 1;
            i2 = e2 + 1;
            if (i1 > version1.length()) i1 = version1.length();
            if (i2 > version2.length()) i2 = version2.length();
        }
        return 0;
    }


    private int getNext(String s, int start) {
        while (start < s.length() && s.charAt(start) != '.') ++start;
        return start;
    }

    public static void main(String[] args) {
        Compare_Version_Numbers_165 compare_version_numbers_165 = new Compare_Version_Numbers_165();
        System.out.println(compare_version_numbers_165.compareVersion("1.3.11.2.0.1",
                "1.3.11.2"));
    }
}
