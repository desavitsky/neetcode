package desavitsky.trie;

import java.util.HashMap;
import java.util.Map;

public class Task211 {

}

class WordDictionary {

    static class DictionaryNode {
        private boolean isWord;

        private Map<Character, DictionaryNode> children;

        public DictionaryNode() {
            isWord = false;
            children = new HashMap<>();

        }
    }

    private final DictionaryNode root;

    public WordDictionary() {
        root = new DictionaryNode();
    }

    public void addWord(String word) {
        var node = root;
        for (char c : word.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                var newNode = new DictionaryNode();
                node.children.put(c, newNode);
                node = newNode;
            }
        }
        node.isWord = true;

    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(DictionaryNode node, String word, int index) {
        if (index == word.length()) return node.isWord;
        var nextChar = word.charAt(index);
        if (nextChar == '.') {
            return node.children.values().stream().anyMatch(nextNode -> searchHelper(nextNode, word, index + 1));
        } else if (node.children.containsKey(nextChar)) {
            return searchHelper(node.children.get(nextChar), word, index + 1);
        } else return false;
    }
}
