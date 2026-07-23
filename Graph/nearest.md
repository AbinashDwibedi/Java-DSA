# Distance of nearest cell having 1
```java
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row.add(0);         
                    que.offer(new int[]{i, j});
                } else {
                    row.add(-1);    
                }
            }
            res.add(row);
        }
        
        int[] tr = new int[]{-1, 1, 0, 0};
        int[] tc = new int[]{0, 0, -1, 1};
        
        while (!que.isEmpty()) {
            int[] elem = que.poll();
            int row = elem[0];
            int col = elem[1];
            
            for (int i = 0; i < 4; i++) {
                int crow = row + tr[i];
                int ccol = col + tc[i];
                
                if (crow >= 0 && crow < m && ccol >= 0 && ccol < n && res.get(crow).get(ccol) == -1) {
                    int dist = res.get(row).get(col) + 1;
                    res.get(crow).set(ccol, dist);
                    que.offer(new int[]{crow, ccol});
                }
            }
        }
        
        return res;
    }
}
```