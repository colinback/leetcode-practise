package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 * 	[3],
 * 	[1],
 * 	[2],
 * 	[1,2,3],
 * 	[1,3],
 * 	[2,3],
 * 	[1,2],
 * 	[]
]
 */
public class Practise078 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise078 p = new Practise078();
		System.out.println(p.subsets(new int[] {1,3,2}));
	}

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        results.add(new ArrayList<Integer>());
//        
//        for(int i = 0; i < nums.length; i++) {
//        		List<List<Integer>> tmp = new ArrayList<>();
//        		for(List<Integer> list: results) {
//        			List<Integer> nl = new ArrayList<Integer>(list);
//        			nl.add(nums[i]);
//        			tmp.add(nl);
//        		}
//        		results.addAll(tmp);
//        }
//        
//        return results;
//    }
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		backtrace(nums, results, new ArrayList<Integer>(), 0);
		return results;
	}
	
	private void backtrace(int[] nums, List<List<Integer>> results, List<Integer> list, int start) {
		results.add(new ArrayList<Integer>(list));
		
		for(int i = start; i < nums.length; i++) {
			// pick number at index i
			list.add(nums[i]);
			
			backtrace(nums, results, list, i + 1);
			
			// trace back to skip number at index i
			list.remove(list.size() - 1);
		}
	}
}
