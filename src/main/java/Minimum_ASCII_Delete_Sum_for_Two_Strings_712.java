/**
 * Created by zhongjianlv on 17-12-27.
 *
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 */
public class Minimum_ASCII_Delete_Sum_for_Two_Strings_712 {

    public int minimumDeleteSum(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int r = cs1.length;
        int c = cs2.length;
        int all = 0;
        int[][] result = new int[r+1][c+1];
        int max = 0;
        for(int i = 0; i <= r; ++i) {
            result[i][0] = 0;
            if(i!=r) all += cs1[i];
        }

        for(int i = 0; i <= c; ++i) {
            result[0][i] = 0;
            if(i!=c) all += cs2[i];
        }

        for(int i = 1; i <= r; ++i)
            for(int j = 1; j <= c; ++j){
                int temp = 0;
                if(cs1[i-1] != cs2[j-1]){
                    temp = Math.max(result[i-1][j],result[i][j-1]);
                }else{
                    temp = Math.max(temp,result[i-1][j-1] + (int)cs1[i-1]);
                }
                result[i][j] = temp;
            }

        return all - 2 * result[r][c];
    }

    public int minimumDeleteSum2(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int r = cs1.length;
        int c = cs2.length;
        int all = 0;
        int[][] result = new int[r+1][c+1];

        for(int i = 0; i <= r; ++i) {
            result[i][0] = 0;
            if(i!=r) all += cs1[i];
        }

        for(int i = 0; i <= c; ++i) {
            result[0][i] = 0;
            if(i!=c) all += cs2[i];
        }

        for(int i = 1; i <= r; ++i)
            for(int j = 1; j <= c; ++j){
                int temp = Math.max(result[i-1][j],result[i][j-1]);
                if(cs1[i-1] == cs2[j-1]){
                    temp = Math.max(temp,result[i-1][j-1] + (int)cs1[i-1]);
                }
                result[i][j] = temp;
            }

        return all - 2 * result[r][c];
    }


    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
    }
}
