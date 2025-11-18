class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxPoint = 0;
        for (int[] trip : trips) {
            maxPoint = Math.max(maxPoint, trip[2]);
        }
        int[] lengthOfTrip = new int[maxPoint + 1];
        for(int trip[] : trips) {
            lengthOfTrip[trip[1]] = trip[0];
            lengthOfTrip[trip[2]] = -trip[0];
        }
        int carLoad = 0;
        for(int i = 0; i < maxPoint; i++) {
            carLoad += lengthOfTrip[i];
            if(carLoad > capacity) return false;
        }
        return true;
    }
}