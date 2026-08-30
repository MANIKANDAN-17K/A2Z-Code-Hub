class Pair{
    int dist;
    int node;
    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] vis = new int[V];
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int cost = pq.peek().dist;
            pq.remove();
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += cost;
            for(int[] nn : adj.get(node)){
                int next = nn[0];
                int wt = nn[1];
                if(vis[next] == 0){
                    pq.add(new Pair(next,wt));
                }
            }
        }
        return sum;
    }
}
