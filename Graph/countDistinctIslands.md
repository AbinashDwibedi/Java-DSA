# Number of Distinct Islands
```java
import java.util.*;

class Solution {
    public int countDistinctIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<List<String>> res = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    List<String> landscape = new ArrayList<>();
                    dfs(grid, visited, i, j, i, j, landscape);
                    res.add(landscape);
                }
            }
        }
        return res.size();
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c, int cr, int cc, List<String> landscape) {
        int m = grid.length;
        int n = grid[0].length;
        visited[r][c] = true;
        landscape.add((r - cr) + "," + (c - cc));
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 'L' && !visited[nr][nc]) {
                dfs(grid, visited, nr, nc, cr, cc, landscape);
            }
        }
    }
}
```