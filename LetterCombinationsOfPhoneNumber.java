class Solution {
    Map<Character, String> map = new HashMap<Character, String>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};
    public List<String> letterCombinations(String digits) {
        
        List<String> output = new ArrayList<>();
        if(digits.length() == 0)
            return output;
        
        
        helper(digits, output, new String(), 0);
        return output;
    }
    void helper(String digits, List<String> output, String part, int index){
        if(index == digits.length()){
            output.add(part);
            return ;
        }
        
        //for(int i = index; i< digits.length(); i++){
            String now = map.get(digits.charAt(index));
            for(int j = 0; j<now.length(); j++){
                helper(digits, output, part+now.charAt(j), index+1);
            }
        //}
    }
}
