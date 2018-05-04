/**
 * Created by zhongjianlv on 2018/2/18
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class Ugly_Number_II_264 {

    public int nthUglyNumber(int n) {
        int[] r = new int[n];
        r[0] = 1;
        int index1 = 0,index2 = 0,index3 = 0;
        int v1,v2,v3,v;
        for(int i = 1; i < n;++i){
            v1 = r[index1] * 2;
            v2 = r[index2] * 3;
            v3 = r[index3] * 5;
            v = Math.min(Math.min(v1,v2),v3);
            r[i] = v;
            if(v1 == v) ++index1;
            if(v2 == v) ++index2;
            if(v3 == v) ++index3;
        }

        return r[n-1];
    }

}
