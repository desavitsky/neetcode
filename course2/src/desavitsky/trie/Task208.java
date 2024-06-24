package desavitsky.trie;

import java.util.HashMap;
import java.util.Map;

//  Implement Trie (Prefix Tree)
public class Task208 {
}

class Trie {

    static class TrieNode {
        private final TrieNode[] children;


        private boolean isWord;


        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }


    private final TrieNode head;

    public Trie() {
        head = new TrieNode();
    }

    public void insert(String word) {
        var current = head;
        for (var c : word.toCharArray()) {
            var position = c - 'a';
            if (current.children[position] != null) {
                current = current.children[position];
            } else {
                var newNode = new TrieNode();
                current.children[position] = newNode;
                current = newNode;
            }
        }
        current.setWord(true);
    }

    public boolean search(String word) {
        var current = head;
        for (var c : word.toCharArray()) {
            current = current.children[c - 'a'];
            if (current == null) return false;
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        var current = head;
        for (var c : prefix.toCharArray()) {
            current = current.children[c - 'a'];
            if (current == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */