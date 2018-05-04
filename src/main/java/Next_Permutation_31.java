import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-9.
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Next_Permutation_31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        if (i < 0)
            Arrays.sort(nums);
        else {
            int j = nums.length - 1;
            for (; j > i; --j) {
                if(nums[j] > nums[i])
                    break;
            }
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];

            Arrays.sort(nums,i+1,nums.length);
        }
    }

    public static void main(String[] args) {
        Next_Permutation_31 next_permutation_31 = new Next_Permutation_31();
        int[] ints = {1, 2, 3, 4, 5};
        next_permutation_31.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
