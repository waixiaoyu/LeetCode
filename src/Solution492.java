
public class Solution492 {
	public int[] constructRectangle(int area) {
		int n = (int) Math.sqrt(area);
		while (area % n != 0) {
			n--;
		}
		int[] result = { area / n, n };
		return result;
	}

	public static void main(String[] args) {
		Solution492 s = new Solution492();
		System.out.println(s.constructRectangle(4)[0]);
	}
}
