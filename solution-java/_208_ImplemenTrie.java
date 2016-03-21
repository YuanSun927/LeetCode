/*
Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/
public class _208_ImplementTrie {

    class TrieNode {

        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        // Initialize your data structure here.
        public TrieNode() {
        }

        public TrieNode(char c) {
            this.val = c;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (p.children[charIndex] == null) {
                    p.children[charIndex] = new TrieNode(word.charAt(i));
                }
                p = p.children[charIndex];
            }
            p.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (p.children[charIndex] == null)
                    return false;
                p = p.children[charIndex];
            }
            return p.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int charIndex = prefix.charAt(i) - 'a';
                if (p.children[charIndex] == null)
                    return false;
                p = p.children[charIndex];
            }
            return true;
        }
    }

    // Your Trie object will be instantiated and called as such:
    // Trie trie = new Trie();
    // trie.insert("somestring");
    // trie.search("key");
}
