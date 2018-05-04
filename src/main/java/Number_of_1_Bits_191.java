/**
 * Created by zhongjianlv on 2018/2/10
 */
public class Number_of_1_Bits_191 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1)
                ++count;
            n>>>=1; //无符号右移 ！！
        }
        return count;
    }

    public static void main(String[] args) {
        Number_of_1_Bits_191 number_of_1_bits_191 = new Number_of_1_Bits_191();
        System.out.println(number_of_1_bits_191.hammingWeight(-1111));
    }
}
