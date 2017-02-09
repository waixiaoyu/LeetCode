import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution398 {

	int[] nums;
	List<Integer> listNums;
	int nLast = Integer.MIN_VALUE;

	public Solution398(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {
		if (nLast == Integer.MIN_VALUE || nLast != target) {
			nLast = target;
			listNums = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == target) {
					listNums.add(i);
				}
			}
		}
		Random r = new Random();
		return listNums.get(r.nextInt(listNums.size()));
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 3, 3 };
		Solution398 s = new Solution398(nums);
		System.out.println(s.pick(3));
	}
}
