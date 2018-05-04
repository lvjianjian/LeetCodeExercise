import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-2-4.
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class Gray_Code_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0) return result;
        result.add(1);
        int prebase = 3;
        int afterbase = 1;
        for(int i = 0; i < n - 1; ++i){
            int temp = result.size();
            for(int j = 0; j < temp / 2; ++j){
                result.add(result.get(j) + prebase);
            }

            for(int j = temp/2; j < temp; ++j){
                result.add(result.get(j) + afterbase);
            }

            prebase *= 2;
            afterbase *= 2;
        }
        return result;
    }
}
