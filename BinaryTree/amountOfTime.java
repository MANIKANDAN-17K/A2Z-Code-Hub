/*
Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void buildGraph(TreeNode node,TreeNode parent,HashMap<Integer,ArrayList<Integer>> graph){
        if(node == null) return;
        if(parent != null){
            graph.computeIfAbsent(node.val,K -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val,K -> new ArrayList<>()).add(node.val);
        }
        buildGraph(node.left,node,graph);
        buildGraph(node.right,node,graph);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        buildGraph(root,null,graph);
        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit.add(start);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i = 0;i<size;i++){
                int val = q.poll();
                for(int node : graph.getOrDefault(val,new ArrayList<>())){
                    if(!visit.contains(node)){
                        visit.add(node);
                        q.offer(node);
                        flag = true;
                    }
                }
            }
            if(flag) time++;
        }
        return time;
    }
}
