import java.util.*;

/**
 * Created by zhongjianlv on 18-1-6.
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Longest_Valid_Parentheses_32 {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (chars[stack.peek()] == '(')
                        stack.pop();
                    else
                        stack.push(i);

                } else {
                    stack.push(i);
                }
            }
        }

        if (stack.isEmpty())
            max = s.length();
        else {
            int a = s.length();
            while (!stack.isEmpty()) {
                int b = stack.pop();
                max = Math.max(max, a - b - 1);
                a = b;
            }
            max = Math.max(max, a);
        }
        return max;
    }


    public int longestValidParentheses2(String s) {
        if (s.length() <= 1) return 0;
        int max = 0;
        int[] ints = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                stack.push(i);
            } else {// ')'
                if (stack.size() > 0) {
                    int position = stack.pop();
                    ints[i] = 1;
                    ints[position] = 1;
                }
            }
        }

        int c = 0;
        for (int i = 0; i <= ints.length; i++) {
            if (i != ints.length && ints[i] != 0)
                ++c;
            else {
                if (c > max) {
                    max = c;
                }
                c = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Longest_Valid_Parentheses_32 longest_valid_parentheses_32 = new Longest_Valid_Parentheses_32();
        String s = "()()()())()(())";


        System.out.println(longest_valid_parentheses_32.longestValidParentheses(s));
        System.out.println(longest_valid_parentheses_32.longestValidParentheses2(s));
    }
}
