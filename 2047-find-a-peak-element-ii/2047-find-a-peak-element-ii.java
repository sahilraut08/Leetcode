class Solution {
    public int[] findPeakGrid(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = 0;
            for (int i = 1; i < m; i++)
                if (arr[i][mid] > arr[row][mid])
                    row = i;

            int left = (mid - 1 >= 0) ? arr[row][mid - 1] : -1;
            int right = (mid + 1 < n) ? arr[row][mid + 1] : -1;

            if (arr[row][mid] > left && arr[row][mid] > right)
                return new int[]{row, mid};
            else if (arr[row][mid] < right)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return new int[]{-1, -1};
    }
}