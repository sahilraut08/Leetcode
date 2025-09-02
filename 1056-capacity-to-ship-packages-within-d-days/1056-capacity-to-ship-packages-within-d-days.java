class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int low = maxWeight, high = totalWeight;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int requiredDays = 1;
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return requiredDays <= days;
    }
}