# Aggressive Cows Solution
```java
import java.util.Arrays;
class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int left = 1;
        int right = stalls[n-1] - stalls[0];
        int res = left;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(stalls, k , mid)){
                res = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return res;
    }
    private boolean isPossible(int[] stalls, int k, int diff){
        int cow = 1;
        int start = stalls[0];
        for(int i =1 ;i < stalls.length ; i++){
            int sDiff = stalls[i] - start;
            if(sDiff >= diff){
                cow += 1;
                start = stalls[i];
            }
        }
        return cow >= k;
    }
}
```