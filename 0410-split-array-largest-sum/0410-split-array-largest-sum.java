class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high) {
            int mid = low + (high - low)/2;
            int count = canSplit(nums, mid);
            if(count <= k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    private static int canSplit(int[] nums, int k) {
        int count = 1;
        int sum = 0;
        for(int num : nums) {
            if(num + sum <= k) {
                sum += num;
            } else {
                count++;
                sum = num;
            }
        }
        return count;
    }
}