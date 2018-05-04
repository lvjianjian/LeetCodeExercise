import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-2.
 * <p>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class Fraction_to_Recurring_Decimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        long n = numerator;
        long d = denominator;
        if((n >0 && d <0) || (n < 0 && d>0)){
            sb.append("-");
            n = Math.abs(n);
            d = Math.abs(d);
        }
        sb.append(n/d);
        n = n%d;
        if(n!=0){
            sb.append(".");
            int insertSite = sb.length();
            Map<Long,Integer> map = new HashMap<>();
            while(n!=0 && !map.containsKey(n)){
                map.put(n,insertSite);
                n*=10;
                sb.append(n/d);
                n%=d;
                insertSite+=1;
            }
            if(n!=0){
                sb.insert((int)map.get(n),'(');
                sb.append(")");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123");
        stringBuilder.insert(3,'(');
        System.out.println(stringBuilder.toString());

        System.out.println(-1000000000 % Integer.MIN_VALUE);
    }
}
