/**
 * Created by zhongjianlv on 2018/2/25
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class Reverse_Words_in_a_String_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        int j = ss.length;
        int i = ss.length - 1;
        boolean find = false;
        for(; i >=0 ;--i){
            if(ss[i] == ' '){
                if(find){
                    sb.append(s.substring(i+1,j));
                    sb.append(' ');
                    find = false;
                }
                j = i;
            }else{
                find = true;
            }
        }
        if(find){
            sb.append(s.substring(i+1,j));
            return sb.toString();
        }else{
            if(sb.length() == 0) return "";
            return sb.substring(0,sb.length()-1).toString();
        }
    }

    public static void main(String[] args) {
        Reverse_Words_in_a_String_151 reverse_words_in_a_string_151 = new Reverse_Words_in_a_String_151();
        System.out.println(reverse_words_in_a_string_151.reverseWords("blue is sky the"));
    }
}
