public class Solution419 {
	public int countBattleships(char[][] board) {
		if (board == null) {
			return 0;
		}
		int nTotal = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					boolean bI = i == 0 ? true : false;
					boolean bJ = j == 0 ? true : false;
					if (!bI) {
						bI = board[i - 1][j] == '.' ? true : false;
					}
					if (!bJ) {
						bJ = board[i][j - 1] == '.' ? true : false;
					}
					if (bI && bJ) {
						nTotal++;
					}
				}
			}
		}
		return nTotal;
	}

	public static void main(String[] args) {
		//char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		 char[][] board = { { '.', '.' }, { 'X', 'X' } };
		Solution419 s = new Solution419();
		System.out.println(s.countBattleships(board));
	}
}
