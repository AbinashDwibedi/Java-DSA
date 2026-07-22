# 
```java
class Solution {
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right-left)/2;
            long sum = (long) mid * (mid +1)/2; // mistake 1 - not casted it properly
            if(sum == n) return mid;
            if(sum < n) left = mid+1;
            else right = mid-1;
        }
        return right;
        // mistake 2 - i thought to use iteration to check wheather its possible to calculate the sum or not
    }
}
```