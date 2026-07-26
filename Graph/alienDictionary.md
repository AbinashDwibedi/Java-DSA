# Alien Dictionary

```python
class Solution:
    def findOrder(self, words):
        present = [False]*26
        adj = [[] for _ in range(26)]
        for word in words:
            for ch in word:
                present[ord(ch) - ord("a")]=True
        n = len(words)
        ndegree = [0]*26
        for i in range(1, n):
            str1 = words[i-1]
            str2 = words[i]
            mini = min(len(str1), len(str2))
            if len(str1) > len(str2) and str1[:mini] == str2[:mini]:
                return ""
            for j in range(mini):
                if str1[j] != str2[j]:
                    u = ord(str1[j]) - ord("a")
                    v = ord(str2[j]) - ord("a")
                    adj[u].append(v)
                    ndegree[v]+=1
                    break
        dq = deque()
        res = ""
        for i in range(26):
            if ndegree[i] == 0 and present[i]:
                dq.append(i)
        while dq:
            elem = dq.popleft()
            res+=(chr(ord("a") + elem))
            for node in adj[elem]:
                ndegree[node] -=1 
                if ndegree[node ] == 0:
                    dq.append(node)
        count = 0
        for i in range(26):
            if present[i]:
                count+=1
        return res if len(res) == count else ""
        
```