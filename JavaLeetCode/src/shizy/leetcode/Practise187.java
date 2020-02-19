package shizy.leetcode;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 * repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */

public class Practise187 {
    public static void main(String[] args) {
        Practise187 p  = new Practise187();

        System.out.println(p.findRepeatedDnaSequences(""));
        System.out.println(p.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        List<String> output = new ArrayList<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String substr = s.substring(i, i + 10);
            map.put(substr, map.getOrDefault(substr, 0) + 1);
        }

        for(Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1)
                output.add(e.getKey());
        }

        return output;
    }
}