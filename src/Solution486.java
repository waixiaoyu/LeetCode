
public class Solution486 {
	public boolean PredictTheWinner(int[] nums) {
		if (nums.length <= 1) {
			return true;
		}
		return player1(nums, 0, nums.length - 1, 0, 0);
	}

	private boolean player1(int[] nums, int start, int end, int total1, int total2) {
		if (start > end) {
			return total1 >= total2 ? true : false;
		}

		return player2(nums, start + 1, end, total1 + nums[start], total2)
				|| player2(nums, start, end - 1, total1 + nums[end], total2);

	}

	private boolean player2(int[] nums, int start, int end, int total1, int total2) {
		if (start > end) {
			return total1 >= total2 ? true : false;
		}
		return player1(nums, start + 1, end, total1, total2 + nums[start])
				&& player1(nums, start, end - 1, total1, total2 + nums[end]);

	}

	public static void main(String[] args) {
		Solution486 s = new Solution486();
		int[] ns = { 1, 5, 233, 7 };
		System.out.println(s.PredictTheWinner(ns));
	}
}
