package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of candidate numbers (C) and a 
 * target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * [
 * 	[1, 7],
 * 	[1, 2, 5],
 * 	[2, 6],
 * 	[1, 1, 6]
 * ]
 */
public class Practise040 {

	public static void main(String[] args) {
		Practise040 p = new Practise040();
		System.out.println(p.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
	}
		
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> outputs = new ArrayList<>();
		
		Arrays.sort(candidates);
		backtrace(candidates, 0, outputs, new ArrayList<>(), 0, target);

		return outputs;
	}
	
	private void backtrace(int[] candidates, int start, List<List<Integer>> ret, List<Integer> list, int sum, int target) {
		if(sum == target) {
			ret.add(new ArrayList<>(list));
		}

		for(int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);

			// use next integer
			backtrace(candidates, i + 1, ret, list, sum + candidates[i], target);

			// back trace and move to next
			list.remove(list.size() - 1);

			// skip dumplicate
			while (i > 0 && candidates[i] == candidates[i - 1])
				i++;
		}
	}
}
