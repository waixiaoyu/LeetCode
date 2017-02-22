import java.util.Stack;

public class Solution394 {
	public String decodeString(String s) {
		Stack<Integer> staNumbers = new Stack<>();
		Stack<String> staMarks = new Stack<>();
		char[] cArr = s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			if (c >= '0' && c <= '9') {
				// if the number is like 10000, which is more than 1 digit
				StringBuilder sbNumber = new StringBuilder();
				while (i < cArr.length && cArr[i] >= '0' && cArr[i] <= '9') {
					sbNumber.append(cArr[i]);
					i++;
				}
				i--;
				staNumbers.push(Integer.parseInt(sbNumber.toString()));
			} else if (c == '[') {
				staMarks.push("[");
			} else if (c == ']') {
				StringBuilder sbNew = new StringBuilder();
				while (true) {
					StringBuilder sb = new StringBuilder(staMarks.pop());
					if (sb.toString().equals("[")) {
						break;
					} else {
						sbNew.insert(0, sb);
					}
				}
				int nLoopTime = staNumbers.pop();
				StringBuilder sbNewNew = new StringBuilder();
				for (int j = 0; j < nLoopTime; j++) {
					sbNewNew.append(sbNew);
				}
				staMarks.push(sbNewNew.toString());
			} else {
				StringBuilder sb = new StringBuilder();
				while (i < cArr.length && cArr[i] >= 'a' && cArr[i] <= 'z') {
					sb.append(cArr[i]);
					i++;
				}
				staMarks.add(sb.toString());
				i--;
			}
		}
		// get all string in staMarks
		StringBuilder sb = new StringBuilder();
		while (!staMarks.isEmpty()) {
			sb.insert(0, staMarks.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution394 s = new Solution394();
		System.out.println(s.decodeString("sd2[f2[e]g]i"));
	}
}
