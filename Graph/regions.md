# Surrounded Regions
```java
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i =0;i<m;i++){
            if(board[i][0] == 'O') dfs(board, i , 0);
            if(board[i][n-1] == 'O') dfs(board, i , n-1);
        }
        for(int i =0;i<n;i++){
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[m-1][i] == 'O') dfs(board, m-1, i);
        }

        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c){
        int m = board.length;
        int n = board[0].length;
        if(r<0 || r>=m || c<0 || c>=n || board[r][c] != 'O') return;

        board[r][c] = '#';
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }
    private void bfs(char[][] board, int r, int c) {
    int m = board.length;
    int n = board[0].length;

    Queue<int[]> que = new LinkedList<>();
    que.offer(new int[]{r, c});
    
   board[r][c] = '#';

    int[] tr = new int[]{-1, 1, 0, 0};
    int[] tc = new int[]{0, 0, -1, 1};

    while (!que.isEmpty()) {
        int[] tmp = que.poll();
        int rl = tmp[0];
        int cl = tmp[1];

        for (int i = 0; i < 4; i++) {
            int nr = rl + tr[i];
            int nc = cl + tc[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
                board[nr][nc] = '#';
                que.offer(new int[]{nr, nc});
            }
        }
    }
}
}
```