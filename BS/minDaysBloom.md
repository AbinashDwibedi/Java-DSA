# Minimum days to make M bouquets
```java
class Solution:
    def minDaysBloom(self, arr, k, m):
        if k * m > len(arr): 
            return -1
        left = min(arr)
        right = max(arr)
        res  = -1
        def crtdB(numD):
            l = 0
            n = 0
            for ele in arr:
                if ele <= numD:
                    l += 1
                    if l == k:
                        l = 0
                        n+= 1
                else:
                    l = 0
            return n
        while left <= right:
            mid = left + (right-left) //2 
            c = crtdB(mid)
            if c >= m:
                res = mid
                right = mid-1
            else:
                left = mid+1
        return res
```
