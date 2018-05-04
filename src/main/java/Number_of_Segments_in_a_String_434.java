/**
 * Created by zhongjianlv on 18-3-29.
 * <p>
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的非空字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class Number_of_Segments_in_a_String_434 {
    public int countSegments(String s) {
        if(s == null || s.equals("")) return 0;
        int count = 0;
        String[] ss = s.split(" ");
        for(String part:ss){
            if(!part.trim().equals("")) ++count;
        }
        return count;
    }
}
