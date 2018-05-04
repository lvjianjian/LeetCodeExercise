/**
 * Created by zhongjianlv on 2018/2/8
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Add_Strings_415 {

    public String addStrings(String num11, String num22) {
        char[] n1 = num11.toCharArray();
        char[] n2 = num22.toCharArray();
        int num1 = n1.length - 1;
        int num2 = n2.length - 1;
        if(num1 < num2){
            char[] temp = n1;
            n1 = n2;
            n2 = temp;
            num1 ^= num2;
            num2 ^= num1;
            num1 ^= num2;
        }
        int jinwei = 0;
        while(num1 >=0 && num2 >=0){
            int k = (n1[num1] - '0') + (n2[num2] - '0') + jinwei;
            n1[num1] = (char)((k % 10) + '0');
            jinwei = k / 10;
            --num1;
            --num2;
        }

        while(num1 >= 0){
            int k = (n1[num1] - '0') + jinwei;
            n1[num1] = (char)((k % 10) + '0');
            jinwei = k / 10;
            --num1;
            --num2;
        }

        StringBuilder sb = new StringBuilder();
        if(jinwei == 1)
            sb.append(1);
        sb.append(new String(n1));

        int k =0;
        while(k < sb.length() && sb.charAt(k) == '0') ++k;
        String substring = sb.substring(k);
        if(substring.length() == 0) return "0";
        else return substring;
    }

    public static void main(String[] args) {
        Add_Strings_415 add_strings_415 = new Add_Strings_415();
        System.out.println(add_strings_415.addStrings("9999","1111"));
    }
}
