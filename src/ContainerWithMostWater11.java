/**
 * Created by zhongjian on 2017/4/1.
 *
 * leetcode algorithm 11
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater11 {

    /**
     * 短板效应，替换最小边找到最大矩形面积
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, oldl = l, oldr= height.length - 1, r = oldr, maxarea = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
            if(height[l] > height[oldl] || height[r] > height[oldr]) {//新的边比原来的短边大有可能出现最大面积
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                oldl = l;
                oldr = r;
            }
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
        System.out.println(containerWithMostWater11.maxArea(new int[]{68,113,143,194,176,62,158,162,103,75,104,179,189,150,151,180,76
                                                                    ,158,158,19,198,42,119,13,127,158,193,59,146,80,41,15,193,184,161
                                                                    ,121,198,71,83,102,146,139,33,135,89,184,115,117,142,25,136,93,67
                                                                    ,7,106,146,165,100,6,64,180,47,31,125,183,192,46,182,63,129,36,161
                                                                    ,68,69,96,110,54,164,27,148,189,116,41,9,123,100,155,89,152,113,153
                                                                    ,84,160,184,9,144,128,55,78,143}));
    }
}
