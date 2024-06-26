package desavitsky.trie;

import java.util.List;
import java.util.stream.IntStream;

public class Task745 {
    public static void main(String[] args) {
        var f = new WordFilter(new String[]{"apple"});
        System.out.println(f.f("a", "e"));
    }
}

class WordFilter {

    private TrieNode prefixTrie = new TrieNode();

    public WordFilter(String[] words) {
        for (var i = 0; i < words.length; i++) {
            for (var comb : combinations(words[i])) {
                prefixTrie.addWord(comb, i);
            }
        }
    }

    private List<String> combinations(String word) {
        var str = word + "{" + word;
        return IntStream.range(0, word.length() + 2) // 0 - 4
                .boxed()
                .map(str::substring)
                .filter(s -> !s.startsWith("{"))
                .toList();
    }

    public int f(String pref, String suff) {
        return prefixTrie.getIndex(suff + "{" + pref);
    }


    class TrieNode {

        private TrieNode[] children = new TrieNode[27];

        private int index = 0;


        public void addWord(String word, int index) {
            var currentTrie = this;
            for (var c : word.toCharArray()) {
                var position = c - 'a';
                if (currentTrie.children[position] == null) {
                    currentTrie.children[position] = new TrieNode();
                }
                currentTrie = currentTrie.children[position];
                currentTrie.setIndex(index);
            }
        }

        public int getIndex(String part) {
            var currentTrie = this;
            for (var c : part.toCharArray()) {
                currentTrie = currentTrie.children[c - 'a'];
                if (currentTrie == null) return -1;
            }
            return currentTrie.getIndex();
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}