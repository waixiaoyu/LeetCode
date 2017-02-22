
public class Solution482 {
	public String licenseKeyFormatting(String S, int K) {
		S = S.replaceAll("-", "").toUpperCase();
		int nRes = S.length() % K;
		StringBuilder sb = new StringBuilder(S);
		int nIndex = nRes;
		if (nRes == 0) {
			nIndex = K;
		}
		while (nIndex < S.length()) {
			sb.insert(nIndex, '-');
			nIndex++;
			nIndex += K;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution482 s = new Solution482();
		System.out.println(s.licenseKeyFormatting("abc--abc", 3));
	}
}
