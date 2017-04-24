import java.util.Arrays;

public class Solution495 {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		Arrays.sort(timeSeries);
		int nDu = 0;
		for (int i = 1; i < timeSeries.length; i++) {
			int nDiff = timeSeries[i] - timeSeries[i - 1];
			nDu += nDiff > duration ? duration : nDiff;
		}
		nDu += timeSeries.length > 0 ? duration : 0;
		return nDu;
	}

	public static void main(String[] args) {
		Solution495 s = new Solution495();
		int[] timeSeries = { 1, 4 };
		System.out.println(s.findPoisonedDuration(timeSeries, 2));
	}
}
