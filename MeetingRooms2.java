class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
            
        });
            
            
        
     
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        int count = 1;
        pq.add(intervals[0]);
        for(int i =1;i< intervals.length; i++){
            
                int[] top = pq.peek();
                if(top[1] <= intervals[i][0]){
                    pq.poll();
                    count-=1;
                }
                
            
        
            pq.add(intervals[i]);
            count+=1;
    }
        return count;
}
}
