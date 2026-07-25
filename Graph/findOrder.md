# Course Schedule II
```python
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(numCourses)]
        for i,j in prerequisites:
            adj[j].append(i)
        
        visited = [False]*numCourses
        pVisited = [False]*numCourses
        res = []
        def dfs(node):
            visited[node] = True
            pVisited[node] = True
            for elem in adj[node]:
                if not visited[elem]:
                    if dfs(elem):
                        return True
                if pVisited[elem]:
                    return True
            pVisited[node] = False
            res.append(node)
            return False
        for i in range(numCourses):
            if not visited[i]:
                if dfs(i): 
                    return []
        return res[::-1] if len(res) == numCourses else []
```