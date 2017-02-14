import java.util.Arrays;
import java.util.List;

public class Solution416 {
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		int volumn = 0;
		Arrays.sort(nums);
		for (int num : nums) {
			volumn += num;
		}
		if (volumn % 2 != 0) {
			return false;
		}
		volumn /= 2;
		boolean[] dp = new boolean[volumn + 1];
		dp[0] = true;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = volumn; j >= nums[i - 1]; j--) {
				dp[j] = dp[j] || dp[j - nums[i - 1]];
			}
		}
		return dp[volumn];
	}

	public static void main(String[] args) {
		Solution416 s = new Solution416();
		int[] nums = { 1, 2, 5 };
		System.out.println(s.canPartition(nums));
	}
}
