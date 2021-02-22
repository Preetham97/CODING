class Solution {
    public int largestRectangleArea(int[] heights) {
        
        if(heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = -1;
        int len = heights.length;
        for(int i = 0; i<heights.length;i++){
            while(stack.size()>1 && heights[i]<=heights[stack.peek()]){
                int height = heights[stack.pop()];
                //System.out.println(stack.peek());
                res = Math.max(res, height*(i-stack.peek()-1));
                //System.out.println(stack.peek()+" " +res);
            }
            stack.push(i);
        }
        
        while(stack.size()>1){
            int height = heights[stack.pop()];
            res = Math.max(res, height*(len-stack.peek()-1));
        }
        return res;
    }
}
