class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });

        int dp[] = new int[envelopes.length];
        dp[0]=envelopes[0][0];
        int len=1;
        for(int i = 1; i < envelopes.length; i++){
            if(envelopes[i][0]>dp[len-1]){
                dp[len]=envelopes[i][0];
                len++;
            }
            else{
                int idx = binarySearch(dp,envelopes[i][0],0,len-1);
                dp[idx]=envelopes[i][0];
            }
        }

        return len;
    }

    public int binarySearch(int arr[], int target, int low, int high){
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