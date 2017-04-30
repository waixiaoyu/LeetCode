import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
	public int[] nextGreaterElements(int[] nums) {
		// init results
		int[] results = new int[nums.length];
		Arrays.fill(results, -1);
		int nLength = nums.length;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < results.length; i++) {
			if (!stack.isEmpty() && stack.peek() < nums[i]) {
				results[i] = stack.pop();
			} else {
				stack.push(i);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 1 };
		Solution503 s = new Solution503();
		System.out.println(s.nextGreaterElements(input));
	}
}
