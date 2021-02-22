class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i< nums.length; i++){
            if(nums[i]<=0)
                nums[i] = nums.length+1;
            //else if(nums[i]>nums.length)
        }
        
        for(int i=0; i<nums.length;i++){
            if(Math.abs(nums[i])<=nums.length){
                int index = Math.abs(nums[i])-1;
                if(nums[index]>0)
                    nums[index] = -1 * nums[index];
            }
        
        }
        // for(int i=0; i<nums.length;i++){
        //     System.out.print(nums[i]);
        // }
        for(int i=0; i<nums.length;i++){
            
            if(nums[i]>0)
                return i+1;
        }
            
        return nums.length+1;
    }
}
