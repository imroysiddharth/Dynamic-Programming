//Problem Link - https://leetcode.com/problems/triangle/description/
import java.util.Arrays;
import java.util.List;

public class MinimumPathSumTriangle {
     public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]= new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=0 ; i<triangle.size();i++){
            Arrays.fill(dp[i],-1);
        }
        return myFunc(triangle,0,0,dp);
    }

    public int myFunc(List<List<Integer>> t , int i, int j, int[][]dp){
        if(i==t.size()-1){
            return t.get(i).get(j);
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int down =  t.get(i).get(j)+myFunc(t,i+1,j,dp);
        int dgnl = t.get(i).get(j)+myFunc(t,i+1,j+1,dp);

        dp[i][j]=Math.min(down,dgnl);
        return dp[i][j];
    }
}
