/**
 * Created by zhongjianlv on 17-4-6.
 *
 * leetcode algorithm 14
 *
 *
 */
public class Longest_Common_Prefix_14 {
    /**
     * 两两取最大公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        out:
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < prefix.length() && j < strs[i].length(); j++) {
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    prefix = prefix.substring(0,j);
                    continue out;
                }
            }
            prefix = prefix.length()<strs[i].length()?prefix:strs[i];
        }
        return prefix;
    }

    /**
     * 竖向比较
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        int index = 0;
        out:
        while (true){
            char temp;
            if(index < strs[0].length())
                temp = strs[0].charAt(index);
            else
                break;
            for (int i = 1; i < strs.length; i++) {
                if(index >= strs[i].length() || temp != strs[i].charAt(index))
                    break out;
            }
            ++index;
        }
        return strs[0].substring(0,index);
    }

    public static void main(String[] args) {
        Longest_Common_Prefix_14 longestCommonPrefix14 = new Longest_Common_Prefix_14();
        System.out.println(longestCommonPrefix14.longestCommonPrefix2(new String[]{"aa","a"}));
    }
}
