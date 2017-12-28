import java.util.Arrays;

/**
 * Created by zhongjianlv on 17-12-28.
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Remove_Element_27 {
    public int removeElement(int[] nums, int val) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[end++] = nums[i];
        }
        return end;
    }

    public static void main(String[] args) {
        Remove_Element_27 remove_element_27 = new Remove_Element_27();
        int[] a = new int[]{3, 2, 2, 3};
        System.out.println(remove_element_27.removeElement(a, 3));
        System.out.println(Arrays.toString(a));

    }
}
