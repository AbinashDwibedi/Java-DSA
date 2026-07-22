# Capacity To Ship Packages Within D Days
 
```java
class Solution:
    def leastWeightCapacity(self, arr, D):
        left = max(arr)
        right = sum(arr)
        res = -1
        def daysRequired(num):
            days = 1
            suma = 0
            for wt in arr:
                if suma + wt > num:
                    days+=1
                    suma = wt
                else:
                    suma+=wt
            return days
                    
        while(left <= right):
            mid = left + (right - left)//2
            dr = daysRequired(mid)
            if dr > D:
                left = mid+1
            else:
                res = mid
                right = mid-1
        return res
```
