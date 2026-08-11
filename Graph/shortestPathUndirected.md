# Shortest Path in Unweighted Graph

```python
class Solution:
    def shortestPath(self, V, edges, src, dest):
        distance = [float("inf")] * V
        adj = [[] for _ in range(V)]
        for i,j in edges:
            adj[i].append(j)
            adj[j].append(i)
        
        dq = deque([src])
        distance[src] = 0
        while dq:
            elem = dq.popleft()
            for node in adj[elem]:
                if distance[node] > distance[elem] + 1:
                    dq.append(node)
                    distance[node] = distance[elem]+1
        
        return distance[dest] if distance[dest] != float("inf") else -1
```