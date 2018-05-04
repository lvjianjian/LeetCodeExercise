import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-23.
 * <p>
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class Remove_Duplicates_from_Sorted_Array_II_80 {
    private int k = 2;
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= k) return nums.length;
        int current = nums[0];
        int start = 1;
        int end = 0;
        int num = 1;
        for(;start < nums.length; ++start){
            if(nums[start] == current){
                ++num;
                if(num > k) break;
            }else{
                num = 1;
                current = nums[start];

            }
        }

        for(end = start;end < nums.length; ++end){
            if(num < k){
                if(nums[end] > current){
                    current = nums[end];
                    num = 1;
                }else{
                    ++num;
                }
                nums[start] = nums[end];
                ++start;
            }else{
                if(nums[end] > current){
                    num = 0;
                    --end;
                }
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array_II_80 remove_duplicates_from_sorted_array_ii_80 = new Remove_Duplicates_from_Sorted_Array_II_80();
        int[] ints = {1, 1, 2, 3, 3, 4, 5, 6, 7, 7, 7, 8, 10};
        System.out.println(remove_duplicates_from_sorted_array_ii_80.removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
    }

}
