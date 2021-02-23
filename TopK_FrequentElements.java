class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));
        
        for(int i: map.keySet()){
            pq.add(i);
            
            if(pq.size()>k)
                pq.poll();
        }
        
        int[] res = new int[pq.size()];
        int i = 0;
        while(pq.size()!=0)
            res[i++] = pq.poll();
        return res;
    }
}
