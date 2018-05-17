import java.util.Random;

/**
 * Created by zhongjianlv on 2018/5/14
 * <p>
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class Shuffle_an_Array_384 {

    int[] origin;
    int[] newArray;
    int n;
    Random random;

    public Shuffle_an_Array_384(int[] nums) {
        random = new Random();
        n = nums.length;
        origin = nums;
        newArray = new int[n];
        System.arraycopy(nums, 0, newArray, 0, n);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int j;
        for (int i = 0; i < n; i++) {
            j = random.nextInt(n - i) + i;
            if (j == i) continue;
            exchange(newArray, i, j);
        }
        return newArray;
    }

    private void exchange(int[] newArray, int i, int j) {
        newArray[i] ^= newArray[j];
        newArray[j] ^= newArray[i];
        newArray[i] ^= newArray[j];
    }
}
