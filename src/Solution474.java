
public class Solution474 {
	int[][] nArrStr01;

	public int findMaxForm(String[] strs, int m, int n) {
		nArrStr01 = new int[strs.length][2];
		for (int i = 0; i < strs.length; i++) {
			countString(strs[i], i);
		}

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < strs.length; i++) {
			for (int j = m; j >= nArrStr01[i][0]; j--) {
				for (int j2 = n; j2 >=nArrStr01[i][1]; j2--) {
					dp[j][j2] = Math.max(dp[j][j2], dp[j - nArrStr01[i][0]][j2 - nArrStr01[i][1]] + 1);
				}
			}

		}
		return dp[m][n];
	}

	private void countString(String str, int index) {
		int nCount0 = 0;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '0') {
				nCount0++;
			}
		}
		nArrStr01[index][0] = nCount0;
		nArrStr01[index][1] = str.length() - nCount0;
	}

	public static void main(String[] args) {
		Solution474 s = new Solution474();
		String[] strs = { "10", "0001", "111001", "1", "0" };
		System.out.println(s.findMaxForm(strs, 5, 3));
	}
}
