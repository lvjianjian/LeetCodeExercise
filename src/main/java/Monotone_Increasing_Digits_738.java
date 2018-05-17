import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zhongjianlv on 18-5-17.
 * <p>
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * <p>
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * <p>
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 * Note: N is an integer in the range [0, 10^9].
 */
public class Monotone_Increasing_Digits_738 {
    private int res = 0;
    public int monotoneIncreasingDigits(int N) {
        res = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        while (N != 0) {
            integers.add(0, N % 10);
            N /= 10;
        }
        helper(integers,0,0, 0);
        return res;
    }

    private int helper(ArrayList<Integer> list, int index, int pre, int max){
        if(index == list.size()) return 9;
        Integer integer = list.get(index);
        integer = Math.max(integer,max);
        while (integer >=0){
            if(integer >= pre) {
                res *= 10;
                res += integer;
                int after = helper(list,index+1,integer,max);
                if(after >= integer)
                    return integer;
                else{
                    integer--;
                    res /= 10;
                    max = 9;
                }
            }else{
                return integer;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Monotone_Increasing_Digits_738 monotone_increasing_digits_738 = new Monotone_Increasing_Digits_738();
        System.out.println(monotone_increasing_digits_738.monotoneIncreasingDigits(130));
    }
}
