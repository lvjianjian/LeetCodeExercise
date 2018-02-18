import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 2018/2/18
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
public class Summary_Ranges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if(nums.length==0) return result;
        int start=nums[0];
        for(int i = 1; i <= nums.length;++i){
            if(i == nums.length || (long)nums[i] - nums[i-1] > 1){
                if(nums[i-1] == start){
                    result.add(start+"");
                }else{
                    result.add(start+"->"+nums[i-1]);
                }
                if(i!=nums.length)
                    start = nums[i];
            }
        }
        return result;
    }
}
