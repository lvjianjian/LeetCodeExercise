/**
 * Created by zhongjian on 2017/4/5.
 * <p>
 * leetcode algorithm 8
 * <p>
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 */
public class StringtoInteger8 {

    public int myAtoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        int sum = 0;
        boolean findSign = false;
        int sign = 1;//符号位
        boolean findInteger = false;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a >= '0' && a <= '9') {
                int digit = sign * (a - '0');
                //判断是否会超出int最大值范围
                if (sum > Integer.MAX_VALUE / 10
                        || (sum == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)){
                    return Integer.MAX_VALUE;
                }else if(sum < Integer.MIN_VALUE / 10
                        || (sum == Integer.MIN_VALUE/10 && digit < Integer.MIN_VALUE % 10) ){
                    return Integer.MIN_VALUE;
                }
                sum = sum * 10 + digit;
                findInteger = true;
            }else if(a == '-' && !findSign && !findInteger){
                findSign = true;
                sign = -1;
            }else if(a == '+' && !findSign && !findInteger){
                findSign = true;
            } else {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        StringtoInteger8 stringtoInteger8 = new StringtoInteger8();
        System.out.println(stringtoInteger8.myAtoi("b-2147483649"));
    }
}
