class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1];
            if(i+1 < n) {
                int num = Integer.parseInt(s.substring(i, i+2));
                if(num >= 10 && num <= 26) {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
    // private int helper(int idx, String s, int[] dp) {
    //     if(idx == s.length()) return 1;
    //     if(s.charAt(idx) == '0') return 0;
    //     if(idx == s.length() - 1) return 1;
    //     if(dp[idx] != -1) return dp[idx];
    //     int result = helper(idx+1, s, dp);
    //     if(Integer.parseInt(s.substring(idx, idx+2)) <= 26) {
    //         result += helper(idx+2, s, dp);
    //     }
    //     return dp[idx] = result;
    // }
}