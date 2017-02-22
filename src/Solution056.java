import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution056 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> listResult = new LinkedList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int nStart, nEnd;
		if (intervals.size() > 0) {
			nStart = intervals.get(0).start;
			nEnd = intervals.get(0).end;
		} else {
			return listResult;
		}

		for (Interval interval : intervals) {
			if (interval.end > nEnd) {
				if (interval.start > nEnd) {
					listResult.add(new Interval(nStart, nEnd));
					nStart = interval.start;
					nEnd = interval.end;
				} else {
					nEnd = interval.end;
				}
			}
		}
		listResult.add(new Interval(nStart, nEnd));

		return listResult;

	}

	public static class Interval {
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

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) {
		Solution056 s = new Solution056();
		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(15, 18));
		System.out.println(s.merge(intervals));
	}
}
