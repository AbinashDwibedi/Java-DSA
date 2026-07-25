# Course Schedule
```python
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        for i ,j in prerequisites:
            adj[i].append(j)
        
        nDegree = [0]*numCourses
        res = []
        for i in range(numCourses):
            for elem in adj[i]:
                nDegree[elem]+=1
        
        dq = deque()
        for i in range(numCourses):
            if nDegree[i] == 0:
                dq.append(i)
        while dq:
            elem = dq.popleft()
            res.append(elem)
            for node in adj[elem]:
                nDegree[node] -=1 
                if nDegree[node] == 0:
                    dq.append(node)
        return len(res) == numCourses
```