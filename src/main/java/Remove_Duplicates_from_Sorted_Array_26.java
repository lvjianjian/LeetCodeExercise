import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-5.
 */
public class Remove_Duplicates_from_Sorted_Array_26 {

    public int removeDuplicates(int[] nums) {
        int start = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1])
                nums[start++] = nums[i];
        }

        return start;
    }

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array_26 remove_duplicates_from_sorted_array_26 = new Remove_Duplicates_from_Sorted_Array_26();
        int[] nums = new int[]{1,2,2,2,3,4,5,5,5,9,10};
        System.out.println(remove_duplicates_from_sorted_array_26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
