/**
 * Created by zhongjianlv on 2018/2/19
 * <p>
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * <p>
 * Update (2015-02-10):
 */
public class Valid_Number_65 {
    public boolean isNumber(String s) {
        s = s.trim();
        char[] c = s.toCharArray();
        if (c.length == 0) return false;
        boolean fuhao = false;
        boolean xiaoshu = false;
        boolean zhishu = false;
        boolean zhishushu = false;
        char temp = ' ';
        for (int i = 0; i < c.length; ++i) {
            if (i == 0 && (c[i] == '-' || c[i] == '+')) {
                if (i + 1 < c.length && c[i + 1] == 'e') return false;
                fuhao = true;
                continue;
            }
            temp = c[i];
            if (temp >= '0' && temp <= '9') {
                if (zhishu)
                    zhishushu = true;
                continue;
            } else if (temp == 'e') {
                if (i == 0) return false;
                if (zhishu == false) {
                    zhishu = true;
                    if (i + 1 < c.length && (c[i + 1] == '-' || c[i + 1] == '+')) ++i;
                } else return false;
            } else if (temp == '.') {
                if (zhishu) return false;
                if (i == 0 && i + 1 < c.length && c[i + 1] == 'e') return false;
                if (xiaoshu == false)
                    xiaoshu = true;
                else return false;
            } else {
                return false;
            }
        }
        if (fuhao) {
            if (xiaoshu) {
                if (c.length <= 2) return false;
            } else {
                if (c.length <= 1) return false;
            }
        }
        if (xiaoshu && c.length == 1) return false;
        if (zhishu && !zhishushu) return false;
        return true;
    }
}
