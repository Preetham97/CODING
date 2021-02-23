class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        k = nums.length-k;
        if(k<0 || k>nums.length)
            return -1;
        while(low<=high){
            int position = partition(nums, low, high);
            //System.out.println(position+" "+ low+" "+high);
            if(position == k){
                //System.out.println("nums[0]"+ +nums[k]+" "+k);
                return nums[k];
            }
                
            else if(position<k){
                low = position+1;
                
            }else
                high = position-1;
        }
        return -1;
    }
    
    public int partition(int[] nums, int low, int high){
        
        int pivot = nums[high];
        
        int pivotlocation = low;
        
        for(int i= low; i<high;i++){
            if(nums[i]<pivot){
                int temp = nums[pivotlocation];
                nums[pivotlocation] = nums[i];
                nums[i] = temp;
                pivotlocation++;
            }
        }
        
        int temp = nums[pivotlocation];
        nums[pivotlocation] = nums[high];
        nums[high] = temp;
        
        return pivotlocation;
    }
}
