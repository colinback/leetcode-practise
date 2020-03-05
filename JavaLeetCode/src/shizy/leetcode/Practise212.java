package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;

/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where 'adjacent' cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once in a word.
 * 
 * Example:
 * Input: 
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ['oath','pea','eat','rain']
 * 
 * Output: ['eat','oath']
 */

public class Practise212 {
    class TrieNode {
        boolean isKey;
        TrieNode[] children = new TrieNode[26]; // 'a' ~ 'z'
    }

    /** Initialize your data structure here. */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();

                node = node.children[ch - 'a'];
            }

            node.isKey = true;
        }

        return root;
    }

    // DFS
    private void dfs(char[][] board, boolean[][] visited, int i, int j, StringBuffer sb, TrieNode node,
            List<String> res) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        // System.out.println(i + ' , ' + j);
        visited[i][j] = true;

        // char at board[i][j]
        char ch = board[i][j];

        // return if node.children[ch - 'a'] does not exits in trie
        if (node.children[ch - 'a'] == null)
            return;

        // append board[i][j] to string buffer
        sb.append(board[i][j]);

        // add sb.toString into list if it is in the trie
        if (node.children[ch - 'a'].isKey && !res.contains(sb.toString()))
            res.add(sb.toString());

        for (int idx = 0; idx < 4; idx++) {
            int x = i + dirs[idx][0];
            int y = j + dirs[idx][1];

            if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                // next char
                dfs(board, visited, x, y, sb, node.children[ch - 'a'], res);
                // back trace
                visited[x][y] = false;
            }
        }
        // back trace
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> outputs = new ArrayList<>();

        // build words trie;
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                // visit flag
                boolean[][] visited = new boolean[rows][cols];
                // keep visited chars
                StringBuffer sb = new StringBuffer();

                dfs(board, visited, i, j, sb, root, outputs);
            }

        return outputs;
    }

    public static void main(String[] args) {
        Practise212 p = new Practise212();

        char[][] board = { 
            { 'o', 'a', 'a', 'n' },
            { 'e', 't', 'a', 'e' },
            { 'i', 'h', 'k', 'r' },
            { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };

        // char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
        // String[] words = { "acdb", "cabd" };

        // char[][] board = {
        //     { 'b', 'b', 'a', 'a', 'b', 'a' },
        //     { 'b', 'b', 'a', 'b', 'a', 'a' },
        //     { 'b', 'b', 'b', 'b', 'b', 'b' },
        //     { 'a', 'a', 'a', 'b', 'a', 'a' },
        //     { 'a', 'b', 'a', 'a', 'b', 'b' }
        // };
        // String[] words = { "abbbababaa" };

        System.out.println(p.findWords(board, words));
    }
}