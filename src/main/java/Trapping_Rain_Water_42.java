/**
 * Created by zhongjianlv on 18-1-5.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Trapping_Rain_Water_42 {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int c_max = 0;
        int index = 0;
        int sum = 0;
        int c_sum = 0;
        int i = 0;
        //从前往后
        while (height[i] == 0)// 找到第一个非0
            ++i;
        index = i;
        c_max = height[i];
        for (++i; i < height.length; ++i) {
            if (c_max <= height[i]) {
                sum += c_sum;
                c_sum = 0;
                index = i;
                c_max = height[i];
            } else {
                c_sum += (height[index] - height[i]);
            }
        }

        //从后往前到最高
        while (height[--i] == 0) ;
        c_sum = 0;
        int index2 = i;
        c_max = height[i];
        for (--i; i >= index; --i) {
            if (c_max <= height[i]) {
                sum += c_sum;
                c_sum = 0;
                index2 = i;
                c_max = height[i];
            } else {
                c_sum += (height[index2] - height[i]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Trapping_Rain_Water_42 trapping_rain_water_42 = new Trapping_Rain_Water_42();
        System.out.println(trapping_rain_water_42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
