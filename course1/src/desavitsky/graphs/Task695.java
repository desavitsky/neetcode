package desavitsky.graphs;

// Max Area of Island
public class Task695 {
    public int maxAreaOfIsland(int[][] grid) {
        var maxArea = 0;
        for (var x = 0; x < grid.length; x++) {
            for (var y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    maxArea = Math.max(maxAreaOfIsland(grid, x, y), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int maxAreaOfIsland(int[][] grid, int x, int y) {
        if (Math.min(x, y) < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        var area = 1;
        area += maxAreaOfIsland(grid, x + 1, y);
        area += maxAreaOfIsland(grid, x - 1, y);
        area += maxAreaOfIsland(grid, x, y + 1);
        area += maxAreaOfIsland(grid, x, y - 1);
        return area;
    }
}
