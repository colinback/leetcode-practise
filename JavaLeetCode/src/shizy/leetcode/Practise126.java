package shizy.leetcode;

import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/* 
 * Given two words (beginWord and endWord), and a dictionary's word list, find all
 * shortest transformation sequence(s) from beginWord to endWord, such that:
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class Practise126 {
    public static void main(String[] args) {
        Practise126 p = new Practise126();

        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> wordList2 = Arrays.asList("hot", "dog", "dot", "lot", "log");
        List<String> wordList3 = Arrays.asList("a", "b", "c");

        System.out.println(p.findLadders("hit", "cog", wordList1));
        System.out.println(p.findLadders("hit", "cog", wordList2));
        System.out.println(p.findLadders("a", "c", wordList3));

        List<String> wordList4 = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        // System.out.println(p.findLadders("qa", "sq", wordList4));

        List<String> wordList5 = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
        System.out.println(p.findLadders("red", "tax", wordList5));
    }

    // DFS (Time Limit Exceeded)
    /*
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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

        // all shortest transformation sequence
        List<List<String>> outputs = new ArrayList<>();

        // init word
        List<String> output = new ArrayList<>();
        output.add(beginWord);

        backtrace(beginWord, endWord, allComboDict, output, outputs);

        return outputs;
    }

    private void backtrace(String beginWord, String endWord, Map<String, List<String>> dict, List<String> list,
            List<List<String>> outputs) {
        if (beginWord.equals(endWord)) {
            if (outputs.size() == 0)
                outputs.add(new ArrayList<>(list));
            else {
                List<String> output = outputs.get(0);
                if (output.size() < list.size())
                    return;

                if (output.size() > list.size())
                    outputs.clear();

                outputs.add(new ArrayList<>(list));
            }

            return;
        }

        // change one letter
        for (int i = 0; i < beginWord.length(); i++) {
            String pattern = beginWord.substring(0, i) + '*' + beginWord.substring(i + 1, beginWord.length());
            for (String adjacentWord : dict.getOrDefault(pattern, new ArrayList<>())) {
                if (!list.contains(adjacentWord)) {
                    list.add(adjacentWord);
                    backtrace(adjacentWord, endWord, dict, list, outputs);
                    // backtrace
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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

        // init queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // remember next nodes from the start node (level by level)
        Map<String, List<String>> graph = new HashMap<>();

        // visited
        Set<String> visited = new HashSet<>();

        // BFS
        while (!queue.isEmpty()) {
            visited.addAll(queue);
            List<String> toVisit = new ArrayList<>();

            for (String word : queue) {
                for (int i = 0; i < word.length(); i++) {
                    // *it, h*t, hi*
                    String pattern = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                    for (String adjacentWord : allComboDict.getOrDefault(pattern, new ArrayList<>())) {
                        // ingore visited adjacentWord in previous level
                        if (!visited.contains(adjacentWord)) {
                            if (!graph.containsKey(word))
                                graph.put(word, new ArrayList<>());
                            graph.get(word).add(adjacentWord);
                            
                            if (!toVisit.contains(adjacentWord)) {
                                toVisit.add(adjacentWord);
                            }
                        }
                    }
                }
            }

            if (toVisit.contains(endWord))
                break;

            queue = new LinkedList<>(toVisit);
        }

        // for(Map.Entry<String, List<String>> e : graph.entrySet())
        // System.out.println(e.getKey() + ": " + e.getValue());

        List<List<String>> results = new ArrayList<>();
        dfs(beginWord, endWord, graph, new ArrayList<>(), results);

        return results;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> graph, List<String> path,
            List<List<String>> results) {
        path.add(beginWord);

        if (beginWord.equals(endWord)) {
            results.add(new ArrayList<String>(path));
        } else if (graph.containsKey(beginWord)) {
            for (String nextWord : graph.get(beginWord))
                dfs(nextWord, endWord, graph, path, results);
        }

        path.remove(path.size() - 1);
    }
}