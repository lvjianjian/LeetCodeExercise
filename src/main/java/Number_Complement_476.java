/**
 * Created by zhongjianlv on 18-1-1.
 * <p>
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 */
public class Number_Complement_476 {
    public int findComplement(int num) {
        int result = 0;
        int s = 1;
        while (num != 0){
            int yu = num % 2;
            if(yu == 0)
                result += s;
            s *= 2;
            num /= 2;
        }
        return result;
    }

    public int findComplement2(int num) {
        return (Integer.highestOneBit(num) * 2 - 1) ^ num;
    }



    public static void main(String[] args) {
        Number_Complement_476 number_complement_476 = new Number_Complement_476();
        int n = 111;
        System.out.println(number_complement_476.findComplement2(n));
        System.out.println(number_complement_476.findComplement(n));

    }

}
