class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1, right = 1;
        while(right < nums.length) {
            if(nums[left - 1] == nums[right]) {
                right++;
            } else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        return left;
    }
}