/*
211. Add and Search Word - Data structure design My Submissions Question
Total Accepted: 21502 Total Submissions: 106053 Difficulty: Medium
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or ..
A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

click to show hint.

You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/
public class _211_WordDictionary {

    private class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {}
        TrieNode(char c) {
            this.val = c;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';
            if (p.children[charIndex] == null)
                p.children[charIndex] = new TrieNode(word.charAt(i));
            p = p.children[charIndex];
        }
        p.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode p) {
        if (index == word.length())
            return p.isWord;
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (p.children[i] != null) {
                    if (search(word, index + 1, p.children[i]))
                        return true;
                }
            }
            return false;
        } else {
            int charIndex = word.charAt(index) - 'a';
            if (p.children[charIndex] == null)
                return false;
            return search(word, index + 1, p.children[charIndex]);
        }
    }
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");