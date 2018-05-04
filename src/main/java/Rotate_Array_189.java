/**
 * Created by zhongjianlv on 2018/2/23
 * <p>
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 */
public class Rotate_Array_189 {

    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return;
        k %= nums.length;
        int j = 0;
        int base = 0;
        while(j != nums.length){
            int temp = nums[base];
            int i = k+base;
            while(i!=base){
                nums[i] ^= temp;
                temp ^= nums[i];
                nums[i] ^= temp;
                i += k;
                i %= nums.length;
                ++j;
            }
            nums[i] ^= temp;
            temp ^= nums[i];
            nums[i] ^= temp;
            ++j;
            ++base;
        }

    }
}
