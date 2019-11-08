package shizy.leetcode;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are 
 * filled with the character '.'.
 * 
 * 
 *   | 5 | 3 |   |   | 7 |   |   |   |   |  
 *   | 6 |   |   | 1 | 9 | 5 |   |   |   |
 *   |   | 9 | 8 |   |   |   |   | 6 |   |
 *   | 8 |   |   |   | 6 |   |   |   |   |
 *   | 4 |   |   | 8 |   | 3 |   |   | 1 |
 *   | 7 |   |   |   | 2 |   |   |   | 6 |
 *   |   | 6 |   |   |   |   | 2 | 8 |   |
 *   |   |   |   | 4 | 1 | 9 |   |   | 5 |
 *   |   |   |   |   | 8 |   |   | 7 | 9 |
 * 
 * A partially filled sudoku which is valid.
 */
public class Practise036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise036 p = new Practise036();
		
		char[][] sudoku = new char[][] {
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '.'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		
		System.out.println(p.isValidSudoku(sudoku));
	}

	public boolean isValidSudoku(char[][] board) {
		int row = board.length;
		int column = board[0].length;
		
        // 行没有重复
		for(int i = 0; i < row; i++) {
			boolean[] occupy = new boolean[10];
			for(int j = 0; j < column; j++) {
				if (board[i][j] != '.') {
					int num = Character.getNumericValue(board[i][j]);
					if (occupy[num] == true)
						return false;
					else occupy[num] = true;
				}
			}
		}
		
		// 列没有重复
		for(int i = 0; i < column; i++) {
			boolean[] occupy = new boolean[10];
			for(int j = 0; j < row; j++) {
				if (board[j][i] != '.') {
					int num = Character.getNumericValue(board[j][i]);
					if (occupy[num] == true)
						return false;
					else occupy[num] = true;
				}
			}
		}
		
		// 3*3方块内没有重复
		for(int i = 0; i < row/3; i++) 
			for(int j = 0; j < column/3; j++) {
				boolean[] occupy = new boolean[10];
				for(int m = 0; m < 3; m++)
					for(int n = 0; n < 3; n++) {
						if (board[i*3 + m][j*3 + n] != '.') {
							int num = Character.getNumericValue(board[i*3 + m][j*3 + n]);
							if (occupy[num] == true)
								return false;
							else occupy[num] = true;
						}
					}
			}
		
		return true;
    }
}
