//Problem Link - https://leetcode.com/problems/minimum-falling-path-sum/description/


public class MinimumFallingPathSum {

    // DP approach 


    // public int minFallingPathSum(int[][] matrix) {
    //     int m = matrix.length ;
    //     int n = matrix[0].length ;
    //     int dp[][] = new int[m][n];
    //     for(int i=0; i<m ; i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     int miniSum = Integer.MAX_VALUE; 
    //     for(int j= 0 ; j<matrix[0].length ; j++){
    //         int sum = myFunc(matrix,m-1,j,dp);
    //         miniSum = Math.min(miniSum,sum);
    //     }
    //     return miniSum;
    // }

    // public int myFunc(int g[][], int i, int j , int dp[][]){
    //     if(i == 0 && j<g[0].length && j>=0)return g[i][j];

    //     if(j<0 || j>=g[0].length) return Integer.MAX_VALUE - 20000;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int down = g[i][j] + myFunc(g,i-1,j,dp);
    //     int leftD = g[i][j] + myFunc(g,i-1,j-1,dp);
    //     int rightD = g[i][j] + myFunc(g,i-1,j+1,dp);

    //     return dp[i][j]=Math.min(down,Math.min(leftD,rightD));
    // }



    // Tabulation Approach 


    public int minFallingPathSum(int[][] matrix) {
        int m= matrix.length ; 
        int n = matrix[0].length ; 

        int dp[][] = new int[m][n];

        for(int j = 0 ; j<n ; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i = 1 ; i<m ; i++){
            for(int j=0; j<n ; j++){
                int u = matrix[i][j] + dp[i-1][j];
                int ld=Integer.MAX_VALUE;
                int rd=Integer.MAX_VALUE;
                if(j>0)ld = matrix[i][j] + dp[i-1][j-1];
                if(j<n-1)rd = matrix[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.min(u,Math.min(ld,rd));
            }
        }
        int maxi = Integer.MAX_VALUE;
        for(int j = 0 ; j<n ; j++){
            maxi = Math.min(maxi,dp[m-1][j]);
        }
        return maxi ;
     }
}
