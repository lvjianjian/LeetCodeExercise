import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-4-20.
 * <p>
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */
public class Find_All_Duplicates_in_an_Array_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            while (temp > 0 && temp - 1 != i) {
                if (nums[temp - 1] == nums[i]) {
                    res.add(nums[i]);
                    nums[i] = -1;
                    break;
                }
                nums[temp - 1] ^= nums[i];
                nums[i] ^= nums[temp - 1];
                nums[temp - 1] ^= nums[i];
                temp = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Find_All_Duplicates_in_an_Array_442 find_all_duplicates_in_an_array_442 = new Find_All_Duplicates_in_an_Array_442();
        System.out.println(find_all_duplicates_in_an_array_442.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
