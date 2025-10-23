class Solution {
private int smallestDivisorHelper(int[] arr, int div){
        int sum = 0;
        for(int j = 0; j < arr.length; j++){
            sum += Math.ceil((double)arr[j] / (double)div);
        }
        return sum;
    }

public int smallestDivisor(int[] arr, int threshold) {
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
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