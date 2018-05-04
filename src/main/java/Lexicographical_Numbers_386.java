import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhongjianlv on 18-4-12.
 * <p>
 * Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class Lexicographical_Numbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        helper(1, res, n, true);
        return res;
    }

    private void helper(int c, List<Integer> res, int n, boolean flag) {
        if (c <= n) res.add(c);
        else return;
        int newc = c * 10;
        if (newc <= n)
            helper(newc, res, n, true);
        if (flag)
            for (int i = 1; i <= 9; i++) {
                if (c == 1 && i == 9) break;
                newc = c + i;
                if (newc > n) break;
                helper(newc, res, n, false);
            }
    }


    public static void main(String[] args) {
        Lexicographical_Numbers_386 lexicographical_numbers_386 = new Lexicographical_Numbers_386();
        System.out.println(lexicographical_numbers_386.lexicalOrder(13).toString());
    }

}
