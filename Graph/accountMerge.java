class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUparent(int node){
        if(node == parent[node]) return node;
        else{
            parent[node] = findUparent(parent[node]);
            return parent[node];
        }
    }
    public void findBySize(int u,int v){
        int uByP = findUparent(u);
        int vByP = findUparent(v);
        if(parent[uByP] == parent[vByP]) return;
        if(parent[uByP] < parent[vByP]){
            parent[uByP] = vByP;
            size[vByP] += size[uByP];
        }else{
            parent[vByP] = uByP;
            size[uByP] += size[vByP];
        }
    }
}
class Solution {
    public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
        int n = arr.length;
        DSU ds = new DSU(n);
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 1;j<arr[i].length;j++){
                if(!mp.containsKey(arr[i][j])){
                    mp.put(arr[i][j],i);
                }else{
                    ds.findBySize(i,mp.get(arr[i][j]));
                }
            }
        }
        ArrayList<String>[] merge = new ArrayList[n];
        for(int i = 0;i<n;i++){
            merge[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> node : mp.entrySet()){
            String key = node.getKey();
            int nd = ds.findUparent(node.getValue());
            merge[nd].add(key);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(merge[i].isEmpty()) continue;
            Collections.sort(merge[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            for(String str : merge[i]){
                temp.add(str);
            }
            ans.add(temp);
        }
        Collections.sort(ans,(a,b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
}
