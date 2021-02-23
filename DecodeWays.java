class Solution {
    public int numDecodings(String s) {
        
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return s.charAt(0) == '0'? 0:1;
        int minus2 = 1;
        int minus1 = s.charAt(0) == '0'? 0:1;
        int curr =0;
        for(int i = 1; i<s.length(); i++){
            curr = 0;
            if(s.charAt(i)!='0')
                curr+=minus1;
            int digit = Integer.valueOf(s.substring(i-1,i+1));
            if(digit>=10 && digit<=26)
                curr+=minus2;
            
            minus2 = minus1;
            minus1 = curr;
        }
        return curr;
    }
}
