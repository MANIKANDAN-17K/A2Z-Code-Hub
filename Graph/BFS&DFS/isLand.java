class Solution {
    private void dfs(char[][] grid,int x,int y){
        grid[x][y] = '#';
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] d : dir){
            int nx = d[0] + x;
            int ny = d[1] + y;
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
