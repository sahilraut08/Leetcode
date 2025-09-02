class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost) return -1;

        int idx = 0;
        int bal = 0;

        for(int i = 0; i < n; i++) {
            bal += gas[i] - cost[i];
            if(bal < 0) {
                idx = i + 1;
                bal = 0;
            }
        }

        return idx;
    }
}