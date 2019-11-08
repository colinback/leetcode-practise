package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) (without duplicates) and 
 * a target number (T), find all unique combinations in C where 
 * the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 * 	[7],
 * [2, 2, 3]
 * ]
 */
public class Practise039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise039 p = new Practise039();
  		
  		System.out.println(p.combinationSum(new int[] {2, 3, 6, 7}, 7));
  		System.out.println(p.combinationSum(new int[] {8, 7, 4, 3}, 11));
	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    		List<List<Integer>> ret = new ArrayList<List<Integer>>();
    		List<Integer> list = new ArrayList<Integer>();
    		
      	Arrays.sort(candidates);
      		
    		combinationSum(ret, candidates, list, target, 0);
    		return ret;
    }
    
    private void combinationSum(List<List<Integer>> ret, int[] candidates, List<Integer> list, int target, int sum) {
    		if (sum > target)
    			return;
    		
    		for(int i = 0; i < candidates.length; i++) {
    			int candidate = candidates[i];
    			
    			List<Integer> newList = new ArrayList<Integer>(list);
    			newList.add(candidate);
    			
    			if (sum + candidate == target) {
    				ret.add(newList);
    				continue;
    			} else {
    				int[] newCandidates = Arrays.copyOfRange(candidates, i, candidates.length);
    				combinationSum(ret, newCandidates, newList, target, sum + candidate);
    			}
    		}
    }
}
