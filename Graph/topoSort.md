# Topological Sort

```python
from collections import deque
class Solution:
    def topoSort(self, V, edges):
        adj = [[] for _ in range(V)]
        for i,j in edges:
            adj[i].append(j)
        
        # visited = [False]*V
        # res = []
        # def dfs(node):
        #     visited[node] = True
        #     for elem in adj[node]:
        #         if not visited[elem]:
        #             dfs(elem)
        #     res.append(node)
            
        # for start in range(V):
        #     if not visited[start]:
        #         dfs(start)
        # return res[::-1]
        
        nDegree = [0]*V
        for i in range(V):
            for elem in adj[i]:
                nDegree[elem]+=1
        dq = deque()
        for i in range(V):
            if nDegree[i] == 0:
                dq.append(i)
        res = []
        while dq:
            elem = dq.popleft()
            res.append(elem)
            
            for node in adj[elem]:
                nDegree[node] -= 1
                if nDegree[node] == 0:
                    dq.append(node)
        return res
```