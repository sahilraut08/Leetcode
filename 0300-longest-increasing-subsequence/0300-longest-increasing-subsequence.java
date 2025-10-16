class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] arr = new int[n];
        arr[0] = nums[0];
        int le = 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] > arr[le - 1]) {
                arr[le] = nums[i];
                le++;
            } else {
                int bsIdx = binarySearch(arr, 0, le - 1, nums[i]);
                arr[bsIdx] = nums[i];
            }
        }
        return le;
    }
    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}