import java.util.*;

import tool.SumRange;

/**
 * Created by zhongjianlv on 18-4-3.
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class Range_Sum_Query_Mutable_307 {

    SumRange sumRange;

    public Range_Sum_Query_Mutable_307(int[] nums) {
        sumRange = new SumRange(nums);
    }

    public void update(int i, int val) {
        sumRange.modify(i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange.query(i, j);
    }

    public static void main(String[] args) {

//        System.out.println(1 >> 1);
        Range_Sum_Query_Mutable_307 range_sum_query_mutable_307 = new Range_Sum_Query_Mutable_307(new int[]{0,9,5,7,3});
        System.out.println(range_sum_query_mutable_307.sumRange(0,2));


    }

}
