import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution436 {
    public int[] findRightInterval(Interval[] intervals) {
        int[] nResults = new int[intervals.length];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            tm.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Entry<Integer, Integer> e = tm.ceilingEntry(intervals[i].end);
            nResults[i] = e == null ? -1 : e.getValue();
        }
        return nResults;
    }

    public static void main(String[] args) {
        Solution436 s = new Solution436();
        Interval[] intervals = { new Interval(1, 12), new Interval(2, 9), new Interval(3, 10), new Interval(13, 14) };
        System.out.println(s.findRightInterval(intervals));
    }
}

class Interval {
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