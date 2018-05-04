import javax.print.DocFlavor;

/**
 * Created by zhongjianlv on 18-4-1.
 * <p>
 * A password is considered strong if below conditions are all met:
 * <p>
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
 * <p>
 * Insertion, deletion or replace of any one character are all considered as one change.
 */
public class Strong_Password_Checker_420 {
    public int strongPasswordChecker(String s) {
        if (s == null) return 6;
        if (s.length() <= 4) return 6 - s.length();
        int min = 0;
        int preChar = ' ';
        int continusNum = 0;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean digit = false;
        int replace = 0;
        if (s.length() <= 20) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    digit = true;
                } else if (Character.isLowerCase(c)) {
                    lowerCase = true;
                } else upperCase = true;
                if (preChar == c) {
                    ++continusNum;
                    preChar = c;
                    if (continusNum == 3) {
                        ++replace;
                        preChar = ' ';
                    }
                } else {
                    continusNum = 1;
                    preChar = c;
                }
            }

            int different = 0;
            if (!digit) ++different;
            if (!upperCase) ++different;
            if (!lowerCase) ++different;
            if (different == 0) {
                if (s.length() == 5) return 1;
                else return replace;
            } else if (different == 1) {
                if (replace == 0) return 1;
                else return replace;
            } else {// different 2
                if (replace <= 1) return 2;
                else return replace;
            }
        } else { //需要删除
            int delete = s.length() - 20;
            int needDelete = delete;
            char[] ss = s.toCharArray();
            for (int i = 0; i < ss.length; i++) {
                if (Character.isDigit(ss[i])) {
                    digit = true;
                } else if (Character.isLowerCase(ss[i])) {
                    lowerCase = true;
                } else upperCase = true;

                if (preChar == ss[i]) {
                    ++continusNum;
                    preChar = ss[i];
                    if (continusNum == 3) {
                        if (i + 1 < s.length()) {
                            if (ss[i + 1] == ss[i] || delete == 0) {
                                ++replace;
                            } else {
                                --delete;
                            }
                            preChar = ' ';
                        } else {
                            if (delete == 0) {
                                ++replace;
                            } else {
                                --delete;
                            }
                        }

                    }
                } else {
                    continusNum = 1;
                    preChar = ss[i];
                }

            }
            int different = 0;
            if (!digit) ++different;
            if (!upperCase) ++different;
            if (!lowerCase) ++different;
            if (different == 0) return replace + needDelete;
            else if (different == 1) {
                if (replace == 0) return 1 + needDelete;
                else return replace + needDelete;
            } else {
                if (replace <= 1) return 2 + needDelete;
                else return replace + needDelete;
            }
        }
    }


    public static void main(String[] args) {
        Strong_Password_Checker_420 strong_password_checker_420 = new Strong_Password_Checker_420();
        System.out.println(strong_password_checker_420.strongPasswordChecker("1Abababcaaaabababababa"));
        System.out.println("1Abababcaaaabababababaaaaaaaaaaaaaaaaaaaaaa".length());
    }
}
