class Solution {
private int smallestDivisorHelper(int[] arr, int div){
        int sum = 0;
        for(int j = 0; j < arr.length; j++){
            sum += Math.ceil((double)arr[j] / (double)div);
        }
        return sum;
    }

public int smallestDivisor(int[] arr, int threshold) {
    int max = Integer.MIN_VALUE;
    for(int num: arr) max = Math.max(max, num);
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(smallestDivisorHelper(arr, mid) <= threshold)
                high = mid - 1; 
            else
                low = mid + 1;
        }
        return low;
    }
};