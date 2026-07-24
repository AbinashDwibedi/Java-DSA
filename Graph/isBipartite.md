# Is Graph Bipartite?
```python
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        m = len(graph)
        visited = [-1]*m
        def dfs(node, c):
            visited[node] = c
            for i in graph[node]:
                if c == visited[i]:
                    return False
                if visited[i] == -1 and not dfs(i, 1 - c):
                    return False
            return True
        for elem in range(m):
            if visited[elem] == -1:
                if not dfs(elem, 0):
                    return False
                # que = deque([elem])
                # visited[elem] = 0
                # while que:
                #     tmp = que.popleft()
                #     for node in graph[tmp]:
                #         if visited[node] == visited[tmp]:
                #             return False
                #         if visited[node] == -1:
                #             visited[node] = 1 - visited[tmp]
                #             que.append(node)
        return True
```