/*
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
    public void dfs(int i,int j,char[][] grid){
        int n= grid.length;
        grid[i][j] = '*';
        int m = grid[0].length;
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        for(int[] d : dir){
            int nx = d[0] + i;
            int ny = d[1] + j;
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == '1'){
                dfs(nx,ny,grid);
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
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}
