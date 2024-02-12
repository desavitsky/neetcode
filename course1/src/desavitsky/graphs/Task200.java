package desavitsky.graphs;


// 200. Number of Islands
public class Task200 {

    public int numIslands(char[][] grid) {
        var count = 0;
        for (var x = 0; x < grid.length; x++) {
            for (var y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    dfs(grid, x, y);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (Math.min(x, y) < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
