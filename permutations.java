class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        helper(res, new ArrayList<>(), set, nums.length);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> part, Set<Integer> set, int len){
        if(part.size() == len)
        {
            res.add(new ArrayList<>(part));
            return;
        }
        List<Integer> tmp = new ArrayList<>(set);
        for(int num: tmp){
            set.remove(num);
            part.add(num);
            helper(res, part, set, len);
            part.remove(part.size()-1);
            set.add(num);
        }
    }
}
