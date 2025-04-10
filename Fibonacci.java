class Fibonacci{
    
    // recursion
    static int printNthFib(int n){
        if(n<=1){
            return n;
        }
        return printNthFib(n-1)+printNthFib(n-2);
    }

    // Dynamic programming  Solution - 1
    //Complexity time - O(n), Space - {O(n) array  + O(n) Stack Space} = O(N)
    static int printNthFibDp(int n, int[]dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        
        dp[n]=printNthFibDp(n-1,dp)+printNthFibDp(n-2,dp);

        return dp[n];
    }

    // Dynamic programming  Solution - 2
    //Complexity time - O(n), Space -  O(1)
    static int printNthFibDp2(int n){
       int prev = 1 ; 
       int prev2 = 0 ; 
       for(int i=2 ; i<=n ; i++){
        int curr = prev+prev2;
        prev2 = prev ;
        prev = curr;
       }
       return prev ;
    }




    public static void main(String[] args) {
        System.out.println(printNthFib(4));
        int dp[] = new int[5+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(printNthFibDp(5, dp));
        System.out.println(printNthFibDp2(5));
    }
}