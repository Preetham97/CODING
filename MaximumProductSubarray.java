class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res1 =Integer.MIN_VALUE;
        int res2 =Integer.MIN_VALUE;
        int pv =0;
        int nv = 0;
        
        // left traversal
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                pv =0;
                nv =0;
            }
            else{
                if(nums[i]<0){
                    pv=0;
                    
                }
                else{
                    pv = (pv==0)? nums[i]:pv*nums[i];
                }
                   
                nv = (nv==0)? nums[i]:nv*nums[i];
            }
            res1 = Math.max(res1, (pv==0)?nv:Math.max(pv,nv));
        }
        pv=0;
        nv=0;
        //right traversal
        for(int i= nums.length-1; i>=0;i--){
            if(nums[i]==0){
                pv =0;
                nv =0;
            }
            else{
                if(nums[i]<0){
                    pv=0;
                }
                else{
                    pv = (pv==0)? nums[i]:pv*nums[i];
                }
                   
                nv = (nv==0)? nums[i]:nv*nums[i];
            }
            res2 = Math.max(res2, (pv==0)?nv:Math.max(pv,nv));
        }
        return Math.max(res1, res2);
    }
}
