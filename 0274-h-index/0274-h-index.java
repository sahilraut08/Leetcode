class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int i = 0; i < n; i++) {
            int bucket = citations[i];
            if(bucket < n) buckets[bucket]++;
            else buckets[n]++;
        }

        int total = 0;
        for(int i = n; i >=0; i--) {
            total += buckets[i]; 
            if(total >= i) return i;
        }

        return 0;
    }
}