/**
 * Created by zhongjianlv on 2018/2/17
 * <p>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class Add_Digits_258 {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
