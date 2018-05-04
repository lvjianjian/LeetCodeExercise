import java.util.List;

/**
 * Created by zhongjianlv on 18-1-16.
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Insert_Interval_57 {

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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int j1 = 0;
        while (j1 < intervals.size() && intervals.get(j1).end < newInterval.start) ++j1;
        int j2 = j1;
        while (j2 < intervals.size() && intervals.get(j2).start <= newInterval.end) ++j2;
        if (j1 == j2)
            intervals.add(j1, newInterval);
        else {
            intervals.get(j1).start = Math.min(intervals.get(j1).start, newInterval.start);
            intervals.get(j1).end = Math.max(intervals.get(j2 - 1).end, newInterval.end);
            while (j1 != j2 - 1) {
                intervals.remove(j1 + 1);
                --j2;
            }
        }

        return intervals;
    }
}
