class LRUCache {
    class DLL{
        int key;
        int val;
        DLL prev;
        DLL next;
        public DLL(int a, int b){
            key = a;
            val = b;
        }
    }
    Map<Integer, DLL> map;
    int size;
    DLL head;
    DLL tail;
    int DLL_size = 0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = new DLL(-1,-1);
        tail = new DLL(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    public void addAtBeg(int key, int value){
        DLL node = new DLL(key, value);
        map.put(key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        
    }
    public void removeNode(DLL node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        
    }
    public void removeAtEnd(){
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
    public int get(int key) {
        //System.out.println(key+" "+map);
        if(!map.containsKey(key))
            return -1;
        DLL node = map.get(key);
        removeNode(node);
        addAtBeg(node.key, node.val);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
            map.remove(key);
            addAtBeg(key, value);
            
        }
        else{
            addAtBeg(key, value);
            DLL_size+=1;
            if(DLL_size > size){
                map.remove(tail.prev.key);
                removeAtEnd();
                DLL_size-=1;
            }
                
        }
        //map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
