class MyHashSet {

    int buckets = 1000;
    int bucketItems = 1000;
    boolean [][] storage = new boolean[buckets][];

    public int hash1(int value) {
        return value%buckets;
    }

    public int hash2(int value) {
        return value/bucketItems;
    }

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            if(bucket==0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        // if(storage[bucket] != null) {
        //     if(storage[bucket][bucketItem]) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }
        return storage[bucket] != null && storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */