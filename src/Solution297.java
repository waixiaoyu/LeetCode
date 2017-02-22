
public class Solution297 {

	public int numSquares(int n) {
		if (isSquare(n)) {
			return 1;
		}
		while ((n % 4) == 0) // n%4 == 0
		{
			n >>= 2;
		}
		if ((n % 8) == 7) // n%8 == 7
		{
			return 4;
		}
		return n;
	}

	private boolean isSquare(int n) {
		int nSqr = (int) Math.sqrt(n);
		return nSqr * nSqr == n ? true : false;
	}

	public static void main(String[] args) {
		Solution297 s = new Solution297();
		System.out.println(s.numSquares(8609));
	}
}
