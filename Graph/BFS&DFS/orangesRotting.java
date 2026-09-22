class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] != 0){
                    if(grid[i][j] == 1) count++;
                    if(grid[i][j] == 2){
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
        int day = 0;
        while(!q.isEmpty()){
            int n1 = q.size();
            for(int i = 0;i<n1;i++)
            {    
                int[] pos = q.poll();
                for(int[] d : dir){
                    int nx = d[0] + pos[0];
                    int ny = d[1] + pos[1];
                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        count--;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            if(!q.isEmpty()) day++;
        }
        return count == 0 ? day : -1;
    }
}
