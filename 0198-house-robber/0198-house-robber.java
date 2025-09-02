class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int n = nums.length;
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int curr = Math.max(prev, nums[i] + prev2);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}