# Stickler Thief
```java
import java.util.Arrays;
class Solution {
    int[] dp;
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int var1 = 0;
        int var2 = 0;
        for(int i = n-1; i >= 0; i--){
            int nt = var1;
            int t = arr[i] + var2;
            var2 = var1;
            var1 = Math.max(nt, t);
        }
        return var1;
    }
    private int helper(int[] arr, int i){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int nT = helper(arr , i+1);
        int t = arr[i] + helper(arr, i+2);
        dp[i] = Math.max(nT , t);
        return dp[i];
    }
}
```