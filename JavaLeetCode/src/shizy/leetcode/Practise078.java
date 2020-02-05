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
		Practise078 p = new Practise078();
		System.out.println(p.subsets(new int[] {1,3,2}));
	}
	
	// Backtracing
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> outputs = new ArrayList<>();
		backtrace(nums, 0, outputs, new ArrayList<Integer>());
		return outputs;
	}
	
	private void backtrace(int[] nums, int start, List<List<Integer>> lists, List<Integer> list) {
		// clone list and add to lists
		lists.add(new ArrayList<Integer>(list));
		
		for(int i = start; i < nums.length; i++) {
			// pick number at index i
			list.add(nums[i]);
			
			// use next integers to complete combination
			backtrace(nums, i+1, lists, list);
			
			// trace back to skip number at index i
			list.remove(list.size() - 1);
		}
	}

	// Recursive
	/* implementation 1
	public List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<>(Arrays.asList(new ArrayList<Integer>()));
		}

		List<List<Integer>> results = new ArrayList<>();

		for(List<Integer> l: subsets(Arrays.copyOf(nums, nums.length - 1))) {
			results.add(l);

			results.add(new ArrayList<Integer>(l) {{
				add(nums[nums.length - 1]);
			}});
		}

		return results;
	}
	*/

	/* implementation 2
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		output.add(new ArrayList<Integer>());

		for(int num: nums) {
			List<List<Integer>> newSubsets = new ArrayList<>();
			for (List<Integer> curr: output) {
				newSubsets.add(new ArrayList<Integer>(curr) {{
					add(num);
				}});
			}

			for (List<Integer> curr: newSubsets) {
				output.add(curr);
			}
		}

		return output;
	}
	*/
}
