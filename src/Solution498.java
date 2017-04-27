
public class Solution498 {
	int[] results;
	int[][] matrix;

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return results;
		}
		this.matrix = matrix;
		results = new int[matrix.length * matrix[0].length];
		results[0] = matrix[0][0];
		getUpperRight(0, 0, 0);
		return results;
	}

	private void getUpperRight(int count, int x, int y) {
		if (isBeyond(x - 1, y + 1)) {
			// check right
			if (isBeyond(x, y + 1)) {
				// check bottom
				if (isBeyond(x + 1, y)) {
					return;
				} else {
					results[count + 1] = matrix[x + 1][y];
					getBottomLeft(count + 1, x + 1, y);
				}
			} else {
				results[count + 1] = matrix[x][y + 1];
				getBottomLeft(count + 1, x, y + 1);
			}
		} else {
			results[count + 1] = matrix[x - 1][y + 1];
			getUpperRight(count + 1, x - 1, y + 1);
		}
	}

	private void getBottomLeft(int count, int x, int y) {
		if (isBeyond(x + 1, y - 1)) {
			// check bot
			if (isBeyond(x + 1, y)) {
				// check right
				if (isBeyond(x, y + 1)) {
					return;
				} else {
					results[count + 1] = matrix[x][y + 1];
					getUpperRight(count + 1, x, y + 1);
				}
			} else {
				results[count + 1] = matrix[x + 1][y];
				getUpperRight(count + 1, x + 1, y);
			}
		} else {
			results[count + 1] = matrix[x + 1][y - 1];
			getBottomLeft(count + 1, x + 1, y - 1);
		}
	}

	private boolean isBeyond(int x, int y) {
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		Solution498 s = new Solution498();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(s.findDiagonalOrder(matrix));
	}
}
