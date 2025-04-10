//problem link  - https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTabValue=PROBLEM
import java.util.ArrayList;
import java.util.Arrays;

public class Max_Sum_of_NonAdjacent {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int indx = nums.size();
		int dp[] = new int[indx];
		Arrays.fill(dp,-1);
		return myFunc(indx-1,nums,dp);
	}
	public static int myFunc(int indx, ArrayList<Integer> nums ,  int dp[]){
		if(indx==0)return nums.get(indx);
		if(indx<0)return 0 ;
		if(dp[indx]!=-1)return dp[indx];
		int Pick =  nums.get(indx) + myFunc(indx-2, nums , dp);
		int notPick = 0 + myFunc(indx-1, nums ,dp );
		return dp[indx]=Math.max(Pick,notPick);
	}


}
