package desavitsky.union_find;

import java.util.*;

// 128. Longest Consecutive Sequence
public class Task128 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutiveBetter(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) hs.add(num);
        int longest = 1;
        for (int num : nums) {
            //check if the num is the start of a sequence by checking if left exists
            if (!hs.contains(num - 1)) { // start of a sequence
                int count = 1;
                while (hs.contains(num + 1)) { // check if hs contains next no.
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);

            }
            if (longest > nums.length / 2) break;

        }
        return longest;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        var uf = new UnionFind(nums);
        var distinctNums = new HashSet<Integer>();

        for (var num : nums) {
            distinctNums.add(num);
            uf.unionIfExist(num, num - 1);
        }

        var res = new HashMap<Integer, Integer>();
        for (var num : distinctNums) {
            res.compute(
                    uf.find(num),
                    (_, rank) -> {
                        if (rank == null) {
                            return 1;
                        } else return rank + 1;
                    }
            );
        }
        return res.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }

    static class UnionFind {
        private final Map<Integer, Integer> parents;
        private final Map<Integer, Integer> rank;

        public UnionFind(int[] nums) {
            parents = new HashMap<>();
            rank = new HashMap<>();
            for (var num : nums) {
                parents.put(num, num);
                rank.put(num, 0);
            }
        }

        public int find(int i) {
            var node = i;
            while (node != parents.get(node)) {
                parents.put(node, parents.get(parents.get(node)));
                node = parents.get(node);
            }
            return node;
        }

        public boolean unionIfExist(int i, int j) {
            if (!parents.containsKey(i) || !parents.containsKey(j)) {
                return false;
            }
            var node1 = find(i);
            var node2 = find(j);

            if (node1 == node2) return false;

            if (rank.get(node1) < rank.get(node2)) {
                parents.put(node1, node2);
            } else if (rank.get(node2) < rank.get(node1)) {
                parents.put(node2, node1);
            } else {
                parents.put(node2, node1);
                rank.computeIfPresent(node2, (node, rank0) -> rank0 + 1);
            }
            return true;
        }

    }
}
