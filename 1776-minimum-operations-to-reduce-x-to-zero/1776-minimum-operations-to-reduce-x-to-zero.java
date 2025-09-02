class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0;
        int n = nums.length;
        for(int num : nums) {
            target = target + num;
        }
        target = target - x;
        int left = 0;
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        for(int right = 0; right < n; right++) {
            currSum += nums[right];

            while(currSum > target && left <= right) {
                currSum -= nums[left];
                left++;
            }

            if(currSum == target) {
                max = Math.max(max, right - left + 1);
            }
        }
        int res;
        if(max == Integer.MIN_VALUE) {
            res = -1;
        } else {
            res = n - max;
        }
        return res;
    }
}