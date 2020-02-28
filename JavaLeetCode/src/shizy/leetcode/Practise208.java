package shizy.leetcode;

/*
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 */

public class Practise208 {
    class TrieNode {
        boolean isKey;
        TrieNode[] children;

        public TrieNode() {
            // 'a' ~ 'z'
            children = new TrieNode[26];
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public void set(char ch, TrieNode child) {
            children[ch - 'a'] = child;
        }
    }

    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch))
                    node.set(ch, new TrieNode());

                node = node.get(ch);
            }

            node.isKey = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch))
                    return false;

                node = node.get(ch);
            }

            return node.isKey;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;

            for (char ch : prefix.toCharArray()) {
                if (!node.containsKey(ch))
                    return false;

                node = node.get(ch);
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Practise208 p = new Practise208();

        Trie trie = p.new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true

        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }
}