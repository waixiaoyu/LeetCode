import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution417 {
	boolean[][] bP;
	boolean[][] bA;
	boolean[][] bCurrent;
	Queue<int[]> que;
	int nHeight;
	int nWidth;
	int[][] matrix;

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> listResult = new ArrayList<>();
		if (matrix.length == 0) {
			return listResult;
		}
		/***
		 * from left to right, it is Y=width, from top to bottom, it is x=Height
		 */
		this.matrix = matrix;
		nHeight = matrix.length;
		nWidth = matrix[0].length;
		bP = new boolean[nHeight][nWidth];
		bA = new boolean[nHeight][nWidth];

		que = new LinkedList<int[]>();
		// add all pacific to queue
		bCurrent = bP;
		addToQueue(0, 0);
		for (int i = 1; i < nWidth; i++) {
			addToQueue(0, i);
		}
		for (int i = 1; i < nHeight; i++) {
			addToQueue(i, 0);
		}
		while (que.size() > 0) {
			int[] nArrCurrent = que.poll();
			explore(nArrCurrent);
		}
		// add all atlantic to queue
		bCurrent = bA;
		addToQueue(nHeight - 1, nWidth - 1);
		for (int i = 0; i < nWidth - 1; i++) {
			addToQueue(nHeight - 1, i);
		}
		for (int i = 0; i < nHeight - 1; i++) {
			addToQueue(i, nWidth - 1);
		}
		while (que.size() > 0) {
			int[] nArrCurrent = que.poll();
			explore(nArrCurrent);
		}
		for (int i = 0; i < nHeight; i++) {
			for (int j = 0; j < nWidth; j++) {
				if (bP[i][j] && bA[i][j]) {
					int[] nn = { j, i };
					listResult.add(nn);
				}
			}
		}
		return listResult;
	}

	private void addToQueue(int x, int y) {
		int[] nn = { x, y };
		bCurrent[x][y] = true;
		que.add(nn);
	}

	private boolean isBeyond(int x, int y) {
		return x >= 0 && y >= 0 && x < nHeight && y < nWidth ? true : false;
	}

	private void explore(int[] n) {
		int x = n[0];
		int y = n[1];
		int value = matrix[x][y];
		if (isBeyond(x, y - 1)) {
			tagNewPoint(x, y - 1, value);
		}
		if (isBeyond(x, y + 1)) {
			tagNewPoint(x, y + 1, value);
		}
		if (isBeyond(x - 1, y)) {
			tagNewPoint(x - 1, y, value);
		}
		if (isBeyond(x + 1, y)) {
			tagNewPoint(x + 1, y, value);
		}
	}

	private void tagNewPoint(int x, int y, int value) {
		if (matrix[x][y] >= value && bCurrent[x][y] == false) {
			bCurrent[x][y] = true;
			int[] nn = { x, y };
			que.add(nn);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		System.out.println(matrix[0][1]);
		Solution417 s = new Solution417();
		System.out.println(s.pacificAtlantic(matrix));

	}
}
