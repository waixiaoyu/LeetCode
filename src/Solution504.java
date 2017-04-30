import java.util.Stack;

public class Solution504 {
	public String convertToBase7(int num) {
		if (num == 0) {
			return "0";
		}
		boolean isNegative = false;
		if (num < 0) {
			isNegative = true;
			num *= -1;
		}
		Stack<Character> stack = new Stack<>();
		while (num > 0) {
			int nDigit = num % 7;
			stack.push((char) ('0' + nDigit));
			num /= 7;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return isNegative ? "-" + sb.toString() : sb.toString();
	}

	public static void main(String[] args) {
		Solution504 s = new Solution504();
		System.out.println(s.convertToBase7(0));
	}
}
