import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjianlv on 18-3-13.
 * <p>
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 * <p>
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class H_Index_274 {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        int h = 0;
        int s = 0;
        for(int i = 0; i < citations.length; ++i){
            int ci = citations[i];
            if(ci >= h){
                int news = s + (ci>h?1:0) - map.getOrDefault(h,0);
                if(news > h){
                    ++h;
                    s = news;
                }else{
                    ++s;
                }
            }
            map.put(ci,map.getOrDefault(ci,0)+1);
        }
        return h;
    }

    public static void main(String[] args) {
        H_Index_274 h_index_274 = new H_Index_274();
        System.out.println(h_index_274.hIndex(new int[]{0,0}));
    }
}
