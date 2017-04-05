/**
 * Created by zhongjianlv on 17-4-5.
 *
 * leetcode algorithm 9
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber9 {


    /**
     * 计算整数的反向数字判断,只计算一半
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    /**
     * 计算整数的反向数字判断
     * @param x
     * @return
     */
    public boolean isPalindrome3(int x) {
        if(x<0)
            return false;
        else{
           int temp = x;
           int x2 = 0;
           while (temp!=0){
               x2 = x2*10 + temp%10;
               temp /= 10;
           }
           return x2 == x;
        }
    }


    /**
     * 转换成字符串反转处理
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if(x<0)
            return false;
        else{
            long x2 = Long.valueOf(new StringBuffer(String.valueOf(x)).reverse().toString());
            if(x2 == 2)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {

    }
}
