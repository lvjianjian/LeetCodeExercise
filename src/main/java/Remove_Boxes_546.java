import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhongjianlv on 18-1-19.
 * <p>
 * Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
 * Find the maximum points you can get.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * Output:
 * 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 * ----> [1, 3, 3, 3, 1] (1*1=1 points)
 * ----> [1, 1] (3*3=9 points)
 * ----> [] (2*2=4 points)
 * <p>
 * Note: The number of boxes n would not exceed 100.
 */
public class Remove_Boxes_546 {
    public int removeBoxes(int[] boxes) {
        if (boxes == null) return 0;
        int n = boxes.length;
        if (n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[][] res = new int[n][n];
        for (int i = 1; i < n; i++) {
            if (boxes[i] == boxes[i - 1])
                left[i] = left[i - 1];
            else left[i] = i;
        }

        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (boxes[i] == boxes[i + 1])
                right[i] = right[i + 1];
            else right[i] = i;
        }

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        int max;
        for (int length = 1; length < n; length++) {
            for (int i = 0, end = n - length; i < end; i++) {
                int e = i + length;
                max = 0;
                if (boxes[i] == boxes[e]) {
                    if (right[i] >= left[e]) {
                        max = (e - i + 1) * (e - i + 1);
                    } else {
                        max = res[right[i] + 1][left[e] - 1] + (right[i] - i + e - left[e] + 2) * (right[i] - i + e - left[e] + 2);
                    }
                } else {
                    for (int k = i; k < e; k++) {
                        max = Math.max(max, res[i][k] + res[k + 1][e]);
                    }
                }
                res[i][e] = max;
            }
        }
        return res[0][n - 1];
    }


    public static void main(String[] args) {
        Remove_Boxes_546 remove_boxes_546 = new Remove_Boxes_546();
        System.out.println(remove_boxes_546.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
        ArrayList<Object> objects = new ArrayList<>();
        objects.get(0);
    }
}
