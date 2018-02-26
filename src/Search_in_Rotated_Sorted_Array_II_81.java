/**
 * Created by zhongjianlv on 18-2-26.
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * The array may contain duplicates.
 */
public class Search_in_Rotated_Sorted_Array_II_81 {

    public boolean search(int[] nums, int target) {
        int l = 0,h = nums.length - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(nums[mid] == target) return true;
            if(nums[l] < nums[h]){
                if(nums[mid] < target){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }
            }else if(nums[l] == nums[h]){
                --h;
            }else{
                if(nums[mid] < target){
                    if(nums[mid] > nums[h]){
                        l = mid+1;
                    }else{
                        if(target >= nums[l])
                            h = mid-1;
                        else
                            l = mid+1;
                    }
                }else{
                    if(nums[mid] <= nums[h]){
                        h = mid - 1;
                    }else{
                        if(target <= nums[h])
                            l = mid+1;
                        else
                            h = mid-1;
                    }
                }
            }


        }
        return false;
    }

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array_II_81 search_in_rotated_sorted_array_ii_81 = new Search_in_Rotated_Sorted_Array_II_81();
        System.out.println(search_in_rotated_sorted_array_ii_81.search(new int[]{3,5,1},1));
        System.out.println(search_in_rotated_sorted_array_ii_81.search(new int[]{3,5,1},3));
        System.out.println(search_in_rotated_sorted_array_ii_81.search(new int[]{3,1,2,2,2},1));
        System.out.println(search_in_rotated_sorted_array_ii_81.search(new int[]{1,1,1,3,1},3));
        System.out.println(search_in_rotated_sorted_array_ii_81.search(new int[]{1,1,3,1},3));

    }
}
