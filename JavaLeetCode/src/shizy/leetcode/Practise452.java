package shizy.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * There are a number of spherical balloons spread in two-dimensional space. 
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end 
 * of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the x-axis. 
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. 
 * There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. 
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * 
 * Example:
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * 
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) 
 * and another arrow at x = 11 (bursting the other two balloons).
 */

public class Practise452 {

	public static void main(String[] args) {
		Practise452 p = new Practise452();
		System.out.println(p.findMinArrowShots(
				new int[][] { new int[] { 10, 16 }, new int[] { 2, 8 }, new int[] { 1, 6 }, new int[] { 7, 12 } }));

		System.out.println(p.findMinArrowShots(new int[][] { new int[] { 3, 9 }, new int[] { 7, 12 },
				new int[] { 3, 8 }, new int[] { 6, 8 }, new int[] { 9, 10 }, new int[] { 2, 9 }, new int[] { 0, 9 },
				new int[] { 3, 9 }, new int[] { 0, 6 }, new int[] { 2, 8 } }));

		System.out.println(
				p.findMinArrowShots(new int[][] { new int[] { 9, 12 }, new int[] { 1, 10 }, new int[] { 4, 11 },
						new int[] { 8, 12 }, new int[] { 3, 9 }, new int[] { 6, 9 }, new int[] { 6, 7 } }));

		System.out.println(p.findMinArrowShots(new int[][] { new int[] { -2147483648, 2147483647 } }));

		System.out.println(p.findMinArrowShots(
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 4, 5 }, }));
	}

	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}

		// Arrays.sort(points, new Comparator<int[]>() {
		// 	@Override
		// 	public int compare(int[] a, int[] b) {
		// 		return a[0] - b[0];
		// 	}
		// });
		Arrays.sort(points, (a, b) -> a[0] - b[0]);

		// System.out.println(Arrays.deepToString(points));

		int count = 1;
		int arrow = points[0][1];

		for (int i = 1; i < points.length; i++) {
			int[] balloon = points[i];

			// System.out.println("balloon[0]: " + balloon[0]);
			// System.out.println("arrow: " + arrow);
			if (balloon[0] <= arrow) {
				arrow = Math.min(arrow, balloon[1]);
			} else {
				count++;
				arrow = balloon[1];
			}
		}

		return count;
	}

	// sort by points[][1], then set arrow at position points[][1]
	/*
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, (a, b) -> a[1] - b[1]);
		int arrowPos = points[0][1];
		int arrowCnt = 1;
		for (int i = 1; i < points.length; i++) {
			if (arrowPos >= points[i][0]) {
				continue;
			}
			arrowCnt++;
			arrowPos = points[i][1];
		}
		return arrowCnt;
	}
	*/
}
