//Problem Link - https://leetcode.com/problems/unique-paths-ii/
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }

        return myFunc(obstacleGrid,m-1,n-1,dp);
    }
    public  int myFunc(int[][]grid ,int i , int j , int dp[][]){
        if(i==0 && j==0 )return grid[0][0] == 0 ? 1 : 0; 
        if(i<0 || j<0) return 0 ; 
        if(i>=0 && j>=0 && grid[i][j]==1)return 0 ;

        if(dp[i][j]!=-1)return dp[i][j];

        int left = myFunc(grid,i,j-1,dp);
        int up = myFunc(grid,i-1,j,dp);

        dp[i][j] = up + left ;
        return dp[i][j];
    }
}
