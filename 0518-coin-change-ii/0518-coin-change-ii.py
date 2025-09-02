class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        col = amount + 1
        row = len(coins) + 1
        dp = [[0] * (col) for i in range(row)]

        dp[0][0] = 1
        
        for i in range(1, len(coins)+1):
            for j in range(0, amount + 1):
                if j < coins[i-1] :
                    dp[i][j] = dp[i-1][j]
                else: 
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

        return dp[row-1][col-1]