/**
 * Created by zhongjianlv on 2018/2/23
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Valid_Palindrome_125 {

    public boolean isPalindrome(String s) {
        char[] ss = s.toCharArray();
        int i = 0;
        int j = ss.length - 1;
        int temp = Math.abs('A'-'a');
        while(i < j){
            while(i < ss.length && !(ss[i]>='0' && ss[i] <='9') && !(ss[i]>='a' && ss[i] <='z') && !(ss[i]>='A' && ss[i] <='Z')) ++i;
            while(j >= 0  && !(ss[j]>='0' && ss[j] <='9') && !(ss[j]>='a' && ss[j] <='z') && !(ss[j]>='A' && ss[j] <='Z')) --j;
            if(i < j){
                if(ss[i] >= '0' && ss[i] <='9'){
                    if(ss[i] != ss[j]) return false;
                }else{
                    int cha = Math.abs(ss[i] - ss[j]);
                    if(cha != 0 && cha != temp) return false;
                }
            }
            ++i;
            --j;
        }
        return true;
    }
}
