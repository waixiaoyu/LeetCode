import java.util.LinkedList;
import java.util.Queue;

public class Solution463 {
	int[][] grid;
	boolean[][] isExpl;
	Queue<int[]> queue;

	public int islandPerimeter(int[][] grid) {
		this.grid = grid;
		isExpl = new boolean[grid.length][grid[0].length];
		int nPerimeter = 0;
		queue = new LinkedList<>();
		// init queue, find the first grid of island
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				isExpl[i][j] = true;
				if (grid[i][j] == 1) {
					queue.add(new int[] { i, j });
					break;
				}
			}
		}
		// start bfs
		while (queue.size() > 0) {
			int[] nnCur = queue.poll();
			int x = nnCur[0];
			int y = nnCur[1];
			int nSurrWater = 4;
			if (!isWater(x + 1, y)) {
				addPoint(x + 1, y);
				nSurrWater--;
			}
			if (!isWater(x - 1, y)) {
				addPoint(x - 1, y);
				nSurrWater--;
			}
			if (!isWater(x, y + 1)) {
				addPoint(x, y + 1);
				nSurrWater--;
			}
			if (!isWater(x, y - 1)) {
				addPoint(x, y - 1);
				nSurrWater--;
			}
			nPerimeter += nSurrWater;
		}

		return nPerimeter;

	}

	private boolean isWater(int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void addPoint(int x, int y) {
		if (!isExpl[x][y]) {
			queue.add(new int[] { x, y });
			isExpl[x][y] = true;
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		Solution463 s = new Solution463();
		System.out.println(s.islandPerimeter(grid));
	}
}
