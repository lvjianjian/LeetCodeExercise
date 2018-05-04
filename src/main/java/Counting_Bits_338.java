import java.util.Arrays;

/**
 * Created by zhongjianlv on 17-12-27.
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * O(n)
 */
public class Counting_Bits_338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int stop = 0;
        for (int i = 1; i <= num; ) {
            for (int j = 0; j <= stop && i <= num; j++, ++i) {
                res[i] = res[j] + 1;
            }
            stop = i - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Counting_Bits_338 counting_bits_338 = new Counting_Bits_338();
        System.out.println(Arrays.toString(counting_bits_338.countBits(5)));
    }
}
