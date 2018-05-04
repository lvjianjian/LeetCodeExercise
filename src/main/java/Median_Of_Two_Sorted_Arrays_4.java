import java.util.Scanner;

/**
 * Created by zhongjianlv on 17-12-26.
 */
public class Median_Of_Two_Sorted_Arrays_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] num = new int[split.length];
        System.out.println(num.length);
        for (int i = 0; i < split.length; i++) {
            num[i] = Integer.valueOf(split[i].trim());
            System.out.println(num[i]);
        }

    }
}
