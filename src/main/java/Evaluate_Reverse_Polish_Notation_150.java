import java.util.Stack;

/**
 * Created by zhongjianlv on 18-3-1.
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Evaluate_Reverse_Polish_Notation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            int i1, i2;
            switch (s) {
                case "+":
                    i1 = stack.pop();
                    i2 = stack.pop();
                    stack.push(i2 + i1);
                    break;
                case "-":
                    i1 = stack.pop();
                    i2 = stack.pop();
                    stack.push(i2 - i1);
                    break;
                case "*":
                    i1 = stack.pop();
                    i2 = stack.pop();
                    stack.push(i2 * i1);
                    break;
                case "/":
                    i1 = stack.pop();
                    i2 = stack.pop();
                    stack.push(i2 / i1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        if (stack.isEmpty()) return 0;
        return stack.pop();
    }
}
