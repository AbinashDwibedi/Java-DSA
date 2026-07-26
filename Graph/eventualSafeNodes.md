# Find Eventual Safe States

```python
class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        m = len(graph)
        visited = [False]*m
        pVisited = [False]*m
        check = [False]*m
        def dfs(start):
            visited[start] = True
            pVisited[start] = True
            check[start] = False

            for elem in graph[start]:
                if not visited[elem]:
                    if dfs(elem):
                        return True
                if pVisited[elem]:
                    return True
            pVisited[start] = False
            check[start] = True
            return False

        for start in range(m):
            if not visited[start]:
                dfs(start)
        return [ i for i in range(m) if check[i]]
```