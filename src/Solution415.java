
public class Solution415 {
	private static final char ZERO = '0';
	public String addStrings(String num1, String num2) {
		if (num1.length() == 0 || num2.length() == 0) {
			return num1.length() == 0 ? num1 : num2;
		}
		char[] cArr1 = num1.length() >= num2.length() ? num1.toCharArray() : num2.toCharArray();
		char[] cArr2 = num1.length() < num2.length() ? num1.toCharArray() : num2.toCharArray();
		int nCount = 0;
		int nMinLength = cArr2.length;
		int nMaxLength = cArr1.length;

		char[] cArrResult = new char[nMaxLength + 1];
		boolean bUpDigit = false;
		while (nCount < nMaxLength) {
			char c1 = cArr1[cArr1.length - nCount - 1];
			char c2 = nCount < nMinLength ? cArr2[cArr2.length - nCount - 1] : ZERO;
			int nCurrentDigit = (int) (c1 - ZERO) + (int) (c2 - ZERO);
			nCurrentDigit = bUpDigit ? nCurrentDigit + 1 : nCurrentDigit;
			bUpDigit = false;
			if (nCurrentDigit > 9) {
				bUpDigit = true;
				nCurrentDigit -= 10;
			}
			cArrResult[cArrResult.length - nCount - 1] = (char) (nCurrentDigit + ZERO);
			nCount++;
		}
		String strResult = String.valueOf(cArrResult).substring(1);
		return bUpDigit ? 1 + strResult : strResult;
	}

	public static void main(String[] args) {
		Solution415 s = new Solution415();
		System.out.println(s.addStrings("999", "999"));
	}
}
