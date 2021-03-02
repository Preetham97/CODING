class Solution {
     // Bottom-up Approach.
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount+1];
//         Arrays.fill(dp, amount+1);
//         dp[0]=0;
//         for(int i=1;i<=amount;i++){
//             for(int j=0;j<coins.length;j++){
//                 if(coins[j]<=i)
//                     dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
//             }
//         }
//         return dp[amount]>amount?-1:dp[amount];
//     }
    
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        
        return helper(coins, memo,  amount);
    }
    
      public int helper(int[] squares, int[] memo, int rem){
        if(rem == 0)
            return 0;
        if(rem<0)
            return -1;
        
        if(memo[rem]!=0)
            return memo[rem];
        
        int min = Integer.MAX_VALUE;
        
        for(int i: squares){
            int val = helper(squares, memo, rem-i);
            //System.out.println(val);
            if(val >= 0 && val<min){
                min = val+1;
            }
        }
        memo[rem] = (min==Integer.MAX_VALUE)? -1: min;
        
        return memo[rem];
    }
    
}
