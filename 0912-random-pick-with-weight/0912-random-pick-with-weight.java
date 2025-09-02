class Solution {

    private int[] nums;
    private int total;
    private Random rand;


    public Solution(int[] w) {
        this.rand = new Random();
       
       for (int i = 1; i < w.length; i++) {
           w[i] += w[i - 1];
       }
       
       this.nums = w;
       this.total = w[w.length - 1];
    }
    
    public int pickIndex() {
        int n = this.rand.nextInt(this.total) + 1;
        int low = 0, high = this.nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (this.nums[mid] == n)
                return mid;
            else if (this.nums[mid] < n)
                low = mid + 1;
            else
                high = mid; 
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */