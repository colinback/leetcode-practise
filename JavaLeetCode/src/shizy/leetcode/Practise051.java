package shizy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * 	[".Q..",  // Solution 1
 * 	"...Q",
 * 	"Q...",
 * 	"..Q."],
 * 
 * 	["..Q.",  // Solution 2
 * 	"Q...",
 * 	"...Q",
 * 	".Q.."]
 * ]
 */

public class Practise051 {

	public static void main(String[] args) {
		Practise051 p = new Practise051();
		System.out.println(p.solveNQueens(4));
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> outputs = new ArrayList<>();
		traceback(n, 0, outputs, new ArrayList<String>(), new boolean[n][n]);
		return outputs;
	}

	private void traceback(int n, int index, List<List<String>> res, List<String> solution, boolean[][] pos) {
		if (index == n) {
			res.add(new ArrayList<String>(solution));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (validate(pos, i, index)) {
				pos[i][index] = true;
				solution.add(String.join("", Collections.nCopies(i, ".")) + "Q"
						+ String.join("", Collections.nCopies(n - i - 1, ".")));
				
				// try next column
				traceback(n, index + 1, res, solution, pos);

				solution.remove(solution.size() - 1);
				pos[i][index] = false;
			}
		}
	}

	private boolean validate(boolean[][] pos, int x, int y) {
		for (int i = 0; i < pos.length; i++) {
			for (int j = 0; j < y; j++) {
				if (pos[i][j] == true && (x + j == y + i || x + y == i + j || x == i))
					return false;
			}
		}
		return true;
	}
}
