class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int jumps = 0;
        while(right < n - 1) {
            int max = 0;
            for(int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
            }
            left = right + 1;
            right = max;
            jumps++;
        }
        return jumps;
    }
}