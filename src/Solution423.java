
public class Solution423 {
	private static final String[] NUMBERS_STRING = { "zero", "two", "four", "six", "eight", "five", "seven", "one",
			"three", "nine" };
	private static final char[] DIGITS = { 'z', 'w', 'u', 'x', 'g', 'f', 'v', 'o', 't', 'i' };
	private static final int[] NUMBERS = { 0, 2, 4, 6, 8, 5, 7, 1, 3, 9 };

	public String originalDigits(String s) {
		StringBuilder sb = new StringBuilder();
		char[] cArs = s.toCharArray();
		int[] nArrChars = new int[26];
		for (char c : cArs) {
			nArrChars[c - 'a']++;
		}
		int[] nArrResult = new int[10];
		for (int i = 0; i < 10; i++) {
			nArrResult[NUMBERS[i]] = nArrChars[DIGITS[i] - 'a'];
			minusDigits(nArrChars, NUMBERS_STRING[i], nArrResult[NUMBERS[i]]);
		}
		// add all number
		for (int i = 0; i < nArrResult.length; i++) {
			for (int j = 0; j < nArrResult[i]; j++) {
				sb.append((char) (i + (int) '0'));
			}
		}

		return sb.toString();
	}

	private void minusDigits(int[] nArr, String str, int value) {
		char[] cArr = str.toCharArray();
		for (char c : cArr) {
			nArr[c - 'a'] -= value;
		}
	}

	public static void main(String[] args) {
		Solution423 s = new Solution423();
		System.out.println(s.originalDigits("fviefuro"));
	}
}
