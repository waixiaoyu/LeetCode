
public class Solution476 {
	public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);

	}

	public static void main(String[] args) {
		Solution476 s = new Solution476();

		System.out.println(s.findComplement(5));
	}
}
