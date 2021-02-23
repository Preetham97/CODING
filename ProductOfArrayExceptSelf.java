class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0)
            return nums;
        int[] left = new int[nums.length];
        left[0] =1;
        
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        int right =1;
        for(int i=nums.length-1;i>=0;i--){
            left[i] = left[i]*right;
            right = right*nums[i];
        }
        return left;
    }
}
