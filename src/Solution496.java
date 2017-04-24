
public class Solution496 {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		int nSubsetLength = findNums.length;
		int nTotalLength = nums.length;

		int[] results = new int[nSubsetLength];
		for (int i = 0; i < nSubsetLength; i++) {
			int nIndex = 0;
			while (nIndex < nTotalLength) {
				if (nums[nIndex] == findNums[i]) {
					break;
				} else {
					nIndex++;
				}
			}
			while (nIndex < nTotalLength) {
				if (findNums[i] < nums[nIndex]) {
					results[i] = nums[nIndex];
					break;
				} else {
					nIndex++;
				}
			}
			results[i] = results[i] == 0 ? -1 : results[i];
		}
		return results;
	}

	public static void main(String[] args) {
		int[] findNums = { 4, 1, 2 };
		int[] nums = { 1, 3, 4, 2 };
		Solution496 s = new Solution496();
		System.out.println(s.nextGreaterElement(findNums, nums));
	}
}
