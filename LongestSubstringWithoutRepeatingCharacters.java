class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end<s.length()){
            while(set.contains(s.charAt(end))){
                //System.out.println(start);
                set.remove(s.charAt(start));
                start+=1;
            }
            set.add(s.charAt(end));
            end+=1;
            ans = Math.max(ans, end-start);
            
        }
        return ans;
    }
}
