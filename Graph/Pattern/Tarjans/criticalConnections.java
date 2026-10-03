/*
1192. Critical Connections in a Network

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]

 

Constraints:

    2 <= n <= 105
    n - 1 <= connections.length <= 105
    0 <= ai, bi <= n - 1
    ai != bi
    There are no repeated connections.

 */

class Solution {
    private int timer = 0;
    private void dfs(
        int node,
        int parent,
        int[] low,
        int[] tin,
        boolean[] vis,
        List<List<Integer>> ans,
        List<List<Integer>> conn
        ){
            vis[node] = true;
            low[node] = tin[node] = timer++;
            for(int nbr : conn.get(node)){
                if(nbr == parent) continue;
                if(!vis[nbr]){
                    dfs(nbr,node,low,tin,vis,ans,conn);
                    low[node] = Math.min(low[node],low[nbr]);
                    if(low[nbr] > tin[node]){
                        ans.add(new ArrayList<>(Arrays.asList(Math.min(nbr,node),Math.max(nbr,node))));
                    }
                }else{
                    low[node] = Math.min(low[node],tin[nbr]);
                }
            }
        }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n];
        int[] tin = new int[n];
        boolean[] vis =new boolean[n];
         List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(!vis[i])
                {dfs(i,-1,low,tin,vis,ans,adj);}
        }
        Collections.sort(ans,(a,b)-> a.get(0).equals(b.get(0)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        return ans;
    }
}
