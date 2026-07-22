# Koko Eating Bananas
```java
class Solution:
    def kokoEat(self, arr, k):
        left = 1
        right = max(arr)
        res = 0
        def timeRequired(num):
            hl = 0
            for elem in arr:
                hl+= math.ceil(elem/num)
            return hl
        while(left <= right):
            mid = left + (right -left)//2
            t = timeRequired(mid)
            if t > k:
                left = mid+1
            else:
                res = mid
                right = mid-1
        return res
```
