package romano.ds;

import java.util.Objects;

/**
 * Implementation of a prefix tree.
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    /** Adds a word to this trie */
    public void insert(String word) {
        Objects.requireNonNull(word);
        word = word.toLowerCase();
        var current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = indexOf(letter);
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.setEndWord(true);
    }

    /**
     * Returns {@code true} if the word exists on this trie and {@code false} otherwise.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        word = word.toLowerCase();
        var current = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = indexOf(letter);
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }

        return current.isEndWord();
    }

    /**
     * Deletes the given {@code word} from this trie.
     */
    public void delete(String word) {
        Objects.requireNonNull(word);
        delete(root, word.toLowerCase(), 0);
    }

    private static boolean delete(TrieNode root, String word, int level) {
        if (root == null) {
            return false;
        }

        if (level == word.length()) {
            if (root.isEndWord()) {
                root.setEndWord(false);
                return hasNoChildren(root);
            }

            return false;
        }

        var child = root.children[indexOf(word.charAt(level))];
        if (delete(child, word, level + 1)) {
            root.children[indexOf(word.charAt(level))] = null;

            return hasNoChildren(root) && !root.isEndWord();
        }

        return false;
    }

    private static boolean hasNoChildren(TrieNode node) {
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }

        return true;
    }

    private static int indexOf(char letter) {
        return letter - 'a';
    }

    public static class TrieNode {

        private static final int ALPHABET_SIZE = 26;
        private final TrieNode[] children;
        private boolean endWord;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
        }

        public boolean isEndWord() {
            return endWord;
        }

        public void setEndWord(boolean endWord) {
            this.endWord = endWord;
        }
    }
}
