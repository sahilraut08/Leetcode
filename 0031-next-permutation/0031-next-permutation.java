class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0);
            return;
        }

        for (int i = nums.length - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        reverse(nums, idx + 1);
    }

    public void reverse(int arr[], int st) {
        int i = st;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}