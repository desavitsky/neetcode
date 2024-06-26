package desavitsky.trie;

import java.util.*;
import java.util.stream.Stream;

// Word Search II
public class Task212 {

    public static void main(String[] args) {
        System.out.println(findWords(
                new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}
        ));

        System.out.println(findWords(
                new char[][]{{'a', 'a'}},
                new String[]{"aaa"}
        ));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        var dict = new Dict();
        for (String word : words) {
            dict.insert(word);
        }

        var result = new HashSet<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                var coord = new Coordinate(i, j);
                var visited = new HashSet<Coordinate>();
                visited.add(coord);
                result.addAll(findWordsHelper(board, dict, dict.getRoot(), coord, visited, ""));
            }
        }

        return result.stream().toList();

    }

    record Coordinate(int x, int y) {
        public List<Coordinate> next(int limitX, int limitY) {
            return Stream.of(
                            new Coordinate(x, y + 1),
                            new Coordinate(x, y - 1),
                            new Coordinate(x - 1, y),
                            new Coordinate(x + 1, y)
                    )
                    .filter(coord -> coord.x < limitX && coord.y < limitY && coord.x >= 0 && coord.y >= 0)
                    .toList();
        }
    }

    private static List<String> findWordsHelper(char[][] board, Dict dict, Dict.DictNode node, Coordinate coord, Set<Coordinate> visited, String word) {
        var currentChar = board[coord.x][coord.y];
        var updWord = word + currentChar;
        var words = new ArrayList<String>();

        var child = node.getChild(currentChar);

        if (child != null) {
            if (child.isWord()) {
                System.out.println(STR."ADDING WORD: \{updWord}");
                words.add(updWord);
                dict.removeWord(updWord);
                System.out.println(STR."IS WORD still there: \{dict.search(updWord)}");
            }
            coord.next(board.length, board[0].length)
                    .stream()
                    .filter(coord1 -> !visited.contains(coord1))
                    .forEach(coord1 -> {
                        visited.add(coord1);
                        words.addAll(findWordsHelper(board, dict, child, coord1, visited, updWord));
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

        public boolean isWord() {
            return isWord;
        }

        public void deleteChild(char c) {
            children[c - 'a'] = null;
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
            if (current.children[position] == null) {
                current.children[position] = new DictNode();
            }
            current = current.children[position];

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

    public void removeWord(String word) {
        removeWordHelper(word, 0, head);
    }

    private boolean removeWordHelper(String word, int index, DictNode node) {
        if (index == word.length()) {
            if (Arrays.stream(node.children).allMatch(Objects::isNull)) {
                return true;
            } else {
                node.setWord(false);
                return false;
            }
        } else {
            if (removeWordHelper(word, index + 1, node.getChild(word.charAt(index)))) {
                node.deleteChild(word.charAt(index));
                return Arrays.stream(node.children).allMatch(Objects::isNull);
            } else return false;
        }
    }

    public DictNode getRoot() {
        return head;
    }
}


