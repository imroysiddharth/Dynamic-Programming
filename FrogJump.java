//Problem Link - https://www.naukri.com/code360/problems/frog-jump_3621012?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

public class FrogJump {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int dp[]= new int[n+1];
        for(int i=0; i<=n;i++){
            dp[i]=-1;
        }

        return myfunc(n-1,heights,dp);
    }

    private static int myfunc(int indx, int[] heights , int[] dp){
        if(indx==0)return 0 ;
        if(dp[indx]!=-1)return dp[indx];
        int left = myfunc(indx-1,heights,dp)+Math.abs(heights[indx]-heights[indx-1]);
        int right = Integer.MAX_VALUE;
        if(indx>1){
            right = myfunc(indx-2, heights,dp)+Math.abs(heights[indx]-heights[indx-2]);
        }
        dp[indx] = Math.min(left,right);
        return dp[indx];
    }

    public static void main(String[] args) {
        int heights[]= {10, 20, 30, 10};
        System.out.println(frogJump(4, heights));
    }
}
