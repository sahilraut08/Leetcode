class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int leftSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        for(int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(rightSum == leftSum) return i; 
            leftSum += nums[i];
        }
        return -1;
    }
}