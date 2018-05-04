import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhongjianlv on 18-3-11.
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 */
public class Basic_Calculator_II_227 {
    private int start = 0;

    public int calculate(String s) {
        List<String> list = new ArrayList<>();
        String temp = null;
        while ((temp = getNext(s)) != null) {
            if (temp.equals("*")) {
                temp = list.remove(list.size()-1);
                list.add(Integer.valueOf(temp) * Integer.valueOf(getNext(s)) + "");
            } else if (temp.equals("/")) {
                temp = list.remove(list.size()-1);
                list.add(Integer.valueOf(temp) / Integer.valueOf(getNext(s)) + "");
            } else {
                list.add(temp);
            }
        }

        int r = Integer.valueOf(list.get(0));

        for (int i = 1; i < list.size(); i+=2) {
            String s1 = list.get(i);
            if(s1.equals("+")){
                r += Integer.valueOf(list.get(i+1));
            }else{
                r -= Integer.valueOf(list.get(i+1));
            }
        }

        return r;
    }

    private String getNext(String s) {
        while (start < s.length() && s.charAt(start) == ' ')
            ++start;
        if (start == s.length()) return null;
        int end = start;
        while (end < s.length()) {
            char temp = s.charAt(end);
            if (temp >= '0' && temp <= '9') ++end;
            else break;
        }
        if (start == end)
            ++end;
        int old_start = start;
        start = end;
        return s.substring(old_start, end);
    }

    public static void main(String[] args) {
        Basic_Calculator_II_227 basic_calculator_ii_227 = new Basic_Calculator_II_227();
        System.out.println(basic_calculator_ii_227.calculate("1+1-1"));
    }
}
