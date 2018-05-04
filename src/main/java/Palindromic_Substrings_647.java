/**
 * Created by zhongjianlv on 17-12-27.
 */
public class Palindromic_Substrings_647 {

    public int countSubstrings(String s) {
        int length = s.length();
        int[][] ints = new int[length][length];
        int num = 0;
        num += length;
        for (int i = 0; i < length; i++) {
            ints[i][i] = 1;
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                ints[i][i + 1] = 2;
                ++num;
            }
        }

        for (int i = 2; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (ints[j + 1][i + j - 1] == i - 1){
                    if(s.charAt(j) == s.charAt(i + j)){
                        ints[j][i+j] = i + 1;
                        ++num;
                    }
                }
            }
        }

        return num;
    }
}
