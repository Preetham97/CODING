class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        int len = beginWord.length();
        for(String word: wordList){
            for(int i = 0 ;i<len;i++){
                String key = word.substring(0,i) + "*" + word.substring(i+1, len);
                if(!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        //System.out.println(map);
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        queue.add(beginWord);
        vis.add(beginWord);
        while(queue.size()!=0){
            //System.out.println(queue);
            int size = queue.size();
            for(int i = 0; i <size;i++){
                String curr = queue.poll();
                if(curr.equals(endWord)){
                    return level+1;
                }
                for(int j = 0 ;j<len;j++){
                    String key = curr.substring(0,j) + "*" + curr.substring(j+1, len);
                    //System.out.println(key);
                    if(!map.containsKey(key))
                        continue;
                    for(String temp: map.get(key)){
                        if(!vis.contains(temp)){
                            queue.add(temp);
                            vis.add(temp);
                        }
                    }
                }
                
            }
            level+=1;
        }
        return 0;
    }
}
