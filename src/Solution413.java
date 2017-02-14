
public class Solution413 {

	public int numberOfArithmeticSlices(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		int nTotal = 0;
		for (int i = 0; i < A.length - 2; i++) {
			int nCurrentIndex = i;
			int nCurrentDiff = Integer.MAX_VALUE;
			// find first seq
			if (isSeq(A[nCurrentIndex], A[nCurrentIndex + 1], A[nCurrentIndex + 2])) {
				nCurrentDiff = A[nCurrentIndex + 1] - A[nCurrentIndex];
				nTotal++;
				nCurrentIndex += 3;
				// find follow seq
				while (nCurrentIndex < A.length) {
					if (A[nCurrentIndex] - A[nCurrentIndex - 1] == nCurrentDiff) {
						nTotal++;
						nCurrentIndex++;
					} else {
						break;
					}
				}
			}
		}
		return nTotal;

	}

	private boolean isSeq(int a, int b, int c) {
		return b - a == c - b ? true : false;
	}

	public static void main(String[] args) {
		Solution413 s = new Solution413();
		int[] a = { 1, 2, 3, 4 };
		System.out.println(s.numberOfArithmeticSlices(a));
	}
}
