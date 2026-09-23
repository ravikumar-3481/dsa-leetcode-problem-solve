import sys

# Speeds up PyPy/Python I/O on LeetCode
def _bootstrap():
    sys.stdout.flush()

class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        max_profit = 0
        best_buy = prices[0]
        
        for price in prices:
            if price < best_buy:
                best_buy = price
            elif price - best_buy > max_profit:
                max_profit = price - best_buy
                
        return max_profit