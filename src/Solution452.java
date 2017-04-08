import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		if (points.length < 1) {
			return 0;
		}
		int nArrow = 0;
		int nLimit = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= nLimit) {
				nLimit = Math.min(points[i][1], nLimit);
			} else {
				nArrow++;
				nLimit = points[i][1];
			}
		}
		return nArrow + 1;
	}

	public static void main(String[] args) {
		Solution452 s = new Solution452();
		int[][] ps = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		System.out.println(s.findMinArrowShots(ps));
	}
}
