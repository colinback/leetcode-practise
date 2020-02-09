package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/*
 * Given a string of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators. The valid operators
 * are +, - and *.
 * 
 * Example:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 *  ((2-1)-1) = 0
 *  (2-(1-1)) = 2
 * 
 * Example:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 *  (2*(3-(4*5))) = -34 
 *  ((2*3)-(4*5)) = -14
 *  ((2*(3-4))*5) = -10
 *  (2*((3-4)*5)) = -10
 *  (((2*3)-4)*5) = 10
 */

class Practise241 {
    public static void main(String[] args) {
        Practise241 p = new Practise241();

        System.out.println(p.diffWaysToCompute("2-1-1"));
        System.out.println(p.diffWaysToCompute("2*3-4*5"));
        System.out.println(p.diffWaysToCompute("11"));
    }

    // Divide & Conquer
    public List<Integer> diffWaysToCompute(String input) {
        // memorized results
        Map<String, List<Integer>> map = new HashMap<>();

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                String lstr = input.substring(0, i);
                String rstr = input.substring(i + 1);

                List<Integer> lList = map.getOrDefault(lstr, diffWaysToCompute(lstr));
                List<Integer> rList = map.getOrDefault(rstr, diffWaysToCompute(rstr));

                for (Integer p1 : lList) {
                    for (Integer p2 : rList) {
                        int res = 0;
                        switch (ch) {
                        case '+':
                            res = p1 + p2;
                            break;
                        case '-':
                            res = p1 - p2;
                            break;
                        case '*':
                            res = p1 * p2;
                            break;
                        }
                        output.add(res);
                    }
                }
            }
        }

        if (output.size() == 0)
            output.add(Integer.valueOf(input));

        map.put(input, output);
        return output;
    }
}