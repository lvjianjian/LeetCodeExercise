/**
 * Created by zhongjianlv on 18-4-3.
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Credits:
 * Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 */
public class Sum_of_Two_Integers_371 {

    public int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a;
            a ^= b;
            b = temp & b;
            b <<= 1;
        }
        return a;
    }


    public static void main(String[] args) {
        Sum_of_Two_Integers_371 sum_of_two_integers_371 = new Sum_of_Two_Integers_371();
        System.out.println(sum_of_two_integers_371.getSum(1, 2));
        System.out.println(sum_of_two_integers_371.getSum(3, 9));
        System.out.println(sum_of_two_integers_371.getSum(-1, 2));
        System.out.println(sum_of_two_integers_371.getSum(213, 221));
    }
}
