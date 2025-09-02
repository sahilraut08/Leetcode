class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = n - 1;
        if(n == 1) return true;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] + i >= max) max = i;
        }
        return max == 0;
    }
}