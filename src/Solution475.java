import java.util.Arrays;

public class Solution475 {

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int radius = Integer.MIN_VALUE;
		for (int i = 0, j = 0; i < houses.length;) {
			if (j == heaters.length) {
				// now the last heaters is greater than last houses
				radius = Math.max(radius, houses[i] - heaters[j - 1]);
				i++;
			} else if (houses[i] <heaters[j]) {
				// now the first house is smaller than first heaters
				radius = Math.max(radius, heaters[j] - houses[i]);
				while (houses[i] < heaters[j]) {
					i++;
				}
			} else if (j == heaters.length - 1) {
				// now the last house is greater than last heater
				radius = Math.max(radius, houses[houses.length - 1] - heaters[j]);
				break;
			} else if (houses[i] >= heaters[j + 1]) {
				j++;
			} else {
				int diff = Math.min(houses[i] - heaters[j], heaters[j + 1] - houses[i]);
				radius = Math.max(radius, diff);
				i++;
			}
		}
		return radius;
	}

	public static void main(String[] args) {
		Solution475 s = new Solution475();
		int[] input1 = { 1, 2, 3, 4 };
		int[] input2 = { 1, 4 };
		System.out.println(s.findRadius(input1, input2));
	}
}
