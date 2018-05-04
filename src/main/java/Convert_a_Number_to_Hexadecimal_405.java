import java.util.Arrays;

/**
 * Created by zhongjianlv on 2018/2/8
 * <p>
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 */
public class Convert_a_Number_to_Hexadecimal_405 {

    public String toHex(int num) {
        int[] v = new int[8];
        boolean negetive = false;
        if(num < 0){
            negetive = true;
        }
        int j = 7;
        while(num !=0){
            v[7 - j] = num / (int)Math.pow(16,j);
            num -= (int)Math.pow(16,j) * v[7-j];
            --j;
        }

        if(negetive) {
            for (int i = 0; i < v.length; i++) {
                v[i] += 15;
            }

            for (int i = v.length - 1; i >=0; --i){
                v[i] += 1;
                if(v[i] == 16)
                    v[i] = 0;
                else
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();
        boolean houzhi_zero = false;
        for (int i = 0; i < v.length; i++) {
            if(houzhi_zero || v[i] !=0){
                houzhi_zero = true;
                if(v[i]<10)
                    sb.append(v[i]);
                else
                    sb.append((char)('a' + (v[i] - 10)));
            }

        }
        if(sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        Convert_a_Number_to_Hexadecimal_405 convert_a_number_to_hexadecimal_405 = new Convert_a_Number_to_Hexadecimal_405();
        System.out.println(convert_a_number_to_hexadecimal_405.toHex(16));
    }

}
