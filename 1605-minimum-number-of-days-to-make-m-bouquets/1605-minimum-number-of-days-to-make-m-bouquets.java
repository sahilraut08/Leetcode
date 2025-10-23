class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min, high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        };

        return low;
    }
    private boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                count++;
            } else {
                total += (count / k);
                count = 0;
            }
        }
        total += (count / k);
        if(total >= m) return true;
        return false;
    }

}