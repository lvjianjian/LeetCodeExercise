/**
 * Created by zhongjianlv on 2018/4/18
 * <p>
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
 * <p>
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 * <p>
 * L, R  and A[i] will be an integer in the range [0, 10^9].
 * The length of A will be in the range of [1, 50000].
 */
public class Number_of_Subarrays_with_Bounded_Maximum_795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int size = 0;
        int pre = 0;
        int conti = 0;
        for(int i = 0; i < A.length; ++i){
            ++conti;
            if(A[i] > R){
                pre = 0;
                conti = 0;
            }else if(A[i] < L){
                size += pre;
            }else{
                pre = conti;
                size += pre;
            }
        }
        return size;
    }
}
