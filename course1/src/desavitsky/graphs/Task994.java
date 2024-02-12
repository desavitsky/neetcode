package desavitsky.graphs;

import java.util.*;

// Rotting Oranges
public class Task994 {

    public static void main(String[] args) {
        orangesRotting(new int[][]{{2,1,1}, {1,1,0}, {0,1,1}});
        var res = orangesRotting(new int[][]{{0}});
        System.out.println(res);
    }

    record Coordinate(int x, int y) {
        public List<Coordinate> neighbours() {
            return List.of(
                    new Coordinate(x + 1, y),
                    new Coordinate(x - 1, y),
                    new Coordinate(x, y - 1),
                    new Coordinate(x, y + 1)
            );
        }
    }

    public static int orangesRotting(int[][] grid) {

        Set<Coordinate> rotten = new HashSet<>();

        for (var x = 0; x < grid.length; x++) {
            for (var y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) rotten.add(new Coordinate(x, y));
            }
        }

        var minute = 0;

        Queue<Coordinate> queue = new LinkedList<>();

        Set<Coordinate> toAdd = new HashSet<>(rotten);

        while (!toAdd.isEmpty()) {
            minute++;
            toAdd.forEach(coord -> {
                queue.add(coord);
                grid[coord.x][coord.y] = 2;
            });
            toAdd = new HashSet<>();
            var curSize = queue.size();
            for (var i = 0; i < curSize; i++) {
                queue.poll()
                        .neighbours()
                        .stream()
                        .filter(coord ->
                                Math.min(coord.x, coord.y) >= 0 &&
                                        coord.x < grid.length &&
                                        coord.y < grid[0].length &&
                                        grid[coord.x][coord.y] == 1)
                        .distinct()
                        .forEach(toAdd::add);
            }
        }
        return Arrays.stream(grid).anyMatch(row -> Arrays.stream(row).anyMatch(el -> el == 1)) ? -1 : minute - 1;
    }
}
