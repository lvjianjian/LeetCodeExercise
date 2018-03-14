import java.util.TreeSet;

/**
 * Created by zhongjianlv on 18-3-14.
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 * <p>
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 * <p>
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 * <p>
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,0,2]
 * Output: true
 * Explanation: There is 1 global inversion, and 1 local inversion.
 * Example 2:
 * <p>
 * Input: A = [1,2,0]
 * Output: false
 * Explanation: There are 2 global inversions, and 1 local inversion.
 * Note:
 * <p>
 * A will be a permutation of [0, 1, ..., A.length - 1].
 * A will have length in range [1, 5000].
 * The time limit for this problem has been reduced.
 */
public class Global_and_Local_Inversions_775 {

    public boolean isIdealPermutation(int[] A) {
        if (A.length <= 2) return true;
        int max = A[0];
        for (int i = 2; i < A.length; i++) {
            max = Math.max(A[i - 2], max);
            if (max > A[i]) return false;
        }
        return true;
    }

    //time limited
    public boolean isIdealPermutation2(int[] A) {
        if (A.length <= 2) return true;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i < A.length; i++) {
            set.add(A[i - 2]);
            if (set.tailSet(A[i], true).size() > 0) return false;
        }
        return true;
    }
}
