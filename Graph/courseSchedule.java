/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 

Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.
*/

class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0;i<n;i++){
            for(int[] pre : p){
                adj.get(pre[1]).add(pre[0]);
                indegree[pre[0]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int next = q.poll();
            for(int nbr : adj.get(next)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}
