import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhongjianlv on 18-1-16.
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Merge_Intervals_56 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList();
        if(intervals == null || intervals.size() == 0)
            return result;
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); ++i){
            Interval current = intervals.get(i);
            int j1 = 0;
            while(j1 < result.size() && result.get(j1).end < current.start) ++j1;
            int j2 = j1;
            while(j2 < result.size() && result.get(j2).start <= current.end) ++j2;
            if(j1==j2)
                result.add(j1,current);
            else{
                result.get(j1).start = Math.min(result.get(j1).start,current.start);
                result.get(j1).end = Math.max(result.get(j2-1).end,current.end);
                while(j1!=j2 - 1){
                    result.remove(j1+1);
                    --j2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Merge_Intervals_56 merge_intervals_56 = new Merge_Intervals_56();
        LinkedList<Interval> intervals = new LinkedList<>();
        intervals.add(merge_intervals_56.new Interval(4,6));
        intervals.add(merge_intervals_56.new Interval(3,4));
        intervals.add(merge_intervals_56.new Interval(15,18));
        intervals.add(merge_intervals_56.new Interval(1,3));
        List<Interval> merge = merge_intervals_56.merge(intervals);
    }
}
