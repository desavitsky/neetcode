package desavitsky.union_find;

import java.util.HashSet;

// Count Connected Components
public class Task2685 {
    public static int countComponents(int n, int[][] edges) {
        var uf = new Task721.UnionFind(n);
        for (var edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        var result = new HashSet<Integer>();

        for (var i = 0; i < n; i++) {
            result.add(uf.find(i));
        }
        return result.size();
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
