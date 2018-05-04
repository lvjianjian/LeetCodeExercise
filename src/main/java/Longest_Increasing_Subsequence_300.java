
/**
 * Created by zhongjianlv on 18-3-14.
 */
public class Longest_Increasing_Subsequence_300 {

    // O(n^2) is native
    //O(nlogn)
    //基本思路, res数组存储当前为止最小可能的最长递增序列, 但是要注意当前的递增序列未必是真正的结果!
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        int replaceIndex;
        for (int i = 0; i < nums.length; i++) {
            replaceIndex = binarySearch(res, index, nums[i]);
            res[replaceIndex] = nums[i];
            if (replaceIndex == index) {
                ++index;
            }
        }
        return index;
    }

    //二分查找寻找比value大于等于的第一个下标索引
    private int binarySearch(int[] temp, int length, int value) {
        int i = 0;
        int j = length - 1;
        int mid;
        while (i <= j) {
            mid = i + ((j - i) >> 1);
            if (temp[mid] < value) {
                i = mid + 1;
            } else {
                if (mid - 1 == -1 || temp[mid - 1] < value) return mid;
                j = mid - 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Longest_Increasing_Subsequence_300 longest_increasing_subsequence_300 = new Longest_Increasing_Subsequence_300();
        System.out.println(longest_increasing_subsequence_300.lengthOfLIS(new int[]{2, 2}));
    }

}
