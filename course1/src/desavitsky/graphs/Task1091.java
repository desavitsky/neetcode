package desavitsky.graphs;

import java.util.*;

public class Task1091 {

    public static void main(String[] args) {
//        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid = {{0,0,0},{1,0,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    record Pair(int x, int y) {
        List<Pair> neighbours() {
            return List.of(
                    new Pair(x + 1, y),
                    new Pair(x - 1, y),
                    new Pair(x + 1, y + 1),
                    new Pair(x + 1, y - 1),
                    new Pair(x - 1, y + 1),
                    new Pair(x - 1, y - 1),
                    new Pair(x, y - 1),
                    new Pair(x, y + 1)
            );
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] != 0) return -1;
        var goal = new Pair(grid.length - 1, grid.length - 1);
        var start= new Pair(0, 0);

        Queue<Pair> queue = new LinkedList<>();

        var level = 0;
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var l = 0; l < size; l++) {
                var next = queue.poll();
                if (next.equals(goal)) return level + 1;
                var neighboursToAdd = next.neighbours().stream()
                        .filter(coord -> Math.min(coord.x, coord.y) >= 0 &&
                                Math.max(coord.x ,coord.y) < grid.length &&
                                grid[coord.x][coord.y] == 0)
                        .filter(visited::add)
                        .toList();
                queue.addAll(neighboursToAdd);
            }
            level++;
        }
        return -1;
    }


}
