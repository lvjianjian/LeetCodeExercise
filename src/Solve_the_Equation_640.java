/**
 * Created by zhongjianlv on 18-4-24.
 * <p>
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class Solve_the_Equation_640 {
    public String solveEquation(String equation) {
        int a = 0;
        int b = 0;
        int zheng = 1;
        int dengyu = 1;
        int shuzi = 0;
        char pre = 0;
        for (char c : equation.toCharArray()) {
            switch (c) {
                case '+':
                    b -= shuzi * dengyu * zheng;
                    zheng = 1;
                    shuzi = 0;
                    break;
                case '-':
                    b -= shuzi * dengyu * zheng;
                    zheng = -1;
                    shuzi = 0;
                    break;
                case '=':
                    b -= shuzi * dengyu * zheng;
                    zheng = 1;
                    dengyu = -1;
                    shuzi = 0;
                    break;
                case 'x':
                    if (shuzi == 0 && pre != '0')
                        shuzi = 1;
                    a += shuzi * dengyu * zheng;
                    shuzi = 0;
                    break;
                case ' ':
                    break;
                default:
                    shuzi *= 10;
                    shuzi += (c - '0');
            }
            pre = c;
        }
        b -= shuzi * dengyu * zheng;
        if (a != 0) {
            return "x=" + b / a;
        } else {
            if (a == b)
                return "Infinite solutions";
            else return "No solution";
        }
    }
}
