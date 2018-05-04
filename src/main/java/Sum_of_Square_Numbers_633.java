/**
 * Created by zhongjianlv on 18-4-3.
 * <p>
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: 3
 * Output: False
 */
public class Sum_of_Square_Numbers_633 {
    public boolean judgeSquareSum(int c) {
        int a = -1;
        int b;
        do{
            ++a;
            b = (int)(Math.sqrt(c - a * a));
            if(a * a + b * b == c) return true;
        }while (a < b);
        return false;
    }

    public static void main(String[] args) {
        Sum_of_Square_Numbers_633 sum_of_square_numbers_633 = new Sum_of_Square_Numbers_633();
        System.out.println(sum_of_square_numbers_633.judgeSquareSum(5));
        System.out.println(sum_of_square_numbers_633.judgeSquareSum(4));
        System.out.println(sum_of_square_numbers_633.judgeSquareSum(3));
    }
}
