class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        
        int[] res = new int[nums.length-k+1];
        int p = 0;
        for(int i = 0; i<nums.length ; i++){
            
            while(dq.size() > 0 && dq.peek() <= i-k)
                dq.poll();
            while(dq.size() >0 && nums[dq.peekLast()]<=nums[i])
                dq.pollLast();
            
            dq.add(i);
            
            if(i>=k-1)
                res[p++] = nums[dq.peek()];
        }
        return res;
    }
}
