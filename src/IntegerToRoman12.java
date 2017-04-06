import java.util.*;

/**
 * Created by zhongjianlv on 17-4-5.
 *
 * leetcode algorithm 12
 */
public class IntegerToRoman12 {

    public static HashMap<Integer,Character> map = new HashMap<>();

    static {
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');
    }

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int multiplier = 1;
        while (num != 0){
            int digit = num % 10;
            if(digit == 9){
                sb.append(map.get(10 * multiplier));
                sb.append(map.get(1 * multiplier));
            }else if(digit >=5){
                while (digit != 5){
                    sb.append(map.get(1 * multiplier));
                    digit -= 1;
                }
                sb.append(map.get(5 * multiplier));
            }else if(digit == 4){
                sb.append(map.get(5 * multiplier));
                sb.append(map.get(1 * multiplier));
            }else {
                while (digit != 0){
                    sb.append(map.get(1 * multiplier));
                    digit -= 1;
                }
            }
            num /= 10;
            multiplier *= 10;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        IntegerToRoman12 integerToRoman12 = new IntegerToRoman12();
        System.out.println(integerToRoman12.intToRoman(6));
    }
}
