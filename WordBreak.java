class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // if(s.length() == 0)
        //     return false;
        Set<String> set = new HashSet<>();
        
        for(String word: wordDict)
            set.add(word);
        
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int j = s.length()-1;j>=0;j--){
            for(int i = j; i<s.length();i++){
                if(set.contains(s.substring(j, i+1)) && dp[i+1] == 1)
                    dp[j] = 1;
            }
        }
        return dp[0] == 1;
    }
}
