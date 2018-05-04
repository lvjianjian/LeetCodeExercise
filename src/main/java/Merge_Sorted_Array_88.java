/**
 * Created by zhongjianlv on 18-2-4.
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Merge_Sorted_Array_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m + n - 1 >= 0 && m - 1 >=0 && n - 1 >= 0){
            if(nums1[m-1] > nums2[n - 1]){
                nums1[m + n - 1] = nums1[m-1];
                --m;
            }else{
                nums1[m + n - 1] = nums2[n-1];
                --n;
            }
        }
        while(n-1 >=0){
            nums1[m + n - 1] = nums2[n-1];
            --n;
        }
    }
}
