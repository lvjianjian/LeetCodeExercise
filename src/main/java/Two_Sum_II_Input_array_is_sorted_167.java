/**
 * Created by zhongjianlv on 2018/2/12
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Two_Sum_II_Input_array_is_sorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] r = new int[2];
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                r[0] = i+1;
                r[1] = j+1;
                break;
            }
            else if(numbers[i] + numbers[j] > target){
                --j;
            }else{
                ++i;
            }
        }
        return r;
    }

}
