import java.util.LinkedList;

/**
 * Created by zhongjianlv on 18-1-4.
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            switch (aChar){
                case '(':
                case '[':
                case '{':
                    linkedList.add(aChar);
                    break;
                case ')':
                    if(linkedList.size() ==0 || !linkedList.pollLast().equals('('))
                        return false;
                    break;
                case ']':
                    if(linkedList.size() ==0 || !linkedList.pollLast().equals('['))
                        return false;
                    break;
                case '}':
                    if(linkedList.size() ==0 || !linkedList.pollLast().equals('{'))
                        return false;
                    break;
            }
        }
        if(linkedList.size() == 0)
            return true;
        return false;
    }
}
