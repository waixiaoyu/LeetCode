
public class Solution405 {
	public String toHex(int num) {
		String strResult = "";
		// judge positive or negative
		if (num > 0) {
			while (num > 0) {
				int nRes = num % 16;
				num /= 16;
				strResult = getDigit(nRes) + strResult;
			}
		} else if (num == 0) {
			return "0";
		} else {
			if(num==-2147483648)
			{
				return "80000000";
			}
			num *= -1;
			String strBinary = "";
			while (num > 0) {
				int nRes = num % 2;
				num /= 2;
				strBinary = nRes + strBinary;
			}
			int nBinaryLength = strBinary.length();
			for (int i = 0; i < 32 - nBinaryLength; i++) {
				strBinary = '0' + strBinary;
			}
			// get complement
			char[] cArrComplement = getCompliment(strBinary);
			// up 1 digit
			int nIndex = cArrComplement.length - 1;
			while (nIndex >= 0) {
				if (cArrComplement[nIndex] == '0') {
					cArrComplement[nIndex] = '1';
					break;
				} else {
					cArrComplement[nIndex] = '0';
					nIndex--;
				}
			}
			String strComplement = String.valueOf(cArrComplement);
			for (int i = 0; i < strComplement.length() / 4; i++) {
				strResult += getDigit(binaryToDec(strComplement.substring(i * 4, i * 4 + 4)));
			}
		}
		return strResult;

	}

	public char getDigit(int n) {
		if (n < 10) {
			return (char) (n + 48);
		} else {
			return (char) (n - 10 + 97);
		}
	}

	public char[] getCompliment(String str) {
		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == '0') {
				cArr[i] = '1';
			} else {
				cArr[i] = '0';
			}
		}
		return cArr;
	}

	public int binaryToDec(String str) {
		int nSum = 0;
		int nIndex = 0;
		while (nIndex < str.length()) {
			nSum += (int) ((str.charAt(nIndex) - '0')) * Math.pow(2, 3 - nIndex);
			nIndex++;
		}
		return nSum;
	}

	public static void main(String[] args) {
		Solution405 s = new Solution405();
		System.out.println(s.toHex(-2147483648));
	}
}
