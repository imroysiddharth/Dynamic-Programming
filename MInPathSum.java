//Problem Link - https://leetcode.com/problems/minimum-path-sum/
public class MInPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length ; 
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }

        return myFunc(grid, m-1,n-1,dp);

    }

    public int myFunc(int [][]grid, int i,int j, int[][]dp){
        if(i==0 && j==0 )return grid[0][0];
        if(i<0 || j<0 )return Integer.MAX_VALUE- 20000; 

        if(dp[i][j]!=-1)return dp[i][j];

        // int left =  grid[i][j] + myFunc(grid,i,j-1,dp);
        // int up =  grid[i][j] + myFunc(grid,i-1,j,dp);
        // dp[i][j] = Math.min(left,up);

        int left =   myFunc(grid,i,j-1,dp);
        int up =   myFunc(grid,i-1,j,dp);

        int min = Math.min(left,up); 
        
        if(min==Integer.MAX_VALUE) {
            /* No need to add grid[i][j] here becuse its already Int.Max value here, 
            If we add Integer overflow will happen */
            dp[i][j] = Integer.MAX_VALUE;  
        }else{
             dp[i][j] = grid[i][j] + min ;
        }
        return dp[i][j];
    }
}
