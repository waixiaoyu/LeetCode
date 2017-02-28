public class Solution434 {
	public int countSegments(String s) {
		char[] cArr = s.trim().toCharArray();
		char cLast = ' ';
		int nCount = 0;
		for (char c : cArr) {
			if (c != cLast && cLast == ' ') {
				nCount++;
			}
			cLast = c;
		}
		return nCount;
	}

	public static void main(String[] args) {
		Solution434 s = new Solution434();
		System.out.println(s.countSegments("Hello,        my  name  is  John"));
	}
}
