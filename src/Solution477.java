
public class Solution477 {
	public int totalHammingDistance(int[] nums) {
		char[][] cNums = new char[nums.length][32];
		int nTotal = 0;
		// init chars
		for (int i = 0; i < cNums.length; i++) {
			for (int j = 0; j < 32; j++) {
				cNums[i][j] = '0';
			}
		}
		// int to char
		for (int i = 0; i < nums.length; i++) {
			char[] c = Integer.toBinaryString(nums[i]).toCharArray();
			for (int j = 0; j < c.length; j++) {
				cNums[i][32 - j - 1] = c[c.length - j - 1];
			}
		}

		for (int i = 0; i < 32; i++) {
			int nCount0 = 0;
			for (int j = 0; j < cNums.length; j++) {
				if (cNums[j][i] == '0') {
					nCount0++;
				}
			}
			nTotal += nCount0 * (nums.length - nCount0);
		}
		return nTotal;
	}

	public static void main(String[] args) {
		Solution477 s = new Solution477();
		int[] nums = { 4, 14, 2 };
		System.out.println(s.totalHammingDistance(nums));
	}
}
