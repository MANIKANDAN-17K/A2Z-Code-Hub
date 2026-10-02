/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.

*/

class Solution {
    private void dfs(char[][] grid,int i,int j){
        grid[i][j] = '#';
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d : dir){
            int nx = i + d[0];
            int ny = j + d[1];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1'){
                dfs(grid,nx,ny);
            }
        }
    }    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
