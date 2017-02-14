
public class Solution414 {
	public int thirdMax(int[] nums) {
		double nFirst = Double.NEGATIVE_INFINITY;
		double nSecond = Double.NEGATIVE_INFINITY;
		double nThird = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nThird) {
				if (nums[i] < nSecond) {
					nThird = nums[i];
				} else if (nums[i] > nSecond && nums[i] < nFirst) {
					nThird = nSecond;
					nSecond = nums[i];
				} else if (nums[i] > nFirst) {
					nThird = nSecond;
					nSecond = nFirst;
					nFirst = nums[i];
				}
			}
		}
		return (int) (nThird == Double.NEGATIVE_INFINITY ? nFirst : nThird);
	}

	public static void main(String[] args) {
		Solution414 s = new Solution414();
		int[] nums = { 1,2,-2147483648 };
		System.out.println(s.thirdMax(nums));
	}
}
