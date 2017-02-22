import java.util.Arrays;

public class Solution274 {
	public int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int h = 0;
		for (int i = citations.length - 1; i >= 0; i--) {
			if (citations.length - i > citations[i]) {
				h = citations.length - i;
				break;
			}
			if (i == 0) {
				h = citations.length + 1;
			}
		}
		return h - 1;
	}

	public static void main(String[] args) {
		Solution274 s = new Solution274();
		int[] citations = { 1 };
		System.out.println(s.hIndex(citations));
	}
}
