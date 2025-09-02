class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[] = new int[n+2];
        arr[0]=arr[n+1] =1;
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];
        }
        int[][] dp= new int[n+2][n+2];
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=n; j++) {
                dp[i][j] = 0;
            }
        }
        for(int s=n;s>=1;s--){
            for(int e=1;e<=n;e++){
                if(s>e) continue;
                int max_coins=Integer.MIN_VALUE;
                for(int idx=s; idx<=e; idx++){
                    int coins=arr[s-1]*arr[idx]*arr[e+1]+dp[s][idx-1]+dp[idx+1][e];
                    max_coins=Math.max(max_coins, coins);
                }
                dp[s][e]=max_coins;
            }
        }
            return dp[1][n];
        }
    }
    // public int helper(int s, int e, int[] nums, int [][] dp){
    //     if(s>e) return 0;
    //     if(dp[s][e]!=-1) return dp[s][e];
    //     int max_coins=Integer.MIN_VALUE;
    //     for(int idx=s; idx<=e; idx++){
    //         int coins=nums[s-1]*nums[idx]*nums[e+1]+helper(s, idx-1, nums, dp)+helper(idx+1, e, nums, dp);
    //         max_coins=Math.max(max_coins, coins);
    //     }
    //     return dp[s][e]=max_coins;
    // }
