import java.util.LinkedList;
import java.util.List;

public class Solution400 {
	public int findNthDigit(int n) {
		int nDigitNum = 1;
		double dThrehold = 9 * Math.pow(10, nDigitNum - 1)*nDigitNum;
		while (n > dThrehold) {
			n -= dThrehold;
			nDigitNum++;
			dThrehold = 9 * Math.pow(10, nDigitNum - 1)*nDigitNum;
		}
		int nQuient = n / nDigitNum;
		int nResidual = n % nDigitNum;
		int nCurrent = (int) (Math.pow(10, nDigitNum-1) + nQuient);
		if (nResidual == 0) {
			return (nCurrent - 1) % 10;
		} else {
			List<Integer> list = new LinkedList<Integer>();
			while (nCurrent > 0) {
				list.add(0,nCurrent % 10);
				nCurrent /= 10;
			}
			return list.get(nResidual - 1);
		}
	}

	public static void main(String[] args) {
		Solution400 s = new Solution400();
		System.out.println(s.findNthDigit(100));
	}
}
