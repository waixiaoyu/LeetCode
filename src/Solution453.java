import java.util.Arrays;

public class Solution453 {
	public int minMoves(int[] nums) {
		int nSum = 0;
		int nMin = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i < nMin) {
				nMin = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			nSum += (nums[i] - nMin);
		}
		return nSum;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 4 };
		Solution453 s = new Solution453();
		System.out.println(s.minMoves(nums));
	}
}
