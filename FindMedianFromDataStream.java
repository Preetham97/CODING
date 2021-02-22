class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    public MedianFinder() {
        low = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(a<b)
                    return 1;
                else
                    return -1;
            }
        });
       // high = new PriorityQueue<>((a,b)->a-b);
        high = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(a<b)
                    return -1;
                else
                    return 1;
            }
        });
    }
      
     
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if(low.size()<high.size()){
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        //System.out.println(low.size()+" "+high.size());
        if(low.size()>high.size())
            return (double)low.peek();
        return ((double)low.peek()+(double)high.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
