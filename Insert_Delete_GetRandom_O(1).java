class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> al;
    Random rand = new Random();
    public RandomizedSet() {
        map  = new HashMap<>();
        al = new ArrayList<>(); 
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, al.size());
        al.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index = map.get(val);
        int last = al.get(al.size()-1);
        
        al.set(index, last);
        map.put(last, index);
        
        map.remove(val);
        al.remove(al.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //System.out.println(map);
        return al.get(rand.nextInt(al.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
