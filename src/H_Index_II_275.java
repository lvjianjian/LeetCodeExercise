/**
 * Created by zhongjianlv on 18-3-13.
 * <p>
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class H_Index_II_275 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0) return 0;
        int h = 0;
        for(int i = citations.length - 1; i >= 0; --i){
            if(citations[i] > h)
                ++h;
            else break;
        }
        return h;
    }
}
