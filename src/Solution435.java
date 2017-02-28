import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        int nInsert = 1;
        int nLastEnd = intervals[0].end;
        for (Interval interval : intervals) {
            if (interval.start >= nLastEnd) {
                nLastEnd = interval.end;
                nInsert++;
            }
        }
        return intervals.length - nInsert;
    }

    public static void main(String[] args) {
        Solution435 s = new Solution435();
        Interval[] intervals = { new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3) };
        System.out.println(s.eraseOverlapIntervals(intervals));
    }

    static class Interval {
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
}
