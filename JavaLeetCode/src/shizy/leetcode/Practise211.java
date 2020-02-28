package shizy.leetcode;

/*
 * Design a data structure that supports the following two operations:
 *   void addWord(word)
 *   bool search(word)
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or '.'; A '.' means it can represent any one letter.
 * 
 * Example:
 *   addWord("bad")
 *   addWord("dad")
 *   addWord("mad")
 *   search("pad") -> false
 *   search("bad") -> true
 *   search(".ad") -> true
 *   search("b..") -> true
 */

public class Practise211 {
    class WordDictionaryNode {
        boolean isKey;
        WordDictionaryNode[] children;

        public WordDictionaryNode() {
            // 'a' ~ 'z' and '.'
            children = new WordDictionaryNode[27];
        }
    }

    class WordDictionary {
        private WordDictionaryNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new WordDictionaryNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            WordDictionaryNode n = root;

            for (char ch : word.toCharArray()) {
                if (n.children[ch - 'a'] == null)
                    n.children[ch - 'a'] = new WordDictionaryNode();

                n = n.children[ch - 'a'];
            }

            n.isKey = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return searchHelper(root, word);
        }

        private boolean searchHelper(WordDictionaryNode root, String word) {
            if (word.length() == 0)
                return root != null && root.isKey;
            ;

            char ch = word.charAt(0);
            String subWord = word.substring(1);

            if (ch != '.') {
                if (root.children[ch - 'a'] == null)
                    return false;

                return searchHelper(root.children[ch - 'a'], subWord);
            } else {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (root.children[c - 'a'] != null && searchHelper(root.children[c - 'a'], subWord))
                        return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Practise211 p = new Practise211();

        WordDictionary wd = p.new WordDictionary();
        // wd.addWord("bad");
        // wd.addWord("dad");
        // wd.addWord("mad");

        // System.out.println(wd.search("pad"));
        // System.out.println(wd.search("bad"));
        // System.out.println(wd.search(".ad"));
        // System.out.println(wd.search("b.."));

        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search("."));
        System.out.println(wd.search("a"));
        System.out.println(wd.search("aa"));
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));
    }
}