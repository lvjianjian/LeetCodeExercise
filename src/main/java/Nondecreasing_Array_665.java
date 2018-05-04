/**
 * Created by zhongjianlv on 17-12-26.
 * <p>
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 */
public class Nondecreasing_Array_665 {

    //可以进一步归类化间
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2)
            return true;
        int num = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] > nums[i]) {
                if (nums[i + 2] >= nums[i + 1])
                    continue;
                else {
                    ++num;
                    if (num >= 2)
                        return false;
                    if (nums[i + 2] >= nums[i]) {
                        nums[i + 1] = nums[i + 2];
                    } else {
                        nums[i + 2] = nums[i + 1];
                    }


                }
            } else if (nums[i + 1] == nums[i]) {
                if (nums[i + 2] >= nums[i + 1])
                    continue;
                else {
                    ++num;
                    if (num >= 2)
                        return false;
                    nums[i + 2] = nums[i + 1];
                }
            } else {
                if (nums[i + 2] < nums[i + 1])
                    return false;
                else {
                    ++num;
                    if (num >= 2)
                        return false;
                    nums[i] = nums[i + 1];
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Nondecreasing_Array_665 nondecreasing_array_665 = new Nondecreasing_Array_665();
        System.out.println(nondecreasing_array_665.checkPossibility(new int[]{3,4,2,3}));
    }
}
