package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the
 * length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list. Note that beginWord is not
 *    a transformed word.
 * 
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *              return its length 5.
 * 
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class Practise127 {
    public static void main(String[] args) {
        Practise127 p = new Practise127();

        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> wordList2 = Arrays.asList("hot", "dog", "dot", "lot", "log");
        List<String> wordList3 = Arrays.asList("a", "b", "c");

        System.out.println(p.ladderLength("hit", "cog", wordList1));
        System.out.println(p.ladderLength("hit", "cog", wordList2));
        System.out.println(p.ladderLength("a", "c", wordList3));

        List<String> wordList4 = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        System.out.println(p.ladderLength("qa", "sq", wordList4));
    }

    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                List<String> transformations = allComboDict.getOrDefault(pattern, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(pattern, transformations);
            }
        }

        // init
        List<String> queue = Arrays.asList(beginWord);
        int distance = 1;

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            List<String> toVisit = new ArrayList<>();

            // change one letter
            for (String word : queue) {
                for (int i = 0; i < word.length(); i++) {
                    String pattern = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                    for (String adjacentWord : allComboDict.getOrDefault(pattern, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord))
                            return distance + 1;

                        if (!visited.containsKey(adjacentWord)) {
                            toVisit.add(adjacentWord);
                            visited.put(adjacentWord, true);
                        }
                    }
                }
            }

            queue = toVisit;
            distance += 1;
        }

        return 0;
    }
}