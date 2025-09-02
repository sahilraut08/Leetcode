class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int rSum = 0;
        for(int i = 0; i < gain.length; i++) {
            rSum += gain[i]; 
            max = Math.max(max, rSum);
        }
        return max;
    }
}