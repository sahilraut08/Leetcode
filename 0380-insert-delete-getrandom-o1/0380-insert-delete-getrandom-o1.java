class RandomizedSet {

    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        map.put(list.get(list.size() - 1), index);
        map.remove(val);
        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */