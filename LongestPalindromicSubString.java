class Solution {
    public String longestPalindrome(String s) {
        
        boolean[][] dp = new boolean[s.length()+1][s.length()];
        for(int i=0; i<s.length();i++){
            dp[1][i] = true;
        }
        
        int max= 1;
        int index = 0;
        
        for(int i=0; i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[2][i] = true;
                 max = 2;
                index = i;
            }
        }
        
        for(int len = 3; len<=s.length();len++){
            for(int i=0; i<=s.length()-len;i++){
                if(s.charAt(i) == s.charAt(i+len-1) && dp[len-2][i+1] == true){
                    max = len;
                    index = i;
                    dp[len][i] = true;
                }
            }
        }
        
        return s.substring(index, index+max);
    }
}
