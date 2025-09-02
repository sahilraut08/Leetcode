class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for(int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(sum, max);
        }
        return max/k;
    }
}