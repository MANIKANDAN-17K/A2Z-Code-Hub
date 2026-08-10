class Solution {
    private int findNext(int [][] job,int idx){
        int n = job.length;
        int low = idx+1;
        int high = n-1;
        while(low <= high){
            int mid = (high + low) / 2;
            if(job[mid][0] >=  job[idx][1]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int maxPoint(int[][] jobs,int idx,int[] dp){
        if(idx >= jobs.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int skip = maxPoint(jobs,idx + 1,dp);
        int next = findNext(jobs,idx);
        int take = jobs[idx][2] + maxPoint(jobs,next,dp);
        return dp[idx] = Math.max(take,skip);
    }
    
    public int maxProfit(int[][] jobs) {
        Arrays.sort(jobs,(a,b) -> a[0] - b[0]);
        int[] dp = new int[jobs.length];
        Arrays.fill(dp,-1);
        return maxPoint(jobs,0,dp);
        
    }
}
/*
Given a 2D array jobs[][] of size n × 3, where each row represents a single job with the following details:

    jobs[i][0] : Start time of the job
    jobs[i][1] : End time of the job
    jobs[i][2] : Profit earned by completing the job

Find the maximum profit you can earn by scheduling non-overlapping jobs.

Note: Two jobs are said to be non-overlapping if the end time of one job is less than or equal to the start time of the next job. If a job ends at time X, another job can start exactly at time X.

Examples:

Input: jobs[][] =  [[1, 2, 50], 
                [3, 5, 20],
                [6, 19, 100],
                [2, 100, 200]] 
Output: 250
Explanation: The first and fourth jobs with the time range [1, 2] and [2, 100] can be chosen to give maximum profit of 50 + 200 = 250.

Input: jobs[][] =  [[1, 3, 60], 
                 [2, 5, 50],
                 [4, 6, 70],
                 [5, 7, 30]] 
Output: 130
Explanation: The first and third jobs with the time range [1, 3] and [4, 6] can be chosen to give maximum profit of 60 + 70 = 130.

*/
