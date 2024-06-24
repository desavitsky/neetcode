package desavitsky.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

// Word Search II
public class Task212 {

    public static void main(String[] args) {

    }

    public List<String> findWords(char[][] board, String[] words) {
        var dict = new Dict();
        for (String word : words) {
            dict.insert(word);
        }

        return findWordsHelper(board, dict, new Coordinate(0, 0), new HashSet<>(), "");

    }

    record Coordinate(int x, int y) {
        public List<Coordinate> next(int limitX, int limitY) {
            return Stream.of(
                            new Coordinate(x + 1, y + 1),
                            new Coordinate(x - 1, y + 1),
                            new Coordinate(x - 1, y - 1),
                            new Coordinate(x + 1, y - 1)
                    )
                    .filter(coord -> coord.x < limitX && coord.y < limitY && coord.x >= 0 && coord.y >= 0)
                    .toList();
        }
    }

    private List<String> findWordsHelper(char[][] board, Dict dict, Coordinate coord, Set<Coordinate> visited, String word) {
        var currentChar = board[coord.x][coord.y];
        var updWord = word + currentChar;
        var words = new ArrayList<String>();
        if (dict.startsWith(updWord)) { // replace node, not boolean
            if (dict.search(updWord)) {
                words.add(updWord);
            }
            coord.next(board.length, board[0].length)
                    .stream()
                    .filter(coord1 -> !visited.contains(coord1))
                    .forEach(coord1 -> {
                        visited.add(coord1);
                        words.addAll(findWordsHelper(board, dict, coord1, visited, updWord));
                        visited.remove(coord1);
                    });
        }
        return words;
    }
}

class Dict {

    static class DictNode {
        private final DictNode[] children;

        private boolean isWord;


        public DictNode() {
            this.children = new DictNode[26];
            this.isWord = false;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public DictNode getChild(char c) {
            return children[c - 'a'];
        }
    }


    private final DictNode head;

    public Dict() {
        head = new DictNode();
    }

    public void insert(String word) {
        var current = head;
        for (var c : word.toCharArray()) {
            var position = c - 'a';
            if (current.children[position] != null) {
                current = current.children[position];
            } else {
                var newNode = new DictNode();
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

    public DictNode getRoot() {
        return head;
    }
}


