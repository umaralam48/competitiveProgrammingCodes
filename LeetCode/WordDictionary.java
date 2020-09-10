import java.util.HashMap;

class WordDictionary {

    private class TrieNode {
        public HashMap<Character, TrieNode> chars;
        public boolean isWord;

        public TrieNode() {
            this.chars = new HashMap<>();
            this.isWord = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.chars.computeIfAbsent(c, (k) -> new TrieNode());

        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode curr, int i) {

        for (; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.chars.get(c) == null && c != '.')
                return false;
            else if (c == '.') {
                for (TrieNode next : curr.chars.values()) {
                    if (search(word, next, i + 1))
                        return true;
                }
                return false;
            } else {
                curr = curr.chars.get(c);
            }

        }
        return curr.isWord;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        boolean param_2 = obj.search("bad");
        boolean param_3 = obj.search(".ad");
    }
}
