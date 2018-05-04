import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongjianlv on 2018/2/9
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Happy_Number_202 {

    //fast floyd circle detection
    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = helper(slow);
            fast = helper(fast);
            fast = helper(fast);
        } while(slow != fast);
        if (slow == 1) return true;
        else return false;
    }

    //slow
    public boolean isHappy2(int n) {
        if(n<=0) return false;
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            set.add(n);
            System.out.println(n);
            n = helper(n);
            if(set.contains(n))
                return false;
        }
        return true;
    }

    private int helper(int n){
        int sum = 0;
        while(n != 0){
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Happy_Number_202 happy_number_202 = new Happy_Number_202();
        System.out.println(happy_number_202.isHappy(28));
    }
}
