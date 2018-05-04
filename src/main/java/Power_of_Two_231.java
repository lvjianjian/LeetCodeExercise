/**
 * Created by zhongjianlv on 2018/2/11
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Power_of_Two_231 {

    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int count = 0;
        while(n!=0){
            if((n & 1) == 1)
                ++count;
            n >>=1;
        }
        return count==1;
    }
}
