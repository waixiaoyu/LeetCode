
public class Solution424 {
	boolean isReadDigit;

	public int characterReplacement(String s, int k) {
		if (s.length() <= k) {
			return s.length();
		}
		char[] cArr = s.toCharArray();
		int nMinWin = (int) ((double) k / 25 * 26);
		int nWindowSize = nMinWin > k + 1 ? nMinWin : k + 1;

		int[] nArrDigit = new int[26];
		// init find min window at index 0
		for (int i = 0; i < nWindowSize; i++) {
			nArrDigit[cArr[i] - 'A']++;
		}
		while (nWindowSize <= s.length()) {
			int nMax = -1;
			for (int i : nArrDigit) {
				nMax = i > nMax ? i : nMax;
			}
			if (nMax + k >= nWindowSize) {
				nWindowSize++;
			} else {
				break;
			}
		}
		while (nWindowSize <= s.length()) {
			boolean isFindLongest = false;
			isReadDigit = false;
			nArrDigit = new int[26];
			for (int i = 0; i <= cArr.length - nWindowSize; i++) {
				if (nWindowSize - findMaxDigit(i, nWindowSize, cArr, nArrDigit) <= k) {
					isFindLongest = true;
					break;
				}
			}
			if (isFindLongest) {
				nWindowSize++;
			} else {
				break;
			}
		}
		return nWindowSize - 1;
	}

	private int findMaxDigit(int nIndex, int nSize, char[] cArr, int[] nArrDigit) {
		if (!isReadDigit) {
			for (int i = nIndex; i < nIndex + nSize; i++) {
				nArrDigit[cArr[i] - 'A']++;
				isReadDigit = true;
			}
		} else {
			nArrDigit[cArr[nIndex - 1] - 'A']--;
			nArrDigit[cArr[nIndex + nSize - 1] - 'A']++;
		}
		int nMax = -1;
		for (int i : nArrDigit) {
			nMax = i > nMax ? i : nMax;
		}
		return nMax;
	}

	public static void main(String[] args) {
		Solution424 s = new Solution424();
		System.out.println(s.characterReplacement("AABABBA", 1));
	}
}
