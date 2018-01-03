/**
 * Created by zhongjian on 2017/4/4.
 *
 * leetcode algorithm 6
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: \
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * the odd column has numRows
 * and the even column has numRows - 2 (numRows >= 3) or numRows (numRows < 3)
 *
 * "PAYPALISHIRING" (numRows = 1)
 * And then read line by line: "PAHNAPLSIIGYIR" (numRows = 3)
 * "PHASIYIRPLIGAN" (numRows = 5)
 *
 */
public class ZigZag_Conversion_6 {

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows == 1){//为1输出原值
            return s;
        }else if(numRows == 2){//2的时候先是第1，3，5...个字符再是2，4，6...个字符
            for (int i = 0; i < s.length(); i=i+2) {
                sb.append(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i=i+2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }else {
            /**
             * 其他情况奇数列为numRows个字符，偶数列为numRows-2个字符，
             * 其实是个数学游戏,n为numRows
             * 第一行为第 1，(1 + (2n - 2)), (1 + 2 * (2n - 2))...个字符
             * 第二行为第 2，(2 + (2n - 4)), (2 + (2n - 4) + 2), (2 + 2 * (2n-4) + 2), (2 + 2 * (2n-4) + 2 * 2)...个字符
             * 第三行为第 3，(3 + (2n - 6)), (3 + (2n - 6) + 4), (3 + 2 * (2n-6) + 4), (3 + 2 * (2n-6) + 2 * 4)...个字符
             * ...
             * 第k行为第 k， (k + (2n - 2 * k)), (k + (2n - 2 * k) + 2 * (k - 1)), (k + 2 * (2n - 2 * k) + 2 * (k - 1)) ,(k + 2 * (2n - 2 * k) + 2 * 2 * (k - 1))...个字符
             * ...
             *
             * 第n行字符为第 n, (n + (2n - 2)), (n + 2 * (2n - 2))...个字符
             */

            for (int i = 0; i < numRows && i < s.length(); i++) {
                int k1 = 2 * (numRows - 1 - i), k2 = 2 * i;
                sb.append(s.charAt(i));
                for (int j = i; j < s.length();) {
                    if (k1 != 0) {
                        j += k1;
                        if (j < s.length()) {
                            sb.append(s.charAt(j));
                        }
                    }
                    if(k2 != 0) {
                        j += k2;
                        if (j < s.length()) {
                            sb.append(s.charAt(j));
                        }
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ZigZag_Conversion_6 zigZagConversion6 = new ZigZag_Conversion_6();
        System.out.println(zigZagConversion6.convert("PAYPALISHIRING",3));
    }

}
