//Problem Link - https://www.naukri.com/code360/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION
public class NinjasTraining {
    public static int ninjaTraining(int n, int points[][]) {

        int dp[][] = new int[n][4];
        for(int i=0 ; i<dp.length ; i++){
            for(int j = 0 ; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return myFunc(n-1,3 , points, dp);

    }
    public static int myFunc(int day, int last, int p[][], int dp[][]){
        if(day == 0){
            int maxi= Integer.MIN_VALUE;
            for(int task=0 ; task<3 ; task++){
              if(task!=last){
                maxi = Math.max(maxi,p[0][task]);
              }
            }
            return maxi;
        }
        if(dp[day][last]!=-1)return dp[day][last];
        int maxi = 0 ;
        for(int task= 0 ; task<3 ; task++){
            if(task!=last){
               int max =p[day][task] + myFunc(day-1,task,p,dp);
                maxi = Math.max(maxi,max);
            }
        }

        return dp[day][last]=maxi;
    }    
}
