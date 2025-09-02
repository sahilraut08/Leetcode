class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(kokoCheck(piles, mid, h)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private boolean kokoCheck(int[] piles, int mid, int h) {
        int time = 0;
        for(int i = 0; i < piles.length; i++) {
            time += Math.ceil((double)(piles[i]) / (double)(mid)); 
        }
        return time <= h;
    }
}