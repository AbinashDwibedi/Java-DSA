# Shortest path in Directed Acyclic Graph

```python
from typing import List
from collections import deque

class Solution:

    def shortestPath(self, V: int, E: int,
                     edges: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(V)]
        for i,j,k in edges:
            adj[i].append([j,k])
        
        visited = [False]*V
        dq = deque()
        def dfs(node):
            visited[node] = True
            for elem in adj[node]:
                if not visited[elem[0]]:
                    dfs(elem[0])
            dq.appendleft(node)
        for i in range(V):
            if not visited[i]:
                dfs(i)
                
        distance = [float("inf")]*V
        start = 0
        distance[start] = 0
        while dq:
            elem = dq.popleft()
            if distance[elem] != float("inf"):
                for ele, dist in adj[elem]:
                    if distance[ele] > distance[elem] + dist:
                        distance[ele] = distance[elem] + dist
                        
        return [-1 if elem == float("inf") else elem for elem in distance ]
            
```