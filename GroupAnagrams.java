class Solution {
    public String getKey(String key){
        int[] part = new int[26];
        for(int i=0; i<key.length();i++){
            part[key.charAt(i)-'a']+=1;
        }
        return Arrays.toString(part);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs){
            String key = getKey(str);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        for(String ent: map.keySet()){
            //List<String>ent.getValue());
            res.add(map.get(ent));
        }
        return res;
    }
}
