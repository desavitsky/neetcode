package desavitsky.union_find;

import java.util.*;
import java.util.stream.Collectors;

public class Task721 {

    public static void main(String[] args) {
        System.out.println(
                accountsMerge(
                        List.of(
                                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                                List.of("Mary", "mary@mail.com"),
                                List.of("John", "johnnybravo@mail.com")
                        )
                )
        );
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> numbers = new HashMap<>();

        final var uf = new UnionFind(accounts.size());

        for (var i = 0; i < accounts.size(); i++) {
            var acc = accounts.get(i);
            for (var email: acc.subList(1, acc.size())) {
                var exIndex = numbers.get(email);
                if (exIndex != null) {
                    uf.union(i, exIndex);
                } else {
                    numbers.put(email, i);
                }
            }
        }

        return numbers.entrySet()
                .stream()
                .map(s -> Map.entry(s.getKey(), uf.find(s.getValue())))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .map(entry -> {
                    List<String> res = new ArrayList<>();
                    res.add(accounts.get(entry.getKey()).get(0));
                    entry.getValue().sort(Comparator.naturalOrder());
                    res.addAll(entry.getValue());
                    return res;
                }).toList();
    }

    static class UnionFind {
        private final int[] parents;
        private final int[] rank;

        public UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            var node = i;
            while (node != parents[node]) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        public boolean union(int i, int j) {
            var node1 = find(i);
            var node2 = find(j);

            if (node1 == node2) return false;

            if (rank[node1] < rank[node2]) {
                parents[node1] = node2;
            } else if (rank[node2] < rank[node1]) {
                parents[node2] = node1;
            } else {
                parents[node1] = node2;
                rank[node2]++;
            }
            return true;
        }

    }

}
