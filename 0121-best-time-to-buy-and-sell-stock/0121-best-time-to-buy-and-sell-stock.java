// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit=0, i=1, min_price=prices[0], n=prices.length;
//         while(i<n){
//             if(prices[i]<min_price) min_price=prices[i];
//             else profit=Math.max(profit, prices[i]-min_price);
//             i++;
//         }
//         return profit;
//     }
// }
class Solution {
    public int maxProfit(int[] prices) {
        int min_price = prices[0];
        int maxprof = 0;

        for(int i=0;i<prices.length;i++){
            maxprof = Math.max(maxprof,prices[i]-min_price);
            min_price = Math.min(prices[i],min_price);
        }

        return maxprof;
    }
}