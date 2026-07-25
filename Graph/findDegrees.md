# Find the Degree of Each Vertex
```python
class Solution:
    def findDegrees(self, matrix: list[list[int]]) -> list[int]:
        # res = []
        # for lst in matrix:
        #     count = 0
        #     for num in lst:
        #         if num == 1:
        #             count+=1
        #     res.append(count)
        # return res
        return [sum(lst) for lst in matrix]
```