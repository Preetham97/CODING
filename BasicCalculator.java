class Solution {
    public int calculate(String s) {
        char operator = '+';
        int lastnum = 0;
        int curnum = 0;
        int res = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curnum = (curnum*10) + (ch-'0');
            }
            
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length()-1){
                if(operator == '+' || operator =='-'){
                    res+=lastnum;
                    lastnum = (operator == '+')? curnum: -curnum;
                }
                else if(operator == '*')
                    lastnum = lastnum*curnum;
                else if(operator == '/')
                    lastnum = lastnum/curnum;
                
                operator = ch;
                curnum = 0;
                
            }
        }
        res+=lastnum;
        return res;
    }
}
