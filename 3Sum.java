class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3)
            return res;
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2){
            //System.out.println(i);
            while(i!=0 && i<nums.length-2 && nums[i]==nums[i-1])
                i++;
            int a = nums[i];
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){
                //System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0 || (j!=i+1 && nums[j] == nums[j-1]))
                    j++;
                else if(sum>0 || (k!=nums.length-1 && nums[k]==nums[k+1]))
                    k--;
                
               
                else{
                    //System.out.println(sum);
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                   
                    j++;
                    k--;
                    
                }
 
            }
            i++;
        }
        return res;
    }
}
