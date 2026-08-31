/*
A critical connection refers to an edge that, upon removal, will make it impossible for certain nodes to reach each other through any path. You are given an undirected connected graph with v vertices and e edges where each vertex is distinct and ranges from 0 to v-1, and you have to find all critical connections in the graph. It is ensured that there is at least one such edge present.

Note: Return the connections in sorted order.

Examples:

Input:

Output: 
0 1
0 2
Explanation: On removing edge (0, 1), you will not be able to reach node 0 and 2 from node 1. Also, on removing edge (0, 2), you will not be able to reach node 0
and 1 from node 2.

Input:

Output: 2 3
Explanation: The edge between nodes 2 and 3 is the only Critical connection in the given graph.

Constraints:
1 ≤ v, e ≤ 104
*/
class Solution {
    int timer = 0;
    public void dfs(int node,int parent,int[] low,int[] tin,boolean[] vis,ArrayList<ArrayList<Integer>> ans,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        tin[node] = low[node] = timer++;
        for(int nbr : adj.get(node)){
            if(parent == nbr) continue;
            if(!vis[nbr]){
                dfs(nbr,node,low,tin,vis,ans,adj);
                low[node] = Math.min(low[node],low[nbr]);
                if(low[nbr] > tin[node]){
                    ans.add(new ArrayList<>(Arrays.asList(
                        Math.min(nbr,node),Math.max(nbr,node))));
                }
            }
            else{
                low[node] = Math.min(low[node],tin[nbr]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(
            int V, ArrayList<ArrayList<Integer>> adj) {
        int[] low = new int[V];
        int[] tin = new int[V];
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<V;i++){
            if(!vis[i])
                dfs(0,-1,low,tin,vis,ans,adj);
        }
        Collections.sort(ans,(a,b) -> 
        a.get(0).equals(b.get(0)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        return ans;
    }
}
