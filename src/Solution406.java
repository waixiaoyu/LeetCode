import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution406 {
	List<int[]> listPeople = new LinkedList<int[]>();

	public int[][] reconstructQueue(int[][] people) {
		for (int[] p : people) {
			listPeople.add(new int[] { p[0], p[1], p[1] });
		}
		int[][] nArrAns = new int[people.length][];

		int nIndex = 0;
		while (listPeople.size() > 0) {
			Collections.sort(listPeople, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					if (a[1] == b[1]) {
						return a[0] - b[0];
					}
					return a[1] - b[1];
				}
			});
			nArrAns[nIndex] = new int[] { listPeople.get(0)[0], listPeople.get(0)[2] };
			listPeople.remove(0);
			for (int[] nCurPeople : listPeople) {
				if (nCurPeople[0] <= nArrAns[nIndex][0]) {
					nCurPeople[1] -= 1;
				}
			}
			nIndex++;
		}
		return nArrAns;
	}

	public static void main(String[] args) {
		int[][] nArrarr = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		Solution406 s = new Solution406();
		System.out.println(s.reconstructQueue(nArrarr));
	}
}
