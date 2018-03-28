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
		// TODO Auto-generated method stub
		Practise040 p = new Practise040();
		System.out.println(p.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
	}
	
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//    		List<List<Integer>> ret = new ArrayList<List<Integer>>();
//    		List<Integer> list = new ArrayList<Integer>();
//    		
//    		// 排序
//    		Arrays.sort(candidates);
//    		
//    		combinationSum2(ret, candidates, list, target, 0);
//        return ret;
//    }
//
//    private void combinationSum2(List<List<Integer>> ret, int[] candidates,  
//    		List<Integer> list, int target, int sum) {
//    		if (sum > target)
//    			return;
//    		
//    		for(int i = 0; i < candidates.length; i++) {
//    			if (i > 0 && candidates[i] == candidates[i-1])
//    				continue;
//    			
//    			int candidate = candidates[i];
//
//			List<Integer> newList = new ArrayList<Integer>(list);
//    			newList.add(candidate);
//    			
//    			if (sum + candidate == target) {
//    				ret.add(newList);
//    				continue;
//    			} else {
//    				int[] newCandidates = Arrays.copyOfRange(candidates, i + 1, candidates.length);				
//    				combinationSum2(ret, newCandidates, newList, target, sum + candidate);
//    			}
//		}
//    }
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<>();
		
		traceback(candidates, ret, new ArrayList<Integer>(), 0 , 0, target);
		
		return ret;
    }

    private void traceback(int[] candidates, List<List<Integer>> ret, List<Integer> list, int index, int sum, int target) {
		if (sum == target) {
			ret.add(new ArrayList<>(list));
			return;
		}
		
		if (index >= candidates.length) return;
		
		int i = index;
		while(i < candidates.length) {
			list.add(candidates[i]);
			traceback(candidates, ret, list, i+1 , sum + candidates[i], target);
			list.remove(list.size() - 1);
			i++;
			
			while(i < candidates.length && candidates[i] == candidates[i-1]) 
				i++;
		}
    }
}
