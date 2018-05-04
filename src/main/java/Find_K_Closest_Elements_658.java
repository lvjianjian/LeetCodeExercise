import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-3-27.
 * <p>
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */
public class Find_K_Closest_Elements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        int index = binarySearch(arr, x);
        int i = index - 1;
        int j = index;
        while (i >= 0 && j < arr.length) {
            if (k == 0) break;
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                result.add(0, arr[i]);
                --i;
            } else {
                result.add(arr[j]);
                ++j;
            }
            --k;
        }
        while (k > 0 && i >= 0) {
            result.add(0, arr[i--]);
            --k;
        }
        while (k > 0 && j < arr.length) {
            result.add(arr[j++]);
            --k;
        }

        return result;
    }

    /**
     * 返回x在arr的最接近的索引
     *
     * @param arr
     * @param x
     * @return 0-arr.length
     */
    private int binarySearch(int[] arr, int x) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
