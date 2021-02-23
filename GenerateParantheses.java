class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder partial = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', n);
        map.put(')', n);
        helper(res, n, partial, map);
        return res;
    }
    public void helper(List<String> res, int n, StringBuilder partial, Map<Character, Integer> map){
        // if(partial.length()>n*2)
        //     return;
        if(partial.length() == n*2){
            if(isValid(partial))
                res.add(partial.toString());
            else
                return;
        }
        else{
            //System.out.println(map);
            for(char c: map.keySet()){
                if(map.get(c)>0){
                    map.put(c, map.get(c)-1);
                    partial.append(c);
                    helper(res, n, partial, map);
                    partial.deleteCharAt(partial.length()-1);
                    map.put(c, map.get(c)+1);
                }
            }
        }
    }
    
    public boolean isValid(StringBuilder s){
        //System.out.println(s);
        Stack<Character> stack =  new Stack<>();
        
        int i = 0;
        
        while(i<s.length()){
            char c = s.charAt(i);
            if( c== '(')
                stack.push(c);
            else{
                if(stack.size() == 0)
                    return false;
                if(stack.pop() != '(')
                    return false;
            }
            i++;
        }
        if(stack.size()!= 0)
            return false;
        return true;
    }
}
