package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 *  * 
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
 */
public class Practise037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise037 p = new Practise037();
		
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
				
		p.solveSudoku(sudoku);
		System.out.println(Arrays.deepToString(sudoku));
	}
	
	public void solveSudoku(char[][] board) {
		int len = board.length;
		
		// 每个位置可选数字
		List<Integer>[][] candidates = candidateNumbers(board);
		// System.out.println(Arrays.deepToString(candidates));
		
		// 按个数排序
		List<Integer> sortedPosition = sortCandidateNumbers(candidates, len);
		// System.out.println(sortedPosition.toString());
		
		int index = 0;
				
		while(index < sortedPosition.size()) {
			if (index < 0)
				return;

			int pos = sortedPosition.get(index);
			int i = pos / len;
			int j = pos % len;
			
			if(candidates[i][j].isEmpty()) {
				// 回溯
				board[i][j] = '.';
				index--;
			} else {
				int num = candidates[i][j].remove(0);
				board[i][j] = Integer.toString(num).charAt(0);
				// System.out.println(Arrays.deepToString(board));
				
				// 更新候选数字
				if (updateCandidates(board, candidates, sortedPosition, index)) {
					// 前进
					index++;
				}
			}
		}
    }
	
	private boolean updateCandidates(char[][] board,
			List<Integer>[][] candidates, List<Integer> sortedPosition, int idx) {
		int len = board.length;
		
		for(int index = idx + 1; index < sortedPosition.size(); index++) {
			int pos = sortedPosition.get(index);
			int i = pos / len;
			int j = pos % len;
			
			boolean[] occupy = new boolean[len + 1];
			// 行检查
			for(int k  = 0; k < len ; k++) {
				if (board[i][k] != '.') {
					int num = Character.getNumericValue(board[i][k]);
					occupy[num] = true;
				}
			}
			// 列检查
			for(int k  = 0; k < len ; k++) {
				if (board[k][j] != '.') {
					int num = Character.getNumericValue(board[k][j]);
					occupy[num] = true;
				}
			}
			// 3*3检查
			int x = i/3, y = j/3;
			for(int m = 0; m < 3; m++) {
				for(int n = 0; n < 3; n++) {
					if (board[x * 3 + m][y * 3 + n] != '.') {
						int num = Character.getNumericValue(board[x * 3 + m][y * 3 + n]);
						occupy[num] = true;
					}
				}
			}
			
			List<Integer> list = new ArrayList<Integer>();
			for(int k = 1; k <= len; k++) {
				if (occupy[k] != true)
					list.add(k);
			}
			
			if(list.isEmpty())
				return false;
			
			candidates[i][j] = list;
		}
		
		return true;
	}
	
	private List<Integer>[][] candidateNumbers(char[][] board) {
		int len = board.length;
		List<Integer>[][] candidates= new List[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if (board[i][j] == '.') {
					boolean[] occupy = new boolean[len + 1];
					// 行检查
					for(int k  = 0; k < len ; k++) {
						if (board[i][k] != '.') {
							int num = Character.getNumericValue(board[i][k]);
							occupy[num] = true;
						}
					}
					// 列检查
					for(int k  = 0; k < len ; k++) {
						if (board[k][j] != '.') {
							int num = Character.getNumericValue(board[k][j]);
							occupy[num] = true;
						}
					}
					// 3*3检查
					int x = i/3, y = j/3;
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {
							if (board[x * 3 + m][y * 3 + n] != '.') {
								int num = Character.getNumericValue(board[x * 3 + m][y * 3 + n]);
								occupy[num] = true;
							}
						}
					}
					
					List<Integer> list = new ArrayList<Integer>();
					for(int k = 1; k <= len; k++) {
						if (occupy[k] != true)
							list.add(k);
					}
					
					candidates[i][j] = list;
				}
			}
		}
		return candidates;
	}
	
	private List<Integer> sortCandidateNumbers(List<Integer>[][] candidates, int len) {
		List<Integer> sortedPos = new ArrayList<>();
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if (candidates[i][j] != null) {
					int count = candidates[i][j].size();
					int idx = 0;
					
					while(idx < sortedPos.size()) {
						int pos = sortedPos.get(idx);
						if (candidates[pos/len][pos%len].size() <= count)
							idx++;
						else break;
					}
					
					sortedPos.add(idx, i * len + j);
				}
			}
		}
		
		return sortedPos;
	}
}
