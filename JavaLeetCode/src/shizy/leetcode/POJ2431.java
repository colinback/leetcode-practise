package shizy.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * On the road, between the town and the current location of the truck, there are N (1 <= N <= 10,000) fuel stops
 * where the cows can stop to acquire additional fuel (1..100 units at each stop).
 * 
 * The cows want to make the minimum possible number of stops for fuel on the way to the town. Fortunately,
 * the capacity of the fuel tank on their truck is so large that there is effectively no limit to the amount
 * of fuel it can hold. The truck is currently L units away from the town and has P units of fuel (1 <= P <= 1,000,000).
 * 
 * Each tuple for a fuel stop: The first integer is the distance from the town to the stop; the second is the
 * amount of fuel available at that stop
 * 
 * Example:
 *      Given stops = [[4, 4], [5, 2], [11, 5], [15, 10]], town = [25, 10]
 *      Return 2
 */

public class POJ2431 {

    public static void main(String[] args) {
        POJ2431 p = new POJ2431();

        int[][] stops = { { 4, 4 }, { 5, 2 }, { 15, 10 }, { 11, 5 } };
        int[] town = { 25, 10 };

        // int[][] stops = {{4, 5}, {20, 1}};
        // int[] town = {25, 10};
        System.out.println(p.findMinimumStops(stops, town));
    }

    // Greedy
    public int findMinimumStops(int[][] stops, int[] town) {
        int L = town[0];
        int P = town[1];

        // distance to the current location
        for (int[] stop : stops) {
            stop[0] = L - stop[0];
        }

        // ascending order
        Arrays.sort(stops, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        System.out.println(Arrays.deepToString(stops));

        // stop counter
        int counter = 0;
        int idx = 0;
        int maxDistance = 0;

        // max priority queue to keep fuel of passed stops
        Queue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
        // init fule
        queue.offer(P);

        while (!queue.isEmpty()) {
            // max distance when run out of fule
            maxDistance += queue.poll();

            if (maxDistance >= L)
                return counter;

            // add fule of passed stops
            while (idx < stops.length && stops[idx][0] <= maxDistance)
                queue.add(stops[idx++][1]);

            counter++;
        }

        return -1;
    }
}