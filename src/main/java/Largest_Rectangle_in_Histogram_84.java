import java.util.Arrays;

/**
 * Created by zhongjianlv on 18-1-23.
 */
public class Largest_Rectangle_in_Histogram_84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i = 1; i < n; ++i){
            l[i] = i;
            while(l[i]-1 >= 0 && heights[l[i]-1] >= heights[i]){
                l[i] = l[l[i]-1];
            }
        }

        r[n-1] = n-1;
        for(int i = n-2; i >=0; --i){
            r[i] = i;
            while(r[i]+1 < n && heights[r[i]+1] >= heights[i]){
                r[i] = r[r[i]+1];
            }
        }

        int max = 0;
        for(int i = 0;i <n; ++i){
            max = Math.max(max,heights[i] * (r[i] - l[i] + 1));
        }
        return max;
    }


    public static void main(String[] args) {
        Largest_Rectangle_in_Histogram_84 largest_rectangle_in_histogram_84 = new Largest_Rectangle_in_Histogram_84();
        System.out.println(largest_rectangle_in_histogram_84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
