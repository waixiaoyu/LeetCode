
public class Solution481 {
	public int magicalString(int n) {
		int nTotal = 1;
		if (n <= 3) {
			return nTotal;
		}
		StringBuilder sb = new StringBuilder("122");
		int nDecoderIndex = 2;
		while (sb.length() < n) {
			if (sb.charAt(sb.length() - 1) == '1') {
				if (sb.charAt(nDecoderIndex) == '1') {
					sb.append("2");
				} else {
					sb.append("22");
				}
			} else {
				if (sb.charAt(nDecoderIndex) == '1') {
					sb.append("1");
					nTotal += 1;
				} else {
					sb.append("11");
					nTotal += 2;
				}
			}
			nDecoderIndex++;
		}
		if (n < sb.length() && sb.charAt(sb.length() - 1) == '1') {
			return nTotal - 1;
		} else {
			return nTotal;
		}
	}

	public static void main(String[] args) {
		Solution481 s = new Solution481();
		System.out.println();
	}
}
