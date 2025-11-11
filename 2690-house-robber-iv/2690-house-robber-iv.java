class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int x : nums) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean feasible = canRob(nums, k, mid);

            if (feasible) {
                ans = mid;         
                right = mid - 1;
            } else {
                left = mid + 1;  
            }
        }

        return ans;
    }
    private boolean canRob(int[] nums, int k, int cap) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= cap) {
                count++;
                i++; 
            }
        }
        return count >= k;
    }
}