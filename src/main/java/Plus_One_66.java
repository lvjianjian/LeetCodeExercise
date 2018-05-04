/**
 * Created by zhongjianlv on 17-12-29.
 * <p>
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Plus_One_66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            int after_plus = digits[i] + 1;
            if (after_plus == 10) {
                digits[i] = 0;
            } else {
                digits[i] = after_plus;
                break;
            }
        }
        int[] new_digits;
        if (digits[0] == 0) {
            new_digits = new int[digits.length + 1];
            new_digits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                new_digits[i + 1] = digits[i];
            }
        } else
            new_digits = digits;
        return new_digits;
    }
}
