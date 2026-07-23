# Undirected Graph Cycle
```java
import java.util.*;
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                // if(dfs(visited, adj, i, -1)){
                if(bfs(visited, adj, i)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bfs(boolean[] visited, List<List<Integer>> adj, int start){
        Queue<ArrayList<Integer>> que = new LinkedList<>();
        que.offer(new ArrayList<>(List.of(start, -1)));
        visited[start] = true;
        while(!que.isEmpty()){
            ArrayList<Integer> node = que.poll();
            for(int child: adj.get(node.get(0))){
                if(!visited[child]){
                    visited[child] = true;
                    que.offer(new ArrayList<>(List.of(child, node.get(0))));
                }
                else if(child != node.get(1)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(boolean[] visited, List<List<Integer>> adj, int start, int parent){
        visited[start] = true;
        for(int neighbour: adj.get(start)){
            if(!visited[neighbour]){
                if(dfs(visited, adj, neighbour, start)){
                    return true;
                }
            }
            else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
```