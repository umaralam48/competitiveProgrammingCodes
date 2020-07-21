import java.util.HashMap;

class Trie {
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
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.chars.computeIfAbsent(c, (k) -> new TrieNode());
        }
        curr.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.chars.get(c) == null)
                return false;
            curr = curr.chars.get(c);
        }
        return curr.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.chars.get(c) == null)
                return false;
            curr = curr.chars.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        // TrieNode temp = new TrieNode();
        Trie myt = new Trie();
        myt.insert("apple");
        System.out.println(myt.search("app"));
        System.out.println(myt.search("apple"));
        System.out.println(myt.startsWith("app"));
    }
}
