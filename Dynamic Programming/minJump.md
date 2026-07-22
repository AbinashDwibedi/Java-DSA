# Frog Jump
```java
import java.util.Arrays;
class Solution {
    int[] dpi;
    int minCost(int[] height) {
        int n = height.length;
        dpi = new int[n];
        // Arrays.fill(dpi,-1);
        
        for(int i = n-2;i>=0;i--){
            int oneTake = Math.abs(height[i]-height[i+1]) + dpi[i+1];
            int twoTake = Integer.MAX_VALUE;
            if(i+2 <n) twoTake = Math.abs(height[i]-height[i+2]) + dpi[i+2];
            dpi[i] = Math.min(oneTake,twoTake);
        }
        return dpi[0];
    }
    private int dp(int[] h, int i){
        if(i == h.length-1){
            return 0;
        }
        if(dpi[i] != -1) return dpi[i];
        int oneTake = Math.abs(h[i]-h[i+1]) + dp(h,i+1);
        int twoTake = Integer.MAX_VALUE;
        if(i+2 < h.length) twoTake = Math.abs(h[i]-h[i+2]) + dp(h,i+2);
        dpi[i] = Math.min(oneTake, twoTake);
        return dpi[i];
    }
}
```