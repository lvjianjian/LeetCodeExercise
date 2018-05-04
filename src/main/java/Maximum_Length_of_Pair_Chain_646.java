import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhongjianlv on 2018/4/18
 * <p>
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class Maximum_Length_of_Pair_Chain_646 {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return (o1[0] < o2[0])?-1:(o1[0] > o1[0])?1:0;
                }else{
                    return (o1[1] < o2[1])?-1:1;
                }
            }
        });
        int max = 1;
        int minTime = pairs[0][1];
        for(int i = 1; i < pairs.length; ++i){
            if(pairs[i][0]>minTime){
                ++max;
                minTime = pairs[i][1];
            }
        }
        return max;
    }
}
