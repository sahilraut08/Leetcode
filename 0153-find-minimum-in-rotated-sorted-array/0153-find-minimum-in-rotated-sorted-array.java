class Solution {
    public int findMin(int[] nums) {
        int size = nums.length;
        int low = 0;
        int high = size-1;
        while(low<high) {
            if(nums[low]<nums[high]) return nums[low];
            int mid = (high-low)/2 + low;
            if((mid==0 || nums[mid] < nums[mid-1]) && nums[mid]<nums[mid+1]) {
                return nums[mid];
            }
            else if(nums[mid] < nums[high]) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return nums[low];
    }
}