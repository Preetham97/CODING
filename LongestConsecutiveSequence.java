class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> vis = new HashMap<>();
        for(int i: nums)
            set.add(i);
        
        int ans = 0;
        for(int i: set){
            ans = Math.max(dfs(i, set, vis),ans);
        }
        return ans;
    }
    
    public int dfs(int num, Set<Integer> set, Map<Integer, Integer> vis){
        
        if(!set.contains(num))
            return 0;
        
        if(vis.containsKey(num))
            return vis.get(num);
        //System.out.println(num);
        int ans = 1+dfs(num+1, set, vis);
        vis.put(num, ans);
        return ans;
    }
}
