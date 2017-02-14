import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution412 {
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static final String FIZZBUZZ = "FizzBuzz";

	public List<String> fizzBuzz(int n) {
		String[] strArr = new String[n];
		List<String> list = new ArrayList<>();
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = String.valueOf(i+1);
		}
		int nRadio = 1;
		while (nRadio * 3 <= n) {
			strArr[nRadio * 3 - 1] = FIZZ;
			nRadio++;
		}
		nRadio = 1;
		while (nRadio * 5 <= n) {
			strArr[nRadio * 5 - 1] = BUZZ;
			nRadio++;
		}
		nRadio = 1;
		while (nRadio * 15 <= n) {
			strArr[nRadio * 15 - 1] = FIZZBUZZ;
			nRadio++;
		}
		return Arrays.asList(strArr);
	}

	public static void main(String[] args) {
		Solution412 s = new Solution412();
		System.out.println(s.fizzBuzz(15));
	}
}
