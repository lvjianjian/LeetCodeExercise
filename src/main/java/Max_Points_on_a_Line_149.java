import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhongjianlv on 17-12-22.
 */
public class Max_Points_on_a_Line_149 {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null)
            return 0;
        if (points.length <= 2)
            return points.length;
        int temp_max = 0;
        int max = 0;
        int tong;
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < points.length; ++i){
            Point p1 = points[i];
            tong = 1;
            temp_max = 0;
            for(int j = i+1; j < points.length; ++j){
                Point p2 = points[j];
                String r = computeLine(p1.x,p1.y,p2.x,p2.y);
                if(r == null) ++tong;
                else{
                    if(map.containsKey(r)){
                        map.put(r,map.get(r) + 1);
                        if(map.get(r) > temp_max) temp_max = map.get(r);
                    }else{
                        if(!set.contains(r)){
                            set.add(r);
                            map.put(r,1);
                            if(temp_max == 0) temp_max = 1;
                        }
                    }
                }
            }
            if(tong + temp_max > max) max = tong + temp_max;
            map.clear();
        }
        return max;
    }


    private String computeLine(int x1, int y1, int x2, int y2){
        long a = y1 - y2;
        long b = x1 - x2;
        String r = null;
        if(a == 0 && b == 0){
            return r;
        }else if(a == 0){
            r= "y=" + y1;
        }else if(b == 0){
            r = "x=" + x1;
        }else{
            if((a > 0 && b < 0) || (a < 0 && b > 0)){
                r = "-";
                a = Math.abs(a);
                b = Math.abs(b);
            }else r = "";
            long lcm = LCM(a,b);
            a = a / lcm;
            b = b / lcm;
            if(r.equals("-")){
                a = -a;
            }
            long c = b * y1 - a * x1;
            r += (a + "," + b + "," + c);

        }
        return r;
    }


    private long LCM(long a, long b){
        if(a < b){
            long temp = b;
            b = a;
            a = temp;
        }
        long yu;
        while((yu = a % b) !=0){
            a = b;
            b = yu;
        }
        return b;
    }

    public static void main(String[] args) {
        Max_Points_on_a_Line_149 max_points_on_a_line_149 = new Max_Points_on_a_Line_149();
        System.out.println(max_points_on_a_line_149.computeLine(2, 2, 3, 3));
        System.out.println(max_points_on_a_line_149.computeLine(7, 7, 6, 6));
    }
}
