import java.util.Stack;

/**
 * Created by zhongjianlv on 2018/2/11
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
public class Basic_Calculator_224 {


    public int calculate(String s) {
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> fuhaos = new Stack<>();
        char fuhao = ' ';
        for(int i = 0; i < ss.length;++i){
            char c = ss[i];
            if(c == '('){
                if(fuhao != ' '){
                    fuhaos.push(fuhao);
                    fuhao = ' ';
                }
                fuhaos.push(c);
            }else if(c == '+' || c == '-'){
                fuhao = c;
            }else if(c == ' ')
                continue;
            else if(c == ')'){
                int v = stack.pop();
                fuhaos.pop();
                if(!fuhaos.isEmpty() && fuhaos.peek() != '('){
                    fuhao = fuhaos.pop();
                    int v2 = stack.pop();
                    if(fuhao == '-'){
                        v = v2 - v;
                    }else{
                        v += v2;
                    }
                }
                stack.push(v);
            }else{
                int j = i;
                while(j < ss.length && ss[j] >= '0' && ss[j] <='9') ++j;
                int v = Integer.valueOf(s.substring(i,j));
                if(fuhao != ' '){
                    int v2 = stack.pop();
                    if(fuhao == '-'){
                        v = v2 - v;
                    }else{
                        v = v2 + v;
                    }
                }
                stack.push(v);
                i = j - 1;
            }
        }
        return stack.pop();
    }
}
