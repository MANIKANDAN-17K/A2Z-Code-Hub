class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{src,0});
        dist[src] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int next = cur[0];
            int wt = cur[1];
            if(wt != dist[next]) continue;
            for(int[] nn : adj.get(next)){
                int node = nn[0];
                int cost = nn[1];
                if(wt + cost < dist[node]){
                    dist[node] = wt + cost;
                    pq.add(new int[]{node,dist[node]});
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < V;i++){
            ans.add(dist[i]);
        }
        return ans;
    }
}
