
/**
 * Created by zhongjianlv on 18-5-6.
 */
public class Detect_Capital_520 {
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        if (length <= 1) return true;
        char c = word.charAt(0);
        if (c >= 'a' && c <= 'z') {//第一个字母是小写字母，则后面都要是小写
            for (int i = 1; i < length; i++) {
                c = word.charAt(i);
                if (c < 'a' || c > 'z') return false;
            }
        } else if (c >= 'A' && c <= 'Z') {//第一个字母是大写字母
            c = word.charAt(1);
            if (c >= 'A' && c <= 'Z') {//第二个字母也是大写字母，则后面都要是大写
                for (int i = 2; i < length; i++) {
                    c = word.charAt(i);
                    if (c < 'A' || c > 'Z') return false;
                }
            } else {
                for (int i = 2; i < length; i++) {//第二个字母是非大写字母，则后面不能有大写字母
                    c = word.charAt(i);
                    if (c >= 'A' && c <= 'Z') return false;
                }
            }
        } else return false;//第一个字母既不小写也不大写
        return true;
    }
}
