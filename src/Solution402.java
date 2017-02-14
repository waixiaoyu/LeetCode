
public class Solution402 {
	public String removeKdigits(String num, int k) {
		if (num.length() <= k) {
			return "0";
		}
		int nHasDeleteDigit = 0;
		int nCurrentIndex = 0;
		char cLastChar = num.charAt(nCurrentIndex);
		while (nHasDeleteDigit < k && nCurrentIndex + 1 < num.length()) {
			if (num.charAt(nCurrentIndex) == '0') {
				while (num.charAt(nCurrentIndex) == '0') {
					num = num.substring(1, num.length());
				}
				cLastChar = num.charAt(nCurrentIndex);
			}

			nCurrentIndex++;
			if (num.charAt(nCurrentIndex) < cLastChar) {
				if (nCurrentIndex == 1 && num.charAt(nCurrentIndex) == '0') {
					num = num.substring(2, num.length());
					nCurrentIndex = 0;
				} else {
					num = num.substring(0, nCurrentIndex - 1) + num.substring(nCurrentIndex, num.length());
					nCurrentIndex -= 2;
				}
				nHasDeleteDigit++;
			}
			if (nCurrentIndex < num.length()) {
				if (nCurrentIndex < 0) {
					nCurrentIndex = 0;
				}
				cLastChar = num.charAt(nCurrentIndex);

			} else {
				return "0";
			}
		}
		if (k - nHasDeleteDigit > 0) {
			int nRemove = k - nHasDeleteDigit;
			return num.substring(0, num.length() - nRemove);
		} else {
			return num;
		}
	}

	public static void main(String[] args) {
		Solution402 s = new Solution402();
		System.out.println(s.removeKdigits("5337", 2));
	}
}
