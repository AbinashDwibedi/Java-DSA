# Directed Graph Cycle
```python
class Solution:
    def isCyclic(self, V, edges):
        adj = [[] for _ in range(V)]
        for u,v in edges:
            adj[u].append(v)
            
        visited = [False]* V
        pathV = [False]* V
        
        def dfs(node):
            visited[node] = True
            pathV[node] = True
            
            for nei in adj[node]:
                if pathV[nei]:
                    return True
                if not visited[nei]:
                    if dfs(nei):
                        return True
            pathV[node] = False
            return False
            
        for i in range(V):
            if not visited[i] :
                if dfs(i):
                    return True
        return False
                
```