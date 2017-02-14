import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution409 {

	public int longestPalindrome(String s) {
		int nLongestLength = 0;
		boolean bAlone = false;
		char[] cArr = s.toCharArray();
		int nIndex = 0;
		while (nIndex < cArr.length) {
			int nCurrentNum = 0;

			char cLast = cArr[nIndex];
			for (int i = 0; i < cArr.length; i++) {
				if (cLast == cArr[i]) {
					nCurrentNum++;
					cArr[i] = '*';
				}
				while (i + 1 < cArr.length && cArr[i + 1] == '*') {
					i++;
				}
			}
			nLongestLength += (nCurrentNum / 2) * 2;
			bAlone = (!bAlone && nCurrentNum % 2 == 1) ? true : bAlone;
			while (nIndex + 1 < cArr.length && cArr[nIndex + 1] == '*') {
				nIndex++;
			}
			nIndex++;
		}
		return bAlone ? nLongestLength + 1 : nLongestLength;
	}

	public static void main(String[] args) {
		Solution409 s = new Solution409();
		System.out.println(s.longestPalindrome("abccccdd"));
	}
}
