class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    private int helper(int[] nums, int idx, int n) {
        int prev = 0;
        int curr = 0;
        for(int i = idx; i <= n; i++) {
            int temp = Math.max(curr, nums[i] + prev);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}