import java.util.*;

/**
 * Created by zhongjianlv on 18-3-25.
 * <p>
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class Number_of_Longest_Increasing_Subsequence_673 {


    //速度慢
    public int findNumberOfLIS2(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        List<TreeMap<Integer, Integer>> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = r.size() - 1; j >= -1; j--) {
                if (j == -1) {
                    if (j + 1 >= r.size()) {
                        r.add(new TreeMap<>());
                        r.get(j + 1).put(nums[i], 1);
                    } else {
                        TreeMap<Integer, Integer> map1 = r.get(j + 1);
                        map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
                    }
                    break;
                }
                TreeMap<Integer, Integer> map = r.get(j);
                NavigableMap<Integer, Integer> temp = map.headMap(nums[i], false);
                if (temp != null && temp.size() != 0) {
                    int all = 0;
                    Iterator<Integer> iterator = temp.values().iterator();
                    while (iterator.hasNext()) {
                        all += iterator.next();
                    }
                    if (j + 1 >= r.size()) {
                        r.add(new TreeMap<>());
                        r.get(j + 1).put(nums[i], all);
                        break;
                    } else {
                        TreeMap<Integer, Integer> map1 = r.get(j + 1);
                        map1.put(nums[i], map1.getOrDefault(nums[i], 0) + all);
                    }
                }
            }
        }
        TreeMap<Integer, Integer> map = r.get(r.size() - 1);
        Iterator<Integer> iterator = map.values().iterator();
        int num = 0;
        while (iterator.hasNext()) {
            num += iterator.next();
        }
        return num;
    }

    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[][] r = new int[length][2];
        int max = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int temp = 0;// maxLength
            int count = 0;// numOfMaxLength
            for (int j = 0; j < i; j++) {
                if (nums[j] < value) {
                    if (r[j][0] > temp) {
                        temp = r[j][0];
                        count = r[j][1];
                    } else if (r[j][0] == temp) {
                        count += r[j][1];
                    }
                }
            }
            r[i][0] = temp + 1;
            if (count == 0)
                ++count;
            r[i][1] = count;
            if (r[i][0] > max) {
                max = r[i][0];
                num = r[i][1];
            } else if (r[i][0] == max)
                num += r[i][1];
        }
        return num;
    }

    public static void main(String[] args) {
        Number_of_Longest_Increasing_Subsequence_673 number_of_longest_increasing_subsequence_673 = new Number_of_Longest_Increasing_Subsequence_673();
//        System.out.println(number_of_longest_increasing_subsequence_673.findNumberOfLIS(new int[]{1, 1, 1}));
        System.out.println(number_of_longest_increasing_subsequence_673.findNumberOfLIS2(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }
}
