class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n-1;
        int result = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(n - mid <= citations[mid]){
                high = mid - 1;
                result = Math.max(n - mid, result);
            }
            else low = mid + 1;
        }
        return result;
    }
}