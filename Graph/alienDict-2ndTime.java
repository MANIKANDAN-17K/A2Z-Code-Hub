class Solution {
    private ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[26];
        for(int i = 0;i<26;i++){
            for(int nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<26;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer>  list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        return list.size() == 26 ? list : new ArrayList<>();
    }
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(String str : words){
            for(char ch : str.toCharArray()){
                set.add(ch - 'a');
            }
        }
        for(int i = 1;i<words.length;i++){
            String s1 = words[i-1];
            String s2 = words[i];
            int x = s1.length();
            int y = s2.length();
            int len = Math.min(x,y);
            int j = 0;
            while(j < len && s1.charAt(j) == s2.charAt(j)) j++;
            if(j == len){
                if(x > y) return"";
                continue;
            }
            adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
        }
        ArrayList<Integer> topo = topoSort(adj);
        if(topo.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for(int i : topo){
            if(set.contains(i)){
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
