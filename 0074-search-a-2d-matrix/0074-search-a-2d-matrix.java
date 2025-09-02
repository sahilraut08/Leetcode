class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low<=high) {
            int mid = (high-low)/2 + low;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target) return true;
            if(matrix[r][c]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return false;
    }
}