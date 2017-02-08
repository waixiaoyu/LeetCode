
public class Solution397 {

	public int integerReplacement(int n) {
		double d=n;
		if (n > 0) {
			return (int)getStepFromInteger(d);
		} else {
			return 0;
		}
	}

	private double getStepFromInteger(double n) {
		if (n == 2) {
			return 1;
		} else if (n == 1) {
			return 0;
		} else {
			if (n % 2 == 0) {
				return getStepFromInteger(n / 2) + 1;
			} else {
				return Math.min(getStepFromInteger(n + 1), getStepFromInteger(n - 1)) + 1;
			}
		}
	}

	public static void main(String[] args) {
		Solution397 s = new Solution397();
		System.out.println(s.integerReplacement(2147483647));
	}
}
