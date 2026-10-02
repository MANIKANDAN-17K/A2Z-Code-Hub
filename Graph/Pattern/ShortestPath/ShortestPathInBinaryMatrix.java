/*
1091. Shortest Path in Binary Matrix

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

 


Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

 

Constraints:

    n == grid.length
    n == grid[i].length
    1 <= n <= 100
    grid[i][j] is 0 or 1

*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{1,0,0});
        grid[0][0] = 2;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int step = curr[0];
            int x = curr[1];
            int y = curr[2];
            if(x == n - 1 && y == n-1) return step;
            for(int[] d : dir){
                int nx = d[0] + x;
                int ny = d[1] + y;
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0){
                    grid[nx][ny] = 2;
                    pq.add(new int[]{step + 1, nx,ny});
                }
            }
        }
        return -1;
    }
}
