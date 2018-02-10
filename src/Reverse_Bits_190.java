import java.util.Stack;

/**
 * Created by zhongjianlv on 2018/2/10
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class Reverse_Bits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        Stack<Integer> stacks = new Stack<>();
        int r = 0;
        while(n !=0){
            stacks.add(n & 1);
            n >>>= 1;
        }
        int k = 1;
        for(int i = 0; i < 32 - stacks.size(); ++i){
            k <<= 1;
        }
        while (!stacks.isEmpty()){
            Integer pop = stacks.pop();
            if(pop == 1)
                r += k;
            k <<= 1;
        }
        return r;
    }

    public static void main(String[] args) {
        Reverse_Bits_190 reverse_bits_190 = new Reverse_Bits_190();
        System.out.println(reverse_bits_190.reverseBits(Integer.MIN_VALUE));
    }
}
