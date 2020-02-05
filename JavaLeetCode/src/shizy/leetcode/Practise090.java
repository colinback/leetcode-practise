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
		Practise090 p = new Practise090();
		System.out.println(p.subsetsWithDup(new int[] { 1, 2, 2, 2 }));
	}

	// Backtracing
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		Arrays.sort(nums);
		backtrace(nums, 0, results, new ArrayList<Integer>());
		return results;
	}

	private void backtrace(int[] nums, int start, List<List<Integer>> results, List<Integer> list) {
		results.add(new ArrayList<Integer>(list));

		int i = start;
		while (i < nums.length) {
			list.add(nums[i]);

			// use next integer
			backtrace(nums, i + 1,  results, list);

			list.remove(list.size() - 1);
			i++;

			while (i < nums.length && nums[i] == nums[i - 1])
				i++;
		}
	}

	// Recursive
	/*
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> outputs = new ArrayList<>();
		outputs.add(new ArrayList<Integer>());

		Arrays.sort(nums);
		
		int start = 0;
		// loop all numbers
		for (int i = 0; i < nums.length; i++) {		
			List<List<Integer>> subsets = new ArrayList<>();
			int num = nums[i];

			start = (i > 0 && nums[i] == nums[i - 1]) ? start : 0;

			// add nums[i] to existing output list
			for(int j = start; j < outputs.size(); j++) {
				List<Integer> l = outputs.get(j);
				subsets.add(new ArrayList<Integer>(l) {{
					add(num);
				}});
			}

			// remember start point if nums[i] == nums[i - 1]
			start = outputs.size();

			for(List<Integer> l : subsets) {
				outputs.add(l);
			}
		}

		return outputs;
	}
	*/
}
