package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of integers that might contain duplicates, nums, 
 * return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 * 	[2],
 * 	[1],
 * 	[1,2,2],
 * 	[2,2],
 * 	[1,2],
 * 	[]
]
 */
public class Practise090 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise090 p = new Practise090();
		System.out.println(p.subsetsWithDup(new int[] { 1, 2, 2 }));
	}

//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//		List<List<Integer>> results = new ArrayList<>();
//
//		Arrays.sort(nums);
//		traceback(nums, results, new ArrayList<Integer>(), 0);
//		return results;
//	}
//
//	private void traceback(int[] nums, List<List<Integer>> results, List<Integer> list, int start) {
//		results.add(new ArrayList<Integer>(list));
//
//		int i = start;
//		while (i < nums.length) {
//			list.add(nums[i]);
//
//			traceback(nums, results, list, i + 1);
//			list.remove(list.size() - 1);
//			i++;
//
//			while (i < nums.length && nums[i] == nums[i - 1])
//				i++;
//		}
//	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		results.add(new ArrayList<Integer>());

		Arrays.sort(nums);
		
		int size = 0, start = 0;
		for (int i = 0; i < nums.length; i++) {

			start = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
			size = results.size();
			for (int j = start; j < size; j++) {
				List<Integer> nl = new ArrayList<Integer>(results.get(j));
				nl.add(nums[i]);
				results.add(nl);
			}
		}

		return results;
	}
}
