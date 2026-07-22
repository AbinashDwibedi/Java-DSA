# 
```java
class Solution {
    public void solveSudoku(char[][] board) {
        solver(board);
    }
    private boolean isValid(char[][] board, char ch, int row, int col){
        for(int i = 0;i<9;i++){
            if(board[i][col] == ch) return false;
            if(board[row][i] == ch) return false;
            if(board[3 * (row/3) + i/3][3*(col/3) + i%3] == ch) return false;
        }
        return true;
    }
    private boolean solver(char[][] board){
        for(int i  =0; i< board.length; i++){
            for(int j  = 0; j<board[0].length;j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isValid(board, ch, i, j)){
                            board[i][j] = ch;
                            if(solver(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
```
### Bit mask solution 
```java
import java.util.*;

class Solution {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // Initialize masks
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int mask = 1 << num;
                    int box = (r / 3) * 3 + (c / 3);

                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[box] |= mask;
                }
            }
        }

        solve(board, 0, rows, cols, boxes);
    }

    private boolean solve(char[][] board, int idx,
                          int[] rows, int[] cols, int[] boxes) {

        if (idx == 81) return true;

        int r = idx / 9;
        int c = idx % 9;

        if (board[r][c] != '.') {
            return solve(board, idx + 1, rows, cols, boxes);
        }

        int box = (r / 3) * 3 + (c / 3);

        // available numbers = ~(used)
        int used = rows[r] | cols[c] | boxes[box];
        int available = (~used) & 0x1FF; // only 9 bits

        while (available != 0) {
            int pick = available & (-available); // lowest set bit
            int num = Integer.numberOfTrailingZeros(pick);

            // place
            board[r][c] = (char)(num + '1');
            rows[r] |= pick;
            cols[c] |= pick;
            boxes[box] |= pick;

            if (solve(board, idx + 1, rows, cols, boxes)) return true;

            // backtrack
            board[r][c] = '.';
            rows[r] ^= pick;
            cols[c] ^= pick;
            boxes[box] ^= pick;

            available &= (available - 1); // remove used bit
        }

        return false;
    }
}
```